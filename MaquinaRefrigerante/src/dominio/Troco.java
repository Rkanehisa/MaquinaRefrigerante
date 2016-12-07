package dominio;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="troco")
public class Troco 
{
	@Id
	private float valor;
	
	private int quantidade;
	
	public float GetValor()
	{
		return valor;
	}
	
	public void SetValor(float valor)
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
