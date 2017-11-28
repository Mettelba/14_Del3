package Game;
import Felter.*;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;


public class RegelController {
	private Spiller[] spiller;
	private Felt[] felter;
	private GUI_Player[] guispiller;
	private GUI spilgui;
	private GUI_Field[] guifelter;

	private int prisfordobler;


	public RegelController(Spiller[] spiller, Felt[] felter, GUI_Player[] guispiller, GUI spilgui, GUI_Field[] guifelter) {
		this.spiller = spiller;
		this.felter = felter;
		this.guispiller = guispiller;
		this.spilgui = spilgui;
		this.guifelter = guifelter;
		prisfordobler = 1;
	}

	public void normalFeltKøbGrund(int aktivspiller, int position) {
		int feltejer = felter[spiller[aktivspiller].hentPosition()].hentEjer();
		boolean valg;

		if (feltejer == 0 && spiller[aktivspiller].indeståendeSpillerKonto() > felter[position].hentPris()) {  //har aktivspiller råd til at købe det, og er feltet ejet af spillet
			valg = spilgui.getUserLeftButtonPressed(felter[position].hentBeskedTekst() + " og den er til salg. vil du købe grunden ?", "Ja", "Nej");
			if (valg) {
				felter[position].sætEjer(aktivspiller);
				spiller[aktivspiller].hævPåKonto(felter[position].hentPris());
				guispiller[aktivspiller].setBalance(spiller[aktivspiller].indeståendeSpillerKonto());
				guifelter[position].setForeGroundColor(guispiller[aktivspiller].getPrimaryColor());
			}
		}

	}

	public void normalFeltEjetAfAnden(int aktivspiller, int position) {

		int feltnrpåpar = ((NormalFelt)felter[position]).hentPar();//Feltets par
		int betalt;
		int indestående = spiller[aktivspiller].indeståendeSpillerKonto();//Den aktive spillers indestående
		int feltejer = ((NormalFelt)felter[position]).hentEjer();//ejeren af feltet den aktive spiller står på
		String beskedstreng;

		//Bestem prisfordobler
		if (feltejer == felter[feltnrpåpar].hentEjer()) {//Hvis ejeren af feltet også ejer den tilhørende feltpartner.
			prisfordobler = 2;
		}
		int tilbetaling = felter[position].hentPris()*prisfordobler;
		prisfordobler = 1;//Nu er prisen til betaling regnet ud, og prisfordobler bliver sat til 1 igen.
		
		spiller[aktivspiller].hævPåKonto(tilbetaling);
		//hvis aktivspiller ikke har penge nok til at betale så betaler man det man har og går bankerot.
		if (indestående < tilbetaling) {
			spiller[feltejer].indsætPåKonto(indestående); //Ejer af felt modtager det som den aktive spiller har på sin konto.
			betalt = indestående;
		}else {
			spiller[feltejer].indsætPåKonto(tilbetaling);
			betalt = tilbetaling;
		}
		beskedstreng = felter[position].hentBeskedTekst() + ", og du skal betale " + spiller[feltejer].hentNavn() + " " + betalt + " kr i afgift.";
		if (spiller[aktivspiller].erDuBankerot() == true) {
			beskedstreng = beskedstreng + ", og du gik desværre også bankerot GAMEOVER";
		}
		
		spilgui.showMessage(beskedstreng + ". Tryk ok");
		guispiller[aktivspiller].setBalance(spiller[aktivspiller].indeståendeSpillerKonto());
		guispiller[feltejer].setBalance(spiller[feltejer].indeståendeSpillerKonto());
	}


	public void togFelt(int aktivspiller, int position) {
		spilgui.showMessage(felter[position].hentBeskedTekst()+ ". Tryk ok.");
		spiller[aktivspiller].sætEkstraTur(true);
	}

	public int entreFelt(int aktivspiller, int position) {
		int indestående = spiller[aktivspiller].indeståendeSpillerKonto();
		int betalt;
		int tilbetaling = ((EntreFelt)felter[position]).hentPrisForEntre();
		String beskedstreng;


		//Hvis spilleren ikke har penge nok, overføres det der står på kontoen til onkelmangepenge og spilleren går bankerot
		if (indestående < tilbetaling) {
			((OnkelMangePengeFelt) felter[Konstanter.ONKELSFELT]).sætOnkelsPenge(((OnkelMangePengeFelt) felter[Konstanter.ONKELSFELT]).hentOnkelsPenge() + indestående);
			betalt = indestående;
		} else {
			((OnkelMangePengeFelt)felter[Konstanter.ONKELSFELT]).sætOnkelsPenge(((OnkelMangePengeFelt)felter[Konstanter.ONKELSFELT]).hentOnkelsPenge() + tilbetaling);
			betalt = ((EntreFelt)felter[position]).hentPrisForEntre();
		}
		beskedstreng = felter[position].hentBeskedTekst() + betalt+" kr.";
		
		spiller[aktivspiller].hævPåKonto(tilbetaling);
		if (spiller[aktivspiller].erDuBankerot()) {
			beskedstreng = beskedstreng + ", og du gik desværre også bankerot GAMEOVER";
		}	
		spilgui.showMessage(beskedstreng + ". Tryk ok.");	
		guispiller[aktivspiller].setBalance(spiller[aktivspiller].indeståendeSpillerKonto());
		spilgui.getFields()[Konstanter.ONKELSFELT].setSubText(String.valueOf((((OnkelMangePengeFelt)felter[Konstanter.ONKELSFELT]).hentOnkelsPenge()))); //overfør hvor mange penge der er på feltet til GUI feltet 
		return betalt;
	}

	public void onkelMangePengeFelt(int aktivspiller) {
		int pengepåfelt = ((OnkelMangePengeFelt)felter[Konstanter.ONKELSFELT]).hentOnkelsPenge();
		
		spiller[aktivspiller].indsætPåKonto(pengepåfelt);

		((OnkelMangePengeFelt)felter[Konstanter.ONKELSFELT]).sætOnkelsPenge(2);//Onkel finder en daler på gulvet da du er gået.
		spilgui.showMessage(felter[Konstanter.ONKELSFELT].hentBeskedTekst() + pengepåfelt);
		guispiller[aktivspiller].setBalance(spiller[aktivspiller].indeståendeSpillerKonto());
		spilgui.getFields()[Konstanter.ONKELSFELT].setSubText(String.valueOf((((OnkelMangePengeFelt)felter[Konstanter.ONKELSFELT]).hentOnkelsPenge()))); //overfør hvor mange penge der er på feltet til GUI feltet
	}

	public void gåTilCafeFelt(int aktivspiller) {
		int position = spiller[aktivspiller].hentPosition();
		spilgui.showMessage(felter[position].hentBeskedTekst());
		spilgui.getFields()[position].setCar(guispiller[aktivspiller], false);
		spiller[aktivspiller].sætPosition(((GåTilCafeFelt)felter[position]).hentGåTilFeltNr());
		spilgui.getFields()[spiller[aktivspiller].hentPosition()].setCar(guispiller[aktivspiller], true);
	}

	public void startFelt(int aktivspiller) {
		spiller[aktivspiller].indsætPåKonto(((StartFelt)felter[0]).hentPasserStart());
	}
}

