

public class ControleTroco
{
	static MySQLAccess access = new MySQLAccess();
	private static int[] trocoArray = access.getTrocoArray();
	private static int[] resultArray = new int[5];
	private static float[] values = {10.00f, 5.00f, 2.00f, 1.00f, 0.50f};
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
				access.setTrocoArray(trocoArray);
				return true;
			} else return false;
		}
		return false;
	}
	
	public static int[] getResultArray(){
		return resultArray;
	}
}
