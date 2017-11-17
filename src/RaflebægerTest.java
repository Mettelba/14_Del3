import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test; 

public class RaflebægerTest {
	
	
	
	Raflebæger raflebæger = new Raflebæger(6);

	

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
		raflebæger.sætAntalsider(12);
		int expected = 12;
		int actual = raflebæger.hentAntalsider();
		assertEquals("HentAntalSider-metoden virker ikke", expected, actual);
	}

	@Test
	public void testSætAntalsider() {
		raflebæger.sætAntalsider(6);
		int expected = 6;
		int actual = raflebæger.hentAntalsider();
		assertEquals(expected, actual);
		
	}  
 
	@Test
	public void testHentTerning1værdi() {
		raflebæger.sætTerning1værdi(8);
		int expected = 8;
		int actual = raflebæger.hentTerning1værdi();
		assertEquals("metoden hentTerning virker ikke", expected, actual);
	}


	@Test
	public void testRyst() {
		int[] statistik = new int[7];
		for(int n=1; n<600000; n=n+1) {
			raflebæger.ryst();
			int sum = raflebæger.hentTerning1værdi();
			statistik[sum] = statistik[sum]+1;
		}
		for(int x=1; x<=6; x=x+1) {
			System.out.println("terning1 " + x+"ere = " + statistik[x]);
		}	
	}
}
