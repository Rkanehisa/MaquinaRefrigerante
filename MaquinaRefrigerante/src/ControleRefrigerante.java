
public class ControleRefrigerante 
{
	public static Refrigerante GetRefriFromDatabase(String nome)
	{
		//Insert Refrigerante database query here when it's done.
		//Something like this:
		//Refrigerante refri = access.GetRefri(nome);
		Refrigerante refri = new Refrigerante("Crystal Pepsi", 10.00f);
		return refri;
	}
	
	public static void SubtractRefriFromDatabase(String nome)
	{
		//TODO Method that deducts Refrigerante from database.
	}
	
	
	
}
