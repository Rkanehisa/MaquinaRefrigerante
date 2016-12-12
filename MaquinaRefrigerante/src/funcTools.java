import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import mbean.*;
import dominio.*;

public class funcTools {
	
	public static void createLog() throws SQLException
	{	
		
		try{
			MySQLAccess access = new MySQLAccess();
			access.openConnection();
			ResultSet rs;
			PrintWriter writer = new PrintWriter("log.txt", "UTF-8");
			
			writer.println("Latas vendidas:");
		    rs = access.makeQuery("SELECT COUNT(*),id_bebida,nome FROM latas,bebidas WHERE latas.id_bebida = bebidas.indice AND vendido=1 GROUP BY bebidas.indice,bebidas.nome;");
			while(rs.next()){
				writer.println(String.format("-%s: %d", rs.getString("nome"),rs.getInt("COUNT(*)")));
			}
			
			
		    rs = access.makeQuery("SELECT SUM(preco) FROM bebidas,latas WHERE bebidas.indice = latas.id_bebida AND vendido=1;");
		    rs.next();
		    
		    writer.println(String.format("\nValor total vendido: R$ %.2f\n",rs.getDouble("SUM(preco)")));
		    
		    writer.println("Estoque total de latas:");
		    
			rs = access.makeQuery("SELECT COUNT(*),id_bebida,nome FROM latas,bebidas WHERE latas.id_bebida = bebidas.indice AND vendido=0 GROUP BY bebidas.indice,bebidas.nome;");
			while(rs.next()){
				writer.println(String.format("-%s: %d", rs.getString("nome"),rs.getInt("COUNT(*)")));
			}
			
			writer.println("\nTroco restante:");
			
			rs = access.makeQuery("SELECT * FROM troco;");
			while(rs.next()){
				writer.println(String.format("R$ %.2f: %d",rs.getDouble("valor"),rs.getInt("quantidade")));
			}
			
		    writer.close();
		    rs.close();
			access.closeConnection();
		}
		
		
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
}
