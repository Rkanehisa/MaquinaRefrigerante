package dominio;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import java.util.Date;

@Entity
@Table(name="latas")
public class Latas 
{
	@Id
	private int indice;
	
	private int id_bebida;
	
	private Boolean vendido;
	
	private Date data_reposicao;
	
	public Latas(int indice, int id_bebida, Boolean vendido, Date data_reposicao)
	{
		this.indice = indice;
		this.id_bebida = id_bebida;
		this.vendido = vendido;
		this.data_reposicao = data_reposicao;
	}
	
	public int GetIndice()
	{
		return indice;
	}
	
	public void SetIndice(int indice)
	{
		this.indice = indice;
	}
	
	public int GetIdBebida()
	{
		return id_bebida;
	}
	
	public void SetIdBebida(int id_bebida)
	{
		this.id_bebida = id_bebida;
	}
	
	public Boolean GetVendido()
	{
		return vendido;
	}
	
	public void SetVendido(Boolean vendido)
	{
		this.vendido = vendido;
	}
	
	public Date GetDataReposicao()
	{
		return data_reposicao;
	}
	
	public void SetDataReposicao(Date data_reposicao)
	{
		this.data_reposicao = data_reposicao;
	}
	
}
