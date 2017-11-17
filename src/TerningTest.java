import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TerningTest {
	
	Terning terning = new Terning(6);

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
	public void testTerning() {
		terning.sætØjne(3);
		int expected = 3;
		int actual = terning.hentØjne();
		assertEquals("objektet terning er ikke oprettet", expected, actual);
	}

	@Test
	public void testKast() {
		int[] statistik = new int[7];
		for(int n=1; n<600000; n=n+1) {
			terning.kast();
			int sum = terning.hentØjne();
			statistik[sum] = statistik[sum]+1;
		}
		for(int x=1;x<=6;x=x+1) {
			System.out.println(x+"'ere = "+ statistik[x]);		
		}
	}

	@Test
	public void testHentøjne() {
		terning.sætØjne(5);
		int expected = 5;
		int actual = terning.hentØjne();
		assertEquals("terningens øjne stemmer ikke overens", expected, actual);
	}


	@Test
	public void testHentSider() {
		terning.sætSider(5);
		int expected = 5;
		int actual = terning.hentSider();
		assertEquals("hentSider virker ikke", expected, actual);
	}

	@Test
	public void testSætSider() {
		terning.sætSider(8);
		int expected = 8;
		int actual = terning.hentSider();
		assertEquals("sætSider virker ikke", expected, actual);
	} 

	@Test
	public void testSætøjne() {
		terning.kast();
		System.out.println("Terningens kast er: " + terning.hentØjne());
		terning.sætØjne(4);
		int expected = 4;
		int actual = terning.hentØjne();
		assertEquals("sætØjne virker ikke", expected, actual);
		System.out.println("Terningen er sat til: " + terning.hentØjne());	
	}
	
}
