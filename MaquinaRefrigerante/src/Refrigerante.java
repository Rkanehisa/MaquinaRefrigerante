import java.lang.String;
public class Refrigerante
{
	private String name;
	private float value;
	
	public Refrigerante(String name, float value)
	{
		this.name = name;
		this.value = value;
	}
	
	public String GetName()
	{
		return this.name;
	}
	
	public float GetValue()
	{
		return this.value;
	}
}
