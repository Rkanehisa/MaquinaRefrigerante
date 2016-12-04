import java.util.Arrays;

/**
 * 
 */

/**
 * @author rkanehisa
 *
 */


public class MaquinaRefrigerante {
	/**
	 * @param args
	 * @throws Exception 
	 */
	   public static void main(String[] args) {
		   MySQLAccess access = new MySQLAccess();
		   
		   
		   ControleTroco.CalcularTroco(10, 5);
		   System.out.print(Arrays.toString(ControleTroco.getResultArray()));
		   System.out.println(Arrays.toString(access.getTrocoArray()));
		   
		   
		   
	   }
}