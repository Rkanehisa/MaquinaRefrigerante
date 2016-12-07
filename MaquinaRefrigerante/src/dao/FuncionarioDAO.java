package dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import dominio.Funcionario;

public class FuncionarioDAO extends DAO
{
	public List<Funcionario> getFuncionario()
	{
		Criteria c = getSession().createCriteria(Funcionario.class);
		
		//c.add();//Still have no idea how to use this.
		
		return c.list();
	}
}