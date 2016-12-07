package dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import dominio.Latas;

public class LatasDAO extends DAO
{
	public List<Latas> getLatas()
	{
		Criteria c = getSession().createCriteria(Latas.class);
		
		//c.add();//Not sure how to use this.
		
		return c.list();
	}
}

