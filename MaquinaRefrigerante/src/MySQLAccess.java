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
	   
	   //Busca os valores de troco do banco de dados
	   public int[] getTrocoArray(){ 
		   Connection conn = null;
		   Statement stmt = null;
		   int[] troco = new int[5];
		   try{
			   //STEP 2: Register JDBC driver
			   Class.forName("com.mysql.jdbc.Driver");
			      
			   //STEP 3: Open a connection
			   conn = DriverManager.getConnection(this.DB_URL, this.USER, this.PASS);
			   
			   //STEP 4: Execute a query
			   stmt = (Statement) conn.createStatement();
			   String sql = "SELECT Quantidade FROM Troco";
			   ResultSet rs = stmt.executeQuery(sql);
			   int i = 0;
			   while(rs.next()){
				   //Retrieve by column name
				   int quantidade = rs.getInt("Quantidade");
				   
				   troco[i] = quantidade;
				   i += 1;
			   }
			   
			   rs.close();
	
		   }
		   catch(SQLException se){
			   //Handle errors for JDBC
			   se.printStackTrace();
		   }
		   catch(Exception e){
			   //Handle errors for Class.forName
			   e.printStackTrace();
		   }
		   finally{
			   //finally block used to close resources
			   try{
				   if(stmt!=null)
					   conn.close();
			   }
			   catch(SQLException se){ }// do nothing
			   try{
				   if(conn!=null)
					   conn.close();
				   }
			   catch(SQLException se){
				   se.printStackTrace();
				   }
		   }
		   return troco;
	   }
	   
	   public void setTrocoArray(int[] trocoArray){ 
		   Connection conn = null;
		   Statement stmt = null;
		   
		   try{
			   //STEP 2: Register JDBC driver
			   Class.forName("com.mysql.jdbc.Driver");
			      
			   //STEP 3: Open a connection
			   conn = DriverManager.getConnection(this.DB_URL, this.USER, this.PASS);
			   
			   //STEP 4: Execute a query
			   stmt = (Statement) conn.createStatement();
			   String sql = "UPDATE Troco SET Quantidade=? WHERE Valor = ?";
			   PreparedStatement preparedStmt = conn.prepareStatement(sql);
			   preparedStmt.setInt(1,trocoArray[0]);
			   preparedStmt.setFloat(2,10);
			   preparedStmt.executeUpdate();

			   preparedStmt.setInt(1,trocoArray[1]);
			   preparedStmt.setFloat(2,5);
			   preparedStmt.executeUpdate();
			   
			   preparedStmt.setInt(1,trocoArray[2]);
			   preparedStmt.setFloat(2,2);
			   preparedStmt.executeUpdate();
			   
			   preparedStmt.setInt(1,trocoArray[3]);
			   preparedStmt.setFloat(2,1);
			   preparedStmt.executeUpdate();
			   
			   preparedStmt.setInt(1,trocoArray[4]);
			   preparedStmt.setFloat(2, (float) 0.5);
			   preparedStmt.executeUpdate();

			   conn.close();
			   
		   }
		   catch(SQLException se){
			   //Handle errors for JDBC
			   se.printStackTrace();
		   }
		   catch(Exception e){
			   //Handle errors for Class.forName
			   e.printStackTrace();
		   }
		   finally{
			   //finally block used to close resources
			   try{
				   if(stmt!=null)
					   conn.close();
			   }
			   catch(SQLException se){ }// do nothing
			   try{
				   if(conn!=null)
					   conn.close();
				   }
			   catch(SQLException se){
				   se.printStackTrace();
				   }
		   }
	   }
}
