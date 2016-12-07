package mbean;

import java.util.List;

import dao.TrocoDAO;
import dominio.Troco;

public class TrocoMBeam {

	private List<Troco> tabela_troco = null;

	public List<Troco> getListTroco() {
		if (tabela_troco != null) {
			return tabela_troco;
		}

		TrocoDAO dao = new TrocoDAO();
		tabela_troco = dao.getTroco();

		return tabela_troco;
	}

}
