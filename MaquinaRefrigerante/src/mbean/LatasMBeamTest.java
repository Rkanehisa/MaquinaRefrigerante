package mbean;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import dominio.Troco;

public class LatasMBeamTest {
	
	
	@Test
	public void testRestocarLatas() throws SQLException 
	{
		MySQLAccess access = new MySQLAccess();
		
		access.openConnection();
		String sql = "TRUNCATE latas";
		access.UpdateDB(sql);
		access.closeConnection();
		
		int quantidade = 5;
		int lata = BebidasMBeam.getBebidaIndex("Coca Cola");
		assertTrue(LatasMBeam.inserirLatas(quantidade, lata));
		
		lata = BebidasMBeam.getBebidaIndex("Pepsi");
		assertTrue(LatasMBeam.inserirLatas(quantidade, lata));
		
		lata = BebidasMBeam.getBebidaIndex("Mtn. Dew");
		assertTrue(LatasMBeam.inserirLatas(quantidade, lata));
		
		lata = BebidasMBeam.getBebidaIndex("Soylent Green");
		assertTrue(LatasMBeam.inserirLatas(quantidade, lata));
		
		lata = BebidasMBeam.getBebidaIndex("Crystal Pepsi");
		assertTrue(LatasMBeam.inserirLatas(quantidade, lata));
		
		lata = BebidasMBeam.getBebidaIndex("Doctor Pepper");
		assertTrue(LatasMBeam.inserirLatas(quantidade, lata));
		
		access.openConnection();
		ResultSet rs = access.makeQuery("SELECT * FROM latas");
		double valor = 0;
		while(rs.next())
		{
			valor += 1;
		}
		
		assertEquals(quantidade*6, valor, 0);
		
	}
	
	@Test
	public void testRestocarLatasValorNegativoOuNulo() throws SQLException 
	{
		MySQLAccess access = new MySQLAccess();
		
		access.openConnection();
		String sql = "TRUNCATE latas";
		access.UpdateDB(sql);
		access.closeConnection();
		
		int quantidade = -5;
		int lata = BebidasMBeam.getBebidaIndex("Coca Cola");
		assertFalse(LatasMBeam.inserirLatas(quantidade, lata));
		
		lata = BebidasMBeam.getBebidaIndex("Pepsi");
		assertFalse(LatasMBeam.inserirLatas(quantidade, lata));
		
		lata = BebidasMBeam.getBebidaIndex("Mtn. Dew");
		assertFalse(LatasMBeam.inserirLatas(quantidade, lata));
		
		lata = BebidasMBeam.getBebidaIndex("Soylent Green");
		assertFalse(LatasMBeam.inserirLatas(quantidade, lata));
		
		lata = BebidasMBeam.getBebidaIndex("Crystal Pepsi");
		assertFalse(LatasMBeam.inserirLatas(quantidade, lata));
		
		lata = BebidasMBeam.getBebidaIndex("Doctor Pepper");
		assertFalse(LatasMBeam.inserirLatas(quantidade, lata));
		
		quantidade = 0;
		lata = BebidasMBeam.getBebidaIndex("Coca Cola");
		assertFalse(LatasMBeam.inserirLatas(quantidade, lata));
		
		lata = BebidasMBeam.getBebidaIndex("Pepsi");
		assertFalse(LatasMBeam.inserirLatas(quantidade, lata));
		
		lata = BebidasMBeam.getBebidaIndex("Mtn. Dew");
		assertFalse(LatasMBeam.inserirLatas(quantidade, lata));
		
		lata = BebidasMBeam.getBebidaIndex("Soylent Green");
		assertFalse(LatasMBeam.inserirLatas(quantidade, lata));
		
		lata = BebidasMBeam.getBebidaIndex("Crystal Pepsi");
		assertFalse(LatasMBeam.inserirLatas(quantidade, lata));
		
		lata = BebidasMBeam.getBebidaIndex("Doctor Pepper");
		assertFalse(LatasMBeam.inserirLatas(quantidade, lata));
		
		access.openConnection();
		ResultSet rs = access.makeQuery("SELECT * FROM latas");
		
		double valor = 0;
		while(rs.next())
		{
			valor += 1;
		}
		
		assertEquals(0, valor, 0);
		
	}
	
	@Test
	public void testComprarBebida() throws SQLException 
	{
		MySQLAccess access = new MySQLAccess();
		
		access.openConnection();
		
		String sql = "TRUNCATE latas";
		access.UpdateDB(sql);
		sql = "INSERT INTO latas VALUES (1,1,'2016-08-03 00:00:00',0)";
		access.UpdateDB(sql);
		
		TrocoMBeam.clearTabelaTroco();
		sql = "UPDATE troco SET quantidade=0";
		access.UpdateDB(sql);
		
		access.closeConnection();
		
		assertTrue(TrocoMBeam.addTroco(99, 0.5));
		assertTrue(TrocoMBeam.addTroco(99, 1));
		assertTrue(TrocoMBeam.addTroco(99, 2));
		assertTrue(TrocoMBeam.addTroco(99, 5));
		assertTrue(TrocoMBeam.addTroco(99, 10));
		
		int[] ret = LatasMBeam.sellLata("Coca Cola", 100);
		double trocoVal = ret[4]*0.5 + ret[3]*1 + ret[2]*2 + ret[1]*5 + ret[0]*10;
		assertEquals(trocoVal, 100-8.5, 0);
	}
	
	@Test
	public void testComprarBebidaInexistente() throws SQLException 
	{
		MySQLAccess access = new MySQLAccess();
		
		access.openConnection();
		String sql = "TRUNCATE latas";
		access.UpdateDB(sql);
		access.closeConnection();
		
		int[] ret = LatasMBeam.sellLata("Coca Cola", 100);
		assertEquals(ret[0], -2, 0);
	}
	
	@Test
	public void testComprarBebidaQuente() throws SQLException 
	{
		MySQLAccess access = new MySQLAccess();
		
		access.openConnection();
		String sql = "TRUNCATE latas";
		access.UpdateDB(sql);
		access.closeConnection();
		
		int lata = BebidasMBeam.getBebidaIndex("Coca Cola");
		assertTrue(LatasMBeam.inserirLatas(1, lata));
		
		int[] ret = LatasMBeam.sellLata("Coca Cola", 100);
		assertEquals(ret[0], -2, 0);
	}

}
