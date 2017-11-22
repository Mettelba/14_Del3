package Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import Felter.Felt;
import Game.Spilbræt;
import Game.Spiller;


public class SpilbrætTest {
	private Spiller[] spiller = new Spiller[1];

	
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
	public void testHentSpilGui() {
		
			}

	@Test
	public void testHentSpilFelter() {
		
	
		
	}

	@Test
	public void testHentType() {
		
		spiller[0] = new Spiller();
		Spilbræt spillebræt = new Spilbræt(spiller);
		Felt[] felter;
		felter = spillebræt.hentSpilFelter();
		
		int expected = 2;
		int actual = felter[15].hentFeltType();
		assertEquals("der er noget galt med felttypen",expected, actual);
		// Testet med felter ( 5, 12, 15, 21)

	}
}

