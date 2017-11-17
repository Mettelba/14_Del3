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
	public void testHentøjne() {
		terning.sætøjne(5);
		int expected = 5;
		int actual = terning.hentøjne();
		assertEquals(expected, actual);
		
	}

	@Test
	public void testSætøjne() {
		// denne metode bliver testet i hent�jne, 
	}

	@Test
	public void testHentSider() {
		
		int expected = 6;
		int actual = terning.hentSider();
		assertEquals(expected, actual);
		
	}

	@Test
	public void testSætSider() {
		terning.sætSider(12);
		int expected = 12;
		int actual = terning.hentSider();
		assertEquals(expected, actual);
		
	}

	@Test
	public void testTerning() {
		
	}

	@Test
	public void testKast() {
		
	}

}
