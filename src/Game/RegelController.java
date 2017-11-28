package Game;
import Felter.*;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

//Delegate Controller for reglerne.
//Dette er lavet for at kunne rette og tilføje regler så nemt som muligt uden at spilcontrolleren bliver bloatet.

public class RegelController {
	private Spiller[] spiller;
	private Felt[] felter;
	private GUI_Player[] guispiller;
	private GUI spilgui;
	private GUI_Field[] guifelter;

	private int prisfordobler;


	protected RegelController(Spiller[] spiller, Felt[] felter, GUI_Player[] guispiller, GUI spilgui, GUI_Field[] guifelter) {
		this.spiller = spiller;
		this.felter = felter;
		this.guispiller = guispiller;
		this.spilgui = spilgui;
		this.guifelter = guifelter;
		prisfordobler = 1; //prisfordobler bestemmer hvilket tal der ganges med i forhold til hvor meget den grundlæggende pris skal forøges når man lander på et felt
	}

	protected void flytSpiller(int aktivspiller, int position) {
		spilgui.getFields()[position].setCar(guispiller[aktivspiller], true);
	}
	
	protected void normalFeltKøbGrund(int aktivspiller, int position) {
		int feltejer = felter[spiller[aktivspiller].hentPosition()].hentEjer();
		boolean valg;

		//har aktivspiller råd til at købe det, og er feltet ejet af spillet
		if (feltejer == 0 && spiller[aktivspiller].indeståendeSpillerKonto() > felter[position].hentPris()) { 
			valg = spilgui.getUserLeftButtonPressed(felter[position].hentBeskedTekst() + " og den er til salg. vil du købe grunden ?", "Ja", "Nej");
			if (valg) {
				spiller[aktivspiller].hævPåKonto(felter[position].hentPris()); //Hæv penge på konto alt efter hvad grunden koster
				felter[position].sætEjer(aktivspiller);//sæt ny ejer af grunden.
				
				//GUI
				guispiller[aktivspiller].setBalance(spiller[aktivspiller].indeståendeSpillerKonto());
				guifelter[position].setForeGroundColor(guispiller[aktivspiller].getPrimaryColor());
			}
		}

	}

	protected void normalFeltEjetAfAnden(int aktivspiller, int position) {
		int feltnrpåpar = ((NormalFelt)felter[position]).hentPar();//Det felt som feltet danner par med
		int betalt;
		int indestående = spiller[aktivspiller].indeståendeSpillerKonto();//Den aktive spillers indestående
		int feltejer = ((NormalFelt)felter[position]).hentEjer();//ejeren af feltet den aktive spiller står på
		int tilbetaling;
		String beskedstreng;

		//Bestem prisfordobler
		if (feltejer == felter[feltnrpåpar].hentEjer()) {//Hvis ejeren af feltet også ejer den tilhørende feltpartner.
			prisfordobler = 2;
		}
		tilbetaling = felter[position].hentPris()*prisfordobler;//Hvad skal der betales
		prisfordobler = 1;//Nu er prisen til betaling regnet ud, og prisfordobler bliver sat til 1 igen.
		
		spiller[aktivspiller].hævPåKonto(tilbetaling);//Hæv penge på aktiv spillers konto.
		
		//hvis aktivspiller ikke har penge nok til at betale så betaler man det man har og går bankerot.
		if (indestående < tilbetaling) {
			spiller[feltejer].indsætPåKonto(indestående); //Ejer af felt modtager det som den aktive spiller har på sin konto.
			betalt = indestående;//Det der er betalt er det indestående på aktiv spillers konto
		}else {
			spiller[feltejer].indsætPåKonto(tilbetaling); //Ejer af felt modtager afgiften
			betalt = tilbetaling;//Det der er betalt er hvad det koster at lande på feltet
		}
		beskedstreng = felter[position].hentBeskedTekst() + ", og du skal betale " + spiller[feltejer].hentNavn() + " " + betalt + " kr i afgift.";
		if (spiller[aktivspiller].erDuBankerot() == true) {
			beskedstreng = beskedstreng + ", og du gik desværre også bankerot GAMEOVER";
		}
		
		//GUI
		spilgui.showMessage(beskedstreng + ". Tryk ok");
		guispiller[aktivspiller].setBalance(spiller[aktivspiller].indeståendeSpillerKonto());
		guispiller[feltejer].setBalance(spiller[feltejer].indeståendeSpillerKonto());
	}


	protected void togFelt(int aktivspiller, int position) {
		spiller[aktivspiller].sætEkstraTur(true); // sæt ekstratur i aktivspiller
		
		//GUI
		spilgui.showMessage(felter[position].hentBeskedTekst()+ ". Tryk ok."); //vis besked for feltet

	}

	protected void entreFelt(int aktivspiller, int position) {
		int indestående = spiller[aktivspiller].indeståendeSpillerKonto();//Hvad har spiller på konto
		int betalt;
		int tilbetaling = ((EntreFelt)felter[position]).hentPrisForEntre();//Hvad koster det konkrete entrefelt at lande på
		String beskedstreng;


		//Hvis spilleren ikke har penge nok, overføres det der står på kontoen til onkelmangepenge og spilleren går bankerot
		if (indestående < tilbetaling) {
			((OnkelMangePengeFelt) felter[Konstanter.ONKELSFELT]).sætOnkelsPenge(((OnkelMangePengeFelt) felter[Konstanter.ONKELSFELT]).hentOnkelsPenge() + indestående);
			betalt = indestående;
		} else {
			((OnkelMangePengeFelt)felter[Konstanter.ONKELSFELT]).sætOnkelsPenge(((OnkelMangePengeFelt)felter[Konstanter.ONKELSFELT]).hentOnkelsPenge() + tilbetaling);
			betalt = ((EntreFelt)felter[position]).hentPrisForEntre();
		}
		beskedstreng = felter[position].hentBeskedTekst() + " " + betalt +" kr.";
		
		spiller[aktivspiller].hævPåKonto(tilbetaling);
		if (spiller[aktivspiller].erDuBankerot()) {
			beskedstreng = beskedstreng + ", og du gik desværre også bankerot GAMEOVER";
		}	
		
		//GUI
		spilgui.showMessage(beskedstreng + ". Tryk ok.");	
		guispiller[aktivspiller].setBalance(spiller[aktivspiller].indeståendeSpillerKonto());
		spilgui.getFields()[Konstanter.ONKELSFELT].setSubText(String.valueOf((((OnkelMangePengeFelt)felter[Konstanter.ONKELSFELT]).hentOnkelsPenge()))); //overfør hvor mange penge der er på feltet til GUI feltet 
	}

	protected void onkelMangePengeFelt(int aktivspiller) {
		int pengepåfelt = ((OnkelMangePengeFelt)felter[Konstanter.ONKELSFELT]).hentOnkelsPenge();
		
		spiller[aktivspiller].indsætPåKonto(pengepåfelt);

		((OnkelMangePengeFelt)felter[Konstanter.ONKELSFELT]).sætOnkelsPenge(2);//Onkel finder en daler på gulvet da du er gået.
		
		//GUI
		spilgui.showMessage(felter[Konstanter.ONKELSFELT].hentBeskedTekst() + pengepåfelt);
		guispiller[aktivspiller].setBalance(spiller[aktivspiller].indeståendeSpillerKonto());
		spilgui.getFields()[Konstanter.ONKELSFELT].setSubText(String.valueOf((((OnkelMangePengeFelt)felter[Konstanter.ONKELSFELT]).hentOnkelsPenge()))); //overfør hvor mange penge der er på feltet til GUI feltet
	}

	protected void gåTilCafeFelt(int aktivspiller) {
		int position = spiller[aktivspiller].hentPosition();
		
		//GUI
		spilgui.showMessage(felter[position].hentBeskedTekst());
		spilgui.getFields()[position].setCar(guispiller[aktivspiller], false);
		//Flyt spiller til det nye felt
		spiller[aktivspiller].sætPosition(((GåTilCafeFelt)felter[position]).hentGåTilFeltNr());
		//GUI
		spilgui.getFields()[spiller[aktivspiller].hentPosition()].setCar(guispiller[aktivspiller], true);
	}

	protected void startFelt(int aktivspiller) {
		spiller[aktivspiller].indsætPåKonto(((StartFelt)felter[Konstanter.STARTFELT]).hentPasserStart());
		
		//GUI
		spilgui.showMessage(felter[Konstanter.STARTFELT].hentBeskedTekst() + " og får " + ((StartFelt)felter[Konstanter.STARTFELT]).hentPasserStart() + " kr.");
		guispiller[aktivspiller].setBalance(spiller[aktivspiller].indeståendeSpillerKonto());
	}
}

