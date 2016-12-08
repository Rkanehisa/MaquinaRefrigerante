package mbean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.FuncionarioDAO;
import dominio.Bebidas;
import dominio.Funcionario;

public class FuncionarioMBeam {

	private List<Funcionario> funcionarios = null;

	public List<Funcionario> getListFuncionarios() throws SQLException {
		if (funcionarios != null) {
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
