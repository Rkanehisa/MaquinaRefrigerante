package mbean;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import org.junit.Test;

import dominio.Troco;

public class TrocoMBeamTest {

	@Test
	public void testRestocarTroco() throws SQLException 
	{
		TrocoMBeam.clearTabelaTroco();
		MySQLAccess access = new MySQLAccess();
		access.openConnection();
		String sql = "UPDATE troco SET quantidade=0";
		access.UpdateDB(sql);
		access.closeConnection();
		
		int total = 0;
		
		for(int i = 1; i<100; i++)
		{
			assertTrue(TrocoMBeam.addTroco(i, 0.5));
			assertTrue(TrocoMBeam.addTroco(i, 1));
			assertTrue(TrocoMBeam.addTroco(i, 2));
			assertTrue(TrocoMBeam.addTroco(i, 5));
			assertTrue(TrocoMBeam.addTroco(i, 10));
			total += i;
		}
		access.openConnection();
		ResultSet rs = access.makeQuery("SELECT * FROM troco");
		while(rs.next())
		{
			int quantidade = rs.getInt("quantidade");
			assertEquals(quantidade, total, 0);
		}	
	}
	
	@Test
	public void testRestocarTrocoValorNegativoEVazio() throws SQLException 
	{
		TrocoMBeam.clearTabelaTroco();
		MySQLAccess access = new MySQLAccess();
		access.openConnection();
		String sql = "UPDATE troco SET quantidade=0";
		access.UpdateDB(sql);
		access.closeConnection();
				
		assertFalse(TrocoMBeam.addTroco(-1, 0.5));
		assertFalse(TrocoMBeam.addTroco(-1, 1));
		assertFalse(TrocoMBeam.addTroco(-1, 2));
		assertFalse(TrocoMBeam.addTroco(-1, 5));
		assertFalse(TrocoMBeam.addTroco(-1, 10));
		assertFalse(TrocoMBeam.addTroco(0, 0.5));
		assertFalse(TrocoMBeam.addTroco(0, 1));
		assertFalse(TrocoMBeam.addTroco(0, 2));
		assertFalse(TrocoMBeam.addTroco(0, 5));
		assertFalse(TrocoMBeam.addTroco(0, 10));
		
		access.openConnection();
		ResultSet rs = access.makeQuery("SELECT * FROM troco");
		while(rs.next())
		{
			int quantidade = rs.getInt("quantidade");
			assertEquals(quantidade, 0, 0);
		}
		
		
	}
	
	@Test
	public void testVerificarTrocoParaPagamentoExatoEQuandoNaoTemTrocoNaMaquina() throws SQLException 
	{
		TrocoMBeam.clearTabelaTroco();
		MySQLAccess access = new MySQLAccess();
		access.openConnection();
		String sql = "UPDATE troco SET quantidade=0";
		access.UpdateDB(sql);
		access.closeConnection();
		
		int[] trocoList;
		double trocoVal;
		for(double i = 0; i<100; i++)
		{
			trocoList = TrocoMBeam.VerificarTroco(i, i);
			trocoVal = trocoList[4]*0.5 + trocoList[3]*1 + trocoList[2]*2 + trocoList[1]*5 + trocoList[0]*10;
			assertEquals(5, trocoList.length);
			assertEquals(0, trocoVal, 0);
		}
		
		
	}
	@Test
	public void testVerificarPagandoMaisQueOSuficiente() throws SQLException 
	{
		TrocoMBeam.clearTabelaTroco();
		MySQLAccess access = new MySQLAccess();
		access.openConnection();
		String sql = "UPDATE troco SET quantidade=0";
		access.UpdateDB(sql);
		access.closeConnection();
		
		Random rand = new Random();
		
		TrocoMBeam.addTroco(9999, 0.5);
		TrocoMBeam.addTroco(9999, 1);
		TrocoMBeam.addTroco(9999, 2);
		TrocoMBeam.addTroco(9999, 5);
		TrocoMBeam.addTroco(9999, 10);
		
		
		int[] trocoList;
		double trocoVal;
		for(int i = 0; i<100; i++)
		{
			int x = rand.nextInt(100) + 100;
			int y = rand.nextInt(100);
			trocoList = TrocoMBeam.VerificarTroco(x, y);
			
			assertEquals(5, trocoList.length);
			trocoVal = trocoList[4]*0.5 + trocoList[3]*1 + trocoList[2]*2 + trocoList[1]*5 + trocoList[0]*10;
			assertEquals(x-y, trocoVal, 0);
			
		}
	}
	
	@Test
	public void testVerificarTrocoPagandoMenosQueOSuficiente() throws SQLException 
	{
		TrocoMBeam.clearTabelaTroco();
		MySQLAccess access = new MySQLAccess();
		access.openConnection();
		String sql = "UPDATE troco SET quantidade=0";
		access.UpdateDB(sql);
		access.closeConnection();
		
		Random rand = new Random();
		
		TrocoMBeam.addTroco(9999, 0.5);
		TrocoMBeam.addTroco(9999, 1);
		TrocoMBeam.addTroco(9999, 2);
		TrocoMBeam.addTroco(9999, 5);
		TrocoMBeam.addTroco(9999, 10);
		
		
		int[] trocoList;
		for(int i = 0; i<100; i++)
		{
			int x = rand.nextInt(100);
			int y = rand.nextInt(100) + 100;
			trocoList = TrocoMBeam.VerificarTroco(x, y);
			
			assertNull(trocoList);
			
		}
	}
	
	@Test
	public void testVerificarTrocoQuandoForImpossivelMontarTroco() throws SQLException 
		{
			TrocoMBeam.clearTabelaTroco();
			MySQLAccess access = new MySQLAccess();
			access.openConnection();
			String sql = "UPDATE troco SET quantidade = 0;";
			access.UpdateDB(sql);
			access.closeConnection();			
			
			int[] trocoList;
			for(int i = 0; i<100; i++)
			{
				trocoList = TrocoMBeam.VerificarTroco(i+1, i);
				assertNull(trocoList);		
			}
	}
	
	@Test
	public void testVerificarTrocoQuandoReceberNegativo() throws SQLException 
		{
			TrocoMBeam.clearTabelaTroco();
			MySQLAccess access = new MySQLAccess();
			access.openConnection();
			String sql = "UPDATE troco SET quantidade = 0;";
			access.UpdateDB(sql);
			access.closeConnection();			
			
			int[] trocoList;
			for(int i = 0; i>-100; i--)
			{
				trocoList = TrocoMBeam.VerificarTroco(i, 1);
				assertNull(trocoList);		
			}
	}

}
