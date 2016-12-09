package mbean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dao.FuncionarioDAO;
import dominio.Bebidas;
import dominio.Funcionario;

public class FuncionarioMBeam {


	public static boolean getListFuncionarios(String login, String senha) throws SQLException {
		
		MySQLAccess access = new MySQLAccess();
		access.openConnection();
		ResultSet rs = access.makeQuery("SELECT * FROM funcionario WHERE login='" + login + "' AND senha='" + senha + "';");
		
		if(rs.next())
		{
			rs.close();
			access.closeConnection();
			return true;
		}
		else{
			rs.close();
			access.closeConnection();
			return false;
		}
	}
	


}
