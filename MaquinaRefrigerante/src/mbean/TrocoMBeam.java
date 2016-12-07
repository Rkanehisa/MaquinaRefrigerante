package mbean;

import java.util.List;

import dao.TrocoDAO;
import dominio.Troco;

public class TrocoMBeam {

	private static List<Troco> tabela_troco = null;
	
	private static int[] trocoArray = new int[5];
	private static int[] resultArray = new int[5];
	private static float[] values = {10.00f, 5.00f, 2.00f, 1.00f, 0.50f};
	
	
	public List<Troco> getListTroco() {
		if (tabela_troco != null) {
			return tabela_troco;
		}

		TrocoDAO dao = new TrocoDAO();
		tabela_troco = dao.getTroco();

		return tabela_troco;
	}
	
	private void InitTrocoArray()
	{
		for(int i = 0; i < 5; i++)
		{
			trocoArray[i] = tabela_troco.get(i).GetQuantidade();
		}
	}
	
	public static Boolean CalcularTroco(float valorInserido, float preco)
	{
		float trocoTotal = 0;
		for(int i = 0; i < 5; i++)
		{
			resultArray[i] = 0;
		}
		for(int i = 0; i < 5; i++)
		{
			trocoTotal += values[i] * trocoArray[i];
		}
		if (trocoTotal >= valorInserido)
		{
			if (valorInserido > preco)
			{
				valorInserido -= preco;
				for(int i = 0; i < 5; i++)
				{
					while(valorInserido >= values[i] && trocoArray[i] > 0)
					{
						valorInserido -= values[i];
						trocoArray[i] -= 1;
						resultArray[i] += 1;
					}
				}
			}
			if(valorInserido == 0)
			{
				return true;
			} else return false;
		}
		return false;
	}
	
	private void UpdateTrocoList()
	{
		for(int i = 0; i < 5; i++)
		{
			tabela_troco.get(i).SetQuantidade(tabela_troco.get(i).GetQuantidade() - resultArray[i]);
		}
	}
	
	public int[] VerificarTroco(float valorInserido, float preco)
	{
		float trocoTotal = 0;
		tabela_troco = getListTroco();
		if(tabela_troco == null)
		{
			return null;
		}
		InitTrocoArray();
		Boolean success = CalcularTroco(valorInserido, preco);
		if(success)
		{
			for(int i = 0; i < 5; i++)
			{
				trocoTotal += values[i] * resultArray[i];
			}
			if(trocoTotal == (valorInserido - preco))
			{
				UpdateTrocoList();
				return resultArray;
			}
			else return null;
		}
		return null;
	}

}
