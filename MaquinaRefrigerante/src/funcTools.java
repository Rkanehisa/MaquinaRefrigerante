import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import mbean.*;
import dominio.*;

public class funcTools {
	
	public static void createLog() throws SQLException{
		double total = 0;
		HashMap hm = new HashMap<>();
		
		List<Latas> latas = LatasMBeam.FilterSoldLatas(LatasMBeam.getListLatas());
		
		MySQLAccess access = new MySQLAccess();
		access.openConnection();
		 
		ResultSet rs = access.makeQuery("SELECT * FROM bebidas");
		while (rs.next()) {
			hm.put(rs.getInt("indice"),rs.getDouble("preco"));
		}		
		
		rs.close();
		
		
		try{
			PrintWriter writer = new PrintWriter("log.txt", "UTF-8");
		    for(int i = 0; i < latas.size();i++){
				total += (double) hm.get(latas.get(i).GetIdBebida());
	    		writer.println(hm.get(latas.get(i).GetIdBebida()));	
	    	}
		    writer.println(total);
		    writer.close();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
