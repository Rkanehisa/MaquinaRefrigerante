package mbean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.BebidasDAO;
import dominio.Bebidas;
import dominio.Troco;

public class BebidasMBeam {

	private List<Bebidas> bebidas = null;

	public List<Bebidas> getListBebidas() throws SQLException {
		if (bebidas != null) {
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

		return bebidas;
	}

}
