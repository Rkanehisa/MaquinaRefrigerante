package mbean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySQLAccess {
	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/MaquinaRefrigerante?autoReconnect=true&useSSL=false";

	   //  Database credentials
	   static final String USER = "admin";
	   static final String PASS = "admin";
	   
	   private Connection conn = null;
	   private Statement stmt = null;
	   
	   public void openConnection(){
		   this.conn = null;
		   this.stmt = null;
		   try{
			   //STEP 2: Register JDBC driver
			   Class.forName("com.mysql.jdbc.Driver");
			      
			   //STEP 3: Open a connection
			   conn = DriverManager.getConnection(this.DB_URL, this.USER, this.PASS);
			   
		   }
		   catch(SQLException se){
			   //Handle errors for JDBC
			   se.printStackTrace();
		   }
		   catch(Exception e){
			   //Handle errors for Class.forName
			   e.printStackTrace();
		   }
	   }
	   
	   public void UpdateDB(String sql) throws SQLException{
		   try{
			   stmt = this.conn.createStatement();
			   stmt.executeUpdate(sql);
			   stmt.close();
		   }
		   catch (Exception e){
			   e.printStackTrace();
		   }
	   }
	   
	   public ResultSet makeQuery(String sql) throws SQLException{
		   try{
			   this.stmt = (Statement) this.conn.createStatement();
			   ResultSet rs = stmt.executeQuery(sql);
		
			   return rs;
	   
		   }
		   catch (Exception e){
			   e.printStackTrace();
		   }
		return null;
	   }

	   public void closeResultSet(ResultSet rs) throws SQLException{
		   rs.close();
	   }
	   
	   public void closeConnection() throws SQLException{
		   this.conn.close();
	   }
}
