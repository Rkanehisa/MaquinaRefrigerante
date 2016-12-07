package dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import dominio.Bebidas;

public class BebidasDAO extends DAO{
	public List<Bebidas> getBebidas(){
		Criteria c = getSession().createCriteria(Bebidas.class);
		
		c.add(Restrictions.eq("indice",1));
		
		return c.list();
	}
}
