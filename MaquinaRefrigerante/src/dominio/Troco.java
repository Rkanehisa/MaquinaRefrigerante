package dominio;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="troco")
public class Troco 
{
	@Id
	private double valor;
	
	private int quantidade;
	
 	public Troco(double valor, int quantidade)
	{
		this.valor = valor;
		this.quantidade = quantidade;
	}
	
	public double GetValor()
	{
		return valor;
	}
	
	public void SetValor(double valor)
	{
		this.valor = valor;
	}
	
	public int GetQuantidade()
	{
		return quantidade;
	}
	
	public void SetQuantidade(int quantidade)
	{
		this.quantidade = quantidade;
	}
	
}
