package mbean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dao.BebidasDAO;
import dominio.Bebidas;
import dominio.Troco;

public class BebidasMBeam {

	private List<Bebidas> bebidas = new LinkedList<Bebidas>();

	public List<Bebidas> getListBebidas() throws SQLException {
		if (!bebidas.isEmpty()) {
			return bebidas;
		}
		MySQLAccess access = new MySQLAccess();
		access.openConnection();
		ResultSet rs = access.makeQuery("SELECT * FROM bebidas");
		while(rs.next())
		{
			int indice = rs.getInt("indice");
			String nome = rs.getString("nome");
			double preco = rs.getDouble("preco");
			Bebidas bebida = new Bebidas(indice, nome, preco);
			bebidas.add(bebida);
		}
		rs.close();
		access.closeConnection();
		return bebidas;
	}

	public static int getBebidaIndex(String name) throws SQLException{
		MySQLAccess access = new MySQLAccess();
		access.openConnection();
		String sql = String.format("SELECT indice FROM bebidas WHERE nome = '%s' ",name);
		ResultSet rs = access.makeQuery(sql);
		if(rs.next()){
			return rs.getInt("indice");
		}
		else{
			return -1;
		}
		
	}
	
	public static double getBebidaPreco(String name) throws SQLException{
		MySQLAccess access = new MySQLAccess();
		access.openConnection();
		String sql = String.format("SELECT preco FROM bebidas WHERE nome = '%s' ",name);
		ResultSet rs = access.makeQuery(sql);
		if(rs.next()){
			return rs.getDouble("preco");
		}
		else{
			return -1;
		}
		
	}
	
}
