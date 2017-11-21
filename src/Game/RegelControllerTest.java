package Game;
import Felter.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Felter.Felt;

public class RegelControllerTest {
	
	

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
	public void testRegelController() {
		fail("Not yet implemented");
	}

	@Test
	public void testNormalFeltKøbGrund() {
		Spiller[] spiller = new Spiller[2];
		spiller[0] = new Spiller();
		spiller[1] = new Spiller();
		Spilbræt spilbræt = new Spilbræt(spiller);
		Felt felter;
		
		//felter = spilbræt.hentSpilFelter();
		//RegelController regelcontroller = new RegelController(spiller, felter);
		//	regelcontroller.normalFeltKøbGrund(1, 1);
	;
		
	}

	@Test
	public void testNormalFeltEjetAfAnden() {
		fail("Not yet implemented");
	}

	@Test
	public void testTogFelt() {
		fail("Not yet implemented");
	}

	@Test
	public void testFyrværkeriDelfinCafeFelt() {
		fail("Not yet implemented");
	}

	@Test
	public void testOnkelMangePengeFelt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGåPåCafeFelt() {
		fail("Not yet implemented");
	}

	@Test
	public void testStartFelt() {
		fail("Not yet implemented");
	}

}
