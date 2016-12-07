package mbean;

import java.util.List;

import dao.FuncionarioDAO;
import dominio.Funcionario;

public class FuncionarioMBeam {

	private List<Funcionario> funcionarios = null;

	public List<Funcionario> getListFuncionarios() {
		if (funcionarios != null) {
			return funcionarios;
		}

		FuncionarioDAO dao = new FuncionarioDAO();
		funcionarios = dao.getFuncionario();

		return funcionarios;
	}

}
