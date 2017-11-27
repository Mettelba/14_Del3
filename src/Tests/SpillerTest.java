package Tests;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Game.Spiller;

public class SpillerTest {
	Spiller spiller = new Spiller();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Spiller spiller = new Spiller();
		spiller.sætNavn("Rasmus");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSpiller() {
		 Spiller spiller = new Spiller();
		 
	}

	@Test
	public void testHentNavn() {
		spiller.sætNavn("Rasmus");
		String expected = "Rasmus";
		String actual = spiller.hentNavn();
		assertEquals(expected, actual);
		
		
		
	}

	@Test
	public void testSætNavn() {
		spiller.sætNavn("kurt");
		String expected = "kurt";
		String actual = spiller.hentNavn();
		assertEquals(expected, actual);
		
	}

	@Test
	public void testhævPåKonto() {
		spiller.indsætPåKonto(1000);
		spiller.hævPåKonto(1001);
		boolean expected = true;
		boolean actual = spiller.erDuBankerot();
		assertEquals(expected, actual);	
		
	}

	@Test
	public void testErDuBankerot() {
		spiller.erDuBankerot();
		boolean expected = false;
		boolean actual = spiller.erDuBankerot();
		assertEquals(expected, actual);
		
		
	}

	@Test
	public void testIndeståendeSpillerKonto() {
	spiller.indsætPåKonto(10);
	int expected = 10;
	int actual = spiller.indeståendeSpillerKonto();
	assertEquals(expected, actual);
	}

	@Test
	public void testSætKontoVærdi() {
		spiller.indsætPåKonto(40);
		int expected = 40;
		int actual = spiller.indeståendeSpillerKonto();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHævKontoVærdi() {
		spiller.indsætPåKonto(50);
		spiller.hævPåKonto(50);
		int expected = 0;
		int actual = spiller.indeståendeSpillerKonto();
		assertEquals(expected, actual);
	}

	@Test
	public void testToString() {
	// Ingen test her, da den streng den skal skrive ud, kan være hvad som helst.
	}

	@Test
	public void testHentPosition() {
		spiller.hentPosition();
		int expected = 0;
		int actual = spiller.hentPosition();
		assertEquals(expected, actual);
		
		
	}

	@Test
	public void testSætPosition() {
		spiller.sætPosition(5);
		int expected = 5;
		int actual = spiller.hentPosition();
		assertEquals(expected, actual);
		
	}

}
