package mbean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.LatasDAO;
import dominio.Latas;
import dominio.Troco;

import java.util.Date;
import java.util.LinkedList;

public class LatasMBeam {

	private static List<Latas> latas = new LinkedList<Latas>();

	public static List<Latas> getListLatas() throws SQLException {
		if (!latas.isEmpty()) {
			return latas;
		}
		MySQLAccess access = new MySQLAccess();
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

}
