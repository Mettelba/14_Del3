import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test; 

public class RaflebægerTest {
	
	Raflebæger raflebæger = new Raflebæger();

	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRaflebæger() {
		raflebæger.sætAntalsider(7);
		
			int expected = 7;
			int actual = raflebæger.hentAntalsider();
			assertEquals(expected, actual);
			
		}
		
		
	

	@Test
	public void testHentAntalsider() {
	// Denne metode bliver testet i S�tAntalsider da vi kalder metoden. 
		
	}

	@Test
	public void testSætAntalsider() {
		raflebæger.sætAntalsider(6);
		int expected = 6;
		int actual = raflebæger.hentAntalsider();
		assertEquals(expected, actual);
		
	}

	@Test
	public void testHentSum() {
	
		// denne metode bliver tester i s�tSum da vi kalder metoden hentSum.
	}

	@Test
	public void testSætSum() {
		raflebæger.sætSum(1500);
		int expected = 1500;
		int actual = raflebæger.hentSum();
		assertEquals(expected, actual);
	}

	@Test
	public void testRyst() {
		

	
	}

}
