import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class KontoTest {
	
	Konto konto = new Konto ();
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		konto.sætVærdi(1000);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testKonto() {
		
	}

	@Test
	public void testHentVærdi() {
		int expected = 1000;
		int actual = 1000;
		assertEquals(expected, actual);
		
	}

	@Test
	public void testSætVærdi() {
		konto.sætVærdi(500);
		int expected = 500;
		int actual = konto.hentVærdi();
		assertEquals("balancen matcher ikke ",expected, actual);
	}

	@Test
	public void testCheckMinus() {
		
	konto.checkMinus(-2000);
	int expected = 0;
	int actual = konto.hentVærdi();
	assertEquals(expected, actual);
	
	
	}

	@Test
	public void testIndsæt() {
		konto.indsæt(-1001);
		int expected = 0;
		int actual = konto.hentVærdi();
		assertEquals(expected, actual);
		
	}

}
