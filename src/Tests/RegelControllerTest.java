package Tests;
import Felter.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Felter.Felt;
import Game.RegelController;
import Game.Spilbræt;
import Game.Spiller;

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
		Felt[] felter;
		felter = spilbræt.hentSpilFelter();
		RegelController regelcontroller = new RegelController(spiller, felter);
		
		//Her køber jeg min grund med kontrolleren.
		regelcontroller.normalFeltKøbGrund(1, 1);
		felter[1].hentEjer();
		
		
		int expected = 1;
		int actual = felter[1].hentEjer();
		System.out.println(actual);
		System.out.println(felter[1].hentEjer());
		assertEquals(expected, actual);
		
		
	}

	@Test
	public void testNormalFeltEjetAfAnden() {
		Spiller[] spiller = new Spiller[2];
		spiller[0] = new Spiller();
		spiller[1] = new Spiller();
		Spilbræt spilbræt = new Spilbræt(spiller);
		Felt[] felter;
		felter = spilbræt.hentSpilFelter();
		RegelController regelcontroller = new RegelController(spiller, felter);
		
		regelcontroller.normalFeltEjetAfAnden(0, 1);
		int expected = 0;
		int actual = felter[1].hentEjer();
		assertEquals(expected, actual);
		
	}

	@Test
	public void testTogFelt() {
		Spiller[] spiller = new Spiller[2];
		spiller[0] = new Spiller();
		spiller[1] = new Spiller();
		Spilbræt spilbræt = new Spilbræt(spiller);
		Felt[] felter;
		felter = spilbræt.hentSpilFelter();
		RegelController regelcontroller = new RegelController(spiller, felter);
		
		regelcontroller.togFelt(1);
		felter[3].hentEkstraTur();
		boolean expected = true;
		boolean actual = felter[3].hentEkstraTur();
		assertEquals(expected, actual);
		
	}

	@Test
	public void testFyrværkeriDelfinCafeFelt() {
		Spiller[] spiller = new Spiller[2];
		spiller[0] = new Spiller();
		spiller[1] = new Spiller();
		Spilbræt spilbræt = new Spilbræt(spiller);
		Felt[] felter;
		felter = spilbræt.hentSpilFelter();
		RegelController regelcontroller = new RegelController(spiller, felter);
		
		regelcontroller.fyrværkeriDelfinCafeFelt(1, 3);
		felter[3].hentPrisForEntre();
		int expected = 2;
		int actual = felter[3].hentPrisForEntre();
		assertEquals(expected, actual);
		
		
		
	}

	@Test
	public void testOnkelMangePengeFelt() {
		Spiller[] spiller = new Spiller[2];
		spiller[0] = new Spiller();
		spiller[1] = new Spiller();
		Spilbræt spilbræt = new Spilbræt(spiller);
		Felt[] felter;
		felter = spilbræt.hentSpilFelter();
		RegelController regelcontroller = new RegelController(spiller, felter);
	}

	@Test
	public void testGåPåCafeFelt() {
		Spiller[] spiller = new Spiller[2];
		spiller[0] = new Spiller();
		spiller[1] = new Spiller();
		Spilbræt spilbræt = new Spilbræt(spiller);
		Felt[] felter;
		felter = spilbræt.hentSpilFelter();
		RegelController regelcontroller = new RegelController(spiller, felter);
	}

	@Test
	public void testStartFelt() {
		Spiller[] spiller = new Spiller[2];
		spiller[0] = new Spiller();
		spiller[1] = new Spiller();
		Spilbræt spilbræt = new Spilbræt(spiller);
		Felt[] felter;
		felter = spilbræt.hentSpilFelter();
		RegelController regelcontroller = new RegelController(spiller, felter);fail("Not yet implemented");
	}

}
