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
		   ResultSet rs = access.makeQuery("SELECT quantidade FROM troco");
		   while(rs.next() ){
			   System.out.println(rs.getInt("quantidade"));
		   }
		   access.closeResultSet(rs);
	   }
}

