package mbean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dao.FuncionarioDAO;
import dominio.Bebidas;
import dominio.Funcionario;

public class FuncionarioMBeam {

	private List<Funcionario> funcionarios = new LinkedList<Funcionario>();

	public List<Funcionario> getListFuncionarios() throws SQLException {
		if (!funcionarios.isEmpty()) {
			return funcionarios;
		}
		MySQLAccess access = new MySQLAccess();
		access.openConnection();
		ResultSet rs = access.makeQuery("SELECT * FROM funcionario");
		while(rs.next())
		{
			int indice = rs.getInt("indice");
			String login = rs.getString("login");
			String senha = rs.getString("senha");
			Funcionario funcionario = new Funcionario(indice, login, senha);
			funcionarios.add(funcionario);
		}

		return funcionarios;
	}

}
