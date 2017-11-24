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
		Spiller[] spiller = new Spiller[2];
		Spilbræt spilbræt = new Spilbræt(spiller);
		Felt[] felter;
		felter = spilbræt.hentSpilFelter();
		RegelController regelcontroller = new RegelController(spiller, felter);
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
		
		regelcontroller.normalFeltEjetAfAnden(1, 1);
		int expected = 1;
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
		((TogFelt)felter[3]).hentEkstraTur();
		boolean expected = true;
		boolean actual = ((TogFelt)felter[3]).hentEkstraTur();
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
		
		regelcontroller.entreFelt(1, 3);
		((EntreFelt)felter[3]).hentPrisForEntre();
		int expected = 2;
		int actual = ((EntreFelt)felter[3]).hentPrisForEntre();
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
		
		regelcontroller.onkelMangePengeFelt(1);
		((OnkelMangePengeFelt)felter[12]).hentBeskedTekst();
		String expected = "Du er på besøg hos Onkel Mangepenge, og han giver dig det han har i lommen. Du får ";
		String actual = ((OnkelMangePengeFelt)felter[12]).hentBeskedTekst();
		assertEquals(expected, actual);
		
		
		
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
		
		regelcontroller.gåTilCafeFelt(1, 9);
		((GåTilCafeFelt)felter[9]).hentPris();
		int expected = 2;
		int actual = ((GåTilCafeFelt)felter[9]).hentPris();
		assertEquals(expected, actual);
		
	}

	@Test
	public void testStartFelt() {
		Spiller[] spiller = new Spiller[2];
		spiller[0] = new Spiller();
		spiller[1] = new Spiller();
		Spilbræt spilbræt = new Spilbræt(spiller);
		Felt[] felter;
		felter = spilbræt.hentSpilFelter();
		RegelController regelcontroller = new RegelController(spiller, felter);
		
		regelcontroller.startFelt(1);
		((StartFelt)felter[0]).hentBeskedTekst();
		String expected = "Du har passeret start og får";
		String actual = ((StartFelt)felter[0]).hentBeskedTekst();
		assertEquals(expected, actual);
		
	}

}
