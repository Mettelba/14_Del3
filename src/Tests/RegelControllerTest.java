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
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

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
		Spilbræt spillebræt = new Spilbræt(spiller);
		Felt[] felter;
		GUI_Player[] guispiller;
		GUI spilgui;
		GUI_Field[] guifelter;
		RegelController regler;
		felter = spillebræt.hentSpilFelter();
		spilgui = spillebræt.hentSpilGui();
		felter = spillebræt.hentSpilFelter();
		guispiller = spillebræt.hentGUISpiller();
		guifelter = spillebræt.hentGUIfelter();
		regler = new RegelController(spiller, felter, guispiller, spilgui, guifelter);
		
	}

	@Test
	public void testNormalFeltKøbGrund() {
		Spiller[] spiller = new Spiller[2];
		Spilbræt spillebræt = new Spilbræt(spiller);
		Felt[] felter;
		GUI_Player[] guispiller;
		GUI spilgui;
		GUI_Field[] guifelter;
		RegelController regler;
		felter = spillebræt.hentSpilFelter();
		spilgui = spillebræt.hentSpilGui();
		felter = spillebræt.hentSpilFelter();
		guispiller = spillebræt.hentGUISpiller();
		guifelter = spillebræt.hentGUIfelter();
		regler = new RegelController(spiller, felter, guispiller, spilgui, guifelter);
		
		
		//Her køber jeg min grund med kontrolleren.

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
		Spilbræt spillebræt = new Spilbræt(spiller);
		Felt[] felter;
		GUI_Player[] guispiller;
		GUI spilgui;
		GUI_Field[] guifelter;
		RegelController regler;
		felter = spillebræt.hentSpilFelter();
		spilgui = spillebræt.hentSpilGui();
		felter = spillebræt.hentSpilFelter();
		guispiller = spillebræt.hentGUISpiller();
		guifelter = spillebræt.hentGUIfelter();
		regler = new RegelController(spiller, felter, guispiller, spilgui, guifelter);
		
		regler.normalFeltKøbGrund(1, 1);
		int expected = 1;
		int actual = felter[1].hentEjer();
		assertEquals(expected, actual);
		
	}

	@Test
	public void testTogFelt() {
		Spiller[] spiller = new Spiller[2];
		Spilbræt spillebræt = new Spilbræt(spiller);
		Felt[] felter;
		GUI_Player[] guispiller;
		GUI spilgui;
		GUI_Field[] guifelter;
		RegelController regler;
		felter = spillebræt.hentSpilFelter();
		spilgui = spillebræt.hentSpilGui();
		felter = spillebræt.hentSpilFelter();
		guispiller = spillebræt.hentGUISpiller();
		guifelter = spillebræt.hentGUIfelter();
		regler = new RegelController(spiller, felter, guispiller, spilgui, guifelter);
		
	
		((TogFelt)felter[3]).hentEkstraTur();
		boolean expected = true;
		boolean actual = ((TogFelt)felter[3]).hentEkstraTur();
		assertEquals(expected, actual);
		
	}

	@Test
	public void testFyrværkeriDelfinCafeFelt() {
		Spiller[] spiller = new Spiller[2];
		Spilbræt spillebræt = new Spilbræt(spiller);
		Felt[] felter;
		GUI_Player[] guispiller;
		GUI spilgui;
		GUI_Field[] guifelter;
		RegelController regler;
		felter = spillebræt.hentSpilFelter();
		spilgui = spillebræt.hentSpilGui();
		felter = spillebræt.hentSpilFelter();
		guispiller = spillebræt.hentGUISpiller();
		guifelter = spillebræt.hentGUIfelter();
		regler = new RegelController(spiller, felter, guispiller, spilgui, guifelter);
		
		regelcontroller.entreFelt(1, 3);
		((EntreFelt)felter[3]).hentPrisForEntre();
		int expected = 2;
		int actual = ((EntreFelt)felter[3]).hentPrisForEntre();
		assertEquals(expected, actual);
		
		
		
	}

	@Test
	public void testOnkelMangePengeFelt() {
		Spiller[] spiller = new Spiller[2];
		Spilbræt spillebræt = new Spilbræt(spiller);
		Felt[] felter;
		GUI_Player[] guispiller;
		GUI spilgui;
		GUI_Field[] guifelter;
		RegelController regler;
		felter = spillebræt.hentSpilFelter();
		spilgui = spillebræt.hentSpilGui();
		felter = spillebræt.hentSpilFelter();
		guispiller = spillebræt.hentGUISpiller();
		guifelter = spillebræt.hentGUIfelter();
		regler = new RegelController(spiller, felter, guispiller, spilgui, guifelter);
		
		regelcontroller.onkelMangePengeFelt(1);
		((OnkelMangePengeFelt)felter[12]).hentBeskedTekst();
		String expected = "Du er på besøg hos Onkel Mangepenge, og han giver dig det han har i lommen. Du får ";
		String actual = ((OnkelMangePengeFelt)felter[12]).hentBeskedTekst();
		assertEquals(expected, actual);
		
		
		
	}
	

	@Test
	public void testGåPåCafeFelt() {
		Spiller[] spiller = new Spiller[2];
		Spilbræt spillebræt = new Spilbræt(spiller);
		Felt[] felter;
		GUI_Player[] guispiller;
		GUI spilgui;
		GUI_Field[] guifelter;
		RegelController regler;
		felter = spillebræt.hentSpilFelter();
		spilgui = spillebræt.hentSpilGui();
		felter = spillebræt.hentSpilFelter();
		guispiller = spillebræt.hentGUISpiller();
		guifelter = spillebræt.hentGUIfelter();
		regler = new RegelController(spiller, felter, guispiller, spilgui, guifelter);
		
		regelcontroller.gåTilCafeFelt(1, 9);
		((GåTilCafeFelt)felter[9]).hentPris();
		int expected = 2;
		int actual = ((GåTilCafeFelt)felter[9]).hentPris();
		assertEquals(expected, actual);
		
	}

	@Test
	public void testStartFelt() {
		Spiller[] spiller = new Spiller[2];
		Spilbræt spillebræt = new Spilbræt(spiller);
		Felt[] felter;
		GUI_Player[] guispiller;
		GUI spilgui;
		GUI_Field[] guifelter;
		RegelController regler;
		felter = spillebræt.hentSpilFelter();
		spilgui = spillebræt.hentSpilGui();
		felter = spillebræt.hentSpilFelter();
		guispiller = spillebræt.hentGUISpiller();
		guifelter = spillebræt.hentGUIfelter();
		regler = new RegelController(spiller, felter, guispiller, spilgui, guifelter);
		
		regelcontroller.startFelt(1);
		((StartFelt)felter[0]).hentBeskedTekst();
		String expected = "Du har passeret start og får";
		String actual = ((StartFelt)felter[0]).hentBeskedTekst();
		assertEquals(expected, actual);
		
	}

}
