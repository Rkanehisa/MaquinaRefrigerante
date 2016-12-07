import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
		   MySQLAccess access = new MySQLAccess();
		   access.openConnection();
		   ResultSet rs = access.makeQuery("SELECT * FROM troco");
		   while(rs.next() ){
			   double valor = rs.getDouble("valor");
			   int quantidade = rs.getInt("quantidade");
			   System.out.println(valor + ": " + quantidade);
		   }
		   access.closeResultSet(rs);
		   access.closeConnection();
	   }
}

