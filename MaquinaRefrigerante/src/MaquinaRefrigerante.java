import java.util.List;
import dominio.Troco;
import mbean.TrocoMBeam;

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
		 
		   TrocoMBeam t = new TrocoMBeam();
		   List<Troco> l = t.getListTroco();
		   System.out.println(l.toString());
		   
		   
	   }
}