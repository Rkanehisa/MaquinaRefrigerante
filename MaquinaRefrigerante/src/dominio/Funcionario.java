package dominio;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="funcionario")
public class Funcionario
{
	@Id
	private int indice;
	
	private String login;
	
	private String senha;//Not the best practice.
	
	public Funcionario(int indice, String login, String senha)
	{
		this.indice = indice;
		this.login = login;
		this.senha = senha;
	}
	
	public int GetIndice()
	{
		return indice;
	}
	
	public void SetIndice(int indice)
	{
		this.indice = indice;
	}
	
	public String GetLogin()
	{
		return login;
	}
	
	public void SetLogin(String login)
	{
		this.login = login;
	}
	
	public String GetSenha()
	{
		return senha;
	}
	
	public void SetSenha(String senha)
	{
		this.senha = senha;
	}
	
	//kek	
}
 