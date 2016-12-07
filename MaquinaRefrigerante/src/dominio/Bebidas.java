package dominio;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name="bebidas")
public class Bebidas {
	
	@Id
	private int indice;
	
	private String nome;
	
	private double preco;
	
	public Bebidas(int indice, String nome, double preco)
	{
		this.indice = indice;
		this.nome = nome;
		this.preco = preco;
	}
	
	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
