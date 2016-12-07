package mbean;

import java.util.List;

import dao.LatasDAO;
import dominio.Latas;

public class LatasMBeam {

	private List<Latas> latas = null;

	public List<Latas> getListLatas() {
		if (latas != null) {
			return latas;
		}

		LatasDAO dao = new LatasDAO();
		latas = dao.getLatas();

		return latas;
	}

}
