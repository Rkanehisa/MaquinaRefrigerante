package dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import dominio.Troco;

public class TrocoDAO extends DAO
{
	public List<Troco> getTroco()
	{
		Criteria c = getSession().createCriteria(Troco.class);
		
		c.add();//Still have no idea how to use this.
		
		return c.list();
	}
}

