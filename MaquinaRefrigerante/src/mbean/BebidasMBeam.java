package mbean;

import java.util.List;

import dao.BebidasDAO;
import dominio.Bebidas;

public class BebidasMBeam {

	private List<Bebidas> bebidas = null;

	public List<Bebidas> getListBebidas() {
		if (bebidas != null) {
			return bebidas;
		}

		BebidasDAO dao = new BebidasDAO();
		bebidas = dao.getBebidas();

		return bebidas;
	}

}
