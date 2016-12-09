package mbean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Statement;

import dao.LatasDAO;
import dominio.Latas;
import dominio.Troco;

import java.util.Date;
import java.util.LinkedList;

public class LatasMBeam {
	private static MySQLAccess access = new MySQLAccess();
	
	private static List<Latas> latas = new LinkedList<Latas>();

	public static List<Latas> getListLatas() throws SQLException {
		if (!latas.isEmpty()) {
			return latas;
		}
		
		access.openConnection();
		ResultSet rs = access.makeQuery("SELECT * FROM latas");
		while(rs.next())
		{
			int indice = rs.getInt("indice");
			int id_bebida = rs.getInt("id_bebida");
			Boolean vendido = rs.getBoolean("vendido");
			Date data_reposicao= rs.getDate("data_reposicao");
			Latas lata = new Latas(indice, id_bebida, vendido, data_reposicao);
			latas.add(lata);
		}
		
		access.closeConnection();
		rs.close();
		return latas;
	}
	
	private static boolean isRefrigerated(Date lata, long now)
	{
		if(now >= lata.getTime()) return true; else return false;
	}
	
	public static List<Latas> FilterSellableLatas(List<Latas> latas)
	{
		if(latas.isEmpty()) return latas;
		
		long now = System.currentTimeMillis() - 1800000L;
		List<Latas> filtered_latas = new LinkedList<Latas>();
		for(int i = 0; i < latas.size(); i++)
		{
			if(!latas.get(i).GetVendido() && isRefrigerated(latas.get(i).GetDataReposicao(), now))
			{
				filtered_latas.add(latas.get(i));
			}
		}
		return filtered_latas;
	}
	
	public static List<Latas> FilterSoldLatas(List<Latas> latas)
	{
		if (latas.isEmpty()) return latas;
		
		List<Latas> filtered_latas = new LinkedList<Latas>();
		for(int i = 0; i < latas.size(); i++)
		{
			if(latas.get(i).GetVendido())
			{
				filtered_latas.add(latas.get(i));
			}
		}
		return filtered_latas;
	}
	
	public static void setSoldLata(int indice) throws SQLException{
		access.openConnection();
		access.UpdateDB("UPDATE latas SET vendido=1 WHERE indice="+String.valueOf(indice));
		access.closeConnection();
	}
	
	public static void addLatas(Latas l) throws SQLException{
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(l.GetDataReposicao());
		String sql = String.format("INSERT INTO latas VALUES (%d,%d,'%s',0);",l.GetIndice(),l.GetIdBebida(),currentTime);
		
		access.openConnection();
		access.UpdateDB(sql);
		access.closeConnection();
	}
	
	public static void RemoveSoldLatas() throws SQLException{
		access.openConnection();
		access.UpdateDB("DELETE FROM latas WHERE vendido=1");
		access.closeConnection();
	}
	
	public static int getMaxIndex() throws SQLException{
		MySQLAccess access = new MySQLAccess();
		access.openConnection();
		ResultSet rs = access.makeQuery("SELECT MAX(indice) FROM latas");
		if(rs.next()){
			int indice = rs.getInt("MAX(indice)");
			rs.close();
			access.closeConnection();
			return indice;
		}
		rs.close();
		access.closeConnection();
		return -1;
	}
	
	public static double sellLata(String bebida,double valorRecebido) throws SQLException{
		Date agora = new Date();
		MySQLAccess access = new MySQLAccess();
		access.openConnection();
		ResultSet rs;
		
		int indexBebida = BebidasMBeam.getBebidaIndex(bebida);
		if(valorRecebido >= BebidasMBeam.getBebidaPreco(bebida)){
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentTime = sdf.format(agora);
			
			
			String sql = String.format("SELECT * FROM latas WHERE id_bebida = %d AND (data_reposicao + INTERVAL 30 MINUTE) <= '%s' AND vendido = 0;",indexBebida,currentTime);
			rs = access.makeQuery(sql);
			if(rs.next()){
				int indice = rs.getInt("indice");
				setSoldLata(indice);
				rs.close();
				
				rs = access.makeQuery(String.format("SELECT preco FROM bebidas WHERE indice=%d",indexBebida));
				rs.next();
				double troco = valorRecebido - rs.getDouble("preco");
				rs.close();
				access.closeConnection();
				return troco;
			}
			else{
				System.out.println(String.format("Não há latas de %s disponíveis para a venda",bebida));
				return 0;
			}
		}
		else{
			System.out.println(String.format("Valor insuficiente para a compra",bebida));
			return 0;
			
		}
		
	}
}
