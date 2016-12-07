package mbean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.LatasDAO;
import dominio.Latas;
import dominio.Troco;

import java.util.Date;

public class LatasMBeam {

	private List<Latas> latas = null;

	public List<Latas> getListLatas() throws SQLException {
		if (latas != null) {
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
	
		return latas;
	}

}
