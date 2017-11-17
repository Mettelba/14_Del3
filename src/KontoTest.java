import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class KontoTest {
	Konto konto = new Konto(31);
	

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
		Konto konto = new Konto(31);
		
	}

	@Test
	public void testHentVærdi() {
		   int actual = 1000;
		int expected = konto.hentVærdi();
		assertEquals(expected, actual);
		
		
				
	}

	@Test
	public void testSætVærdi() {
		   konto.sætVærdi(500);
		   int actual = 500;
		   int expected = konto.hentVærdi();
		   assertEquals(expected, actual);
		   
	}

	@Test
	public void testCheckMinus() {
       konto.sætVærdi(1000);
       konto.checkMinus(-1001);
       
       int expected = 0;
       int actual = konto.hentVærdi();
       assertEquals(expected, actual);
       
       konto.sætVærdi(1000);
       boolean expected1 = true;
       boolean actual1 = konto.checkMinus(-1001);
       assertEquals(expected1, actual1);
       
	}

	@Test
	public void testIndsæt() {
		konto.sætVærdi(1000);
		konto.indsæt(-1001);
		int expected = 0;
		int actual = konto.hentVærdi();
		assertEquals(expected, actual);
		
		
	}

}
