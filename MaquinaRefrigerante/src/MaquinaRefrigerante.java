import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dominio.Latas;
import mbean.*;

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
	 * @throws SQLException 
	 * @throws Exception 
	 */
	
	
	   public static void main(String[] args) throws SQLException {
		   java.util.Date dt = new java.util.Date();

		   java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		   Latas l = new Latas(0,1,false,dt);
		   System.out.println(sdf.format(l.GetDataReposicao()));
		   LatasMBeam.addLatas(l);
		   
	   }
}

