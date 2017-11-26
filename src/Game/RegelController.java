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
		felter[position].sætEjer(aktivspiller);
		spiller[aktivspiller].hævKontoVærdi(felter[position].hentPris());
		guispiller[aktivspiller].setBalance(spiller[aktivspiller].indeståendeSpillerKonto());
		guifelter[position].setForeGroundColor(guispiller[aktivspiller].getPrimaryColor());
		
	}
	

	public int normalFeltEjetAfAnden(int aktivspiller, int position) {

		int feltnrpåpar = ((NormalFelt)felter[position]).hentPar();
		int betalt;
		int indestående = spiller[aktivspiller].indeståendeSpillerKonto();
		int feltejer = ((NormalFelt)felter[position]).hentEjer();
		
		//Bestem pris
		if (feltejer == felter[feltnrpåpar].hentEjer()) {//Hvis ejeren af feltet også ejer den tilhørende feltpartner.
			prisfordobler = 2;
		}

		//Overfør penge 
		int tilbetaling = felter[position].hentPris()*prisfordobler;
		prisfordobler = 1;
		//hvis aktivspiller ikke har penge nok til at betale så betaler man det man har og går bankerot.
		if (indestående < tilbetaling) {
			spiller[felter[position].hentEjer()].modtagGevinst(indestående); //Ejer af felt modtager det som den aktive spiller har på sin konto.
			betalt = indestående;
		}else {
			spiller[feltejer].modtagGevinst(tilbetaling);
			spiller[aktivspiller].hævKontoVærdi(tilbetaling);
			betalt = tilbetaling;
			
		}
		spilgui.showMessage("Tryk ok for at betale");
		
		guispiller[aktivspiller].setBalance(spiller[aktivspiller].indeståendeSpillerKonto());
		guispiller[feltejer].setBalance(spiller[feltejer].indeståendeSpillerKonto());
		return betalt;
	}


	public void togFelt(int aktivspiller, int position) {
		spilgui.showMessage(felter[position].hentBeskedTekst()+ ". Tryk på ok.");
		spiller[aktivspiller].sætEkstraTur(true);
	}

	public int entreFelt(int aktivspiller, int position) {
		int indestående = spiller[aktivspiller].indeståendeSpillerKonto();
		int betalt;
		String beskedstreng;
		
		//Hvis spilleren ikke har penge nok, overføres det der står på kontoen til onkelmangepenge og spilleren går bankerot
		if (indestående <  ((EntreFelt) felter[position]).hentPrisForEntre()) {
			((OnkelMangePengeFelt) felter[Konstanter.ONKELSFELT]).sætOnkelsPenge(((OnkelMangePengeFelt) felter[Konstanter.ONKELSFELT]).hentOnkelsPenge() + indestående);
			betalt = indestående;
		} else {
			spiller[aktivspiller].hævKontoVærdi(((EntreFelt)felter[position]).hentPrisForEntre());
			((OnkelMangePengeFelt)felter[Konstanter.ONKELSFELT]).sætOnkelsPenge(((OnkelMangePengeFelt)felter[Konstanter.ONKELSFELT]).hentOnkelsPenge() + ((EntreFelt)felter[position]).hentPrisForEntre());
			betalt = ((EntreFelt)felter[position]).hentPrisForEntre();
		}
		
		beskedstreng = felter[position].hentBeskedTekst() + betalt+"kr.";

		if (spiller[aktivspiller].erDuBankerot() == true) {
			beskedstreng = beskedstreng + ", og du gik desværre også bankerot. Spillet er færdigt";
		}	
		spilgui.showMessage(beskedstreng);	
		
		guispiller[aktivspiller].setBalance(spiller[aktivspiller].indeståendeSpillerKonto());
		spilgui.getFields()[Konstanter.ONKELSFELT].setSubText(String.valueOf((((OnkelMangePengeFelt)felter[Konstanter.ONKELSFELT]).hentOnkelsPenge()))); //overfør hvor mange penge der er på feltet til GUI feltet 
		return betalt;
	}

	public int onkelMangePengeFelt(int aktivspiller) {
		int pengepåfelt = ((OnkelMangePengeFelt)felter[Konstanter.ONKELSFELT]).hentOnkelsPenge();
		//GUI BESKED "Du er er på besøg hos Onkel Mangepenge, og flink som han er har han givet dig hvad han havde i lommerne. Du har fået " + felter[12].hentOnkelsPenge();
		spiller[aktivspiller].modtagGevinst(pengepåfelt);
		
		((OnkelMangePengeFelt)felter[Konstanter.ONKELSFELT]).sætOnkelsPenge(2);//Onkel finder en daler på gulvet da du er gået.
		spilgui.showMessage(felter[Konstanter.ONKELSFELT].hentBeskedTekst() + pengepåfelt);
		guispiller[aktivspiller].setBalance(spiller[aktivspiller].indeståendeSpillerKonto());
		spilgui.getFields()[Konstanter.ONKELSFELT].setSubText(String.valueOf((((OnkelMangePengeFelt)felter[Konstanter.ONKELSFELT]).hentOnkelsPenge()))); //overfør hvor mange penge der er på feltet til GUI feltet
		return pengepåfelt;
	}

	public void gåTilCafeFelt(int aktivspiller) {

		int position = spiller[aktivspiller].hentPosition();
		spilgui.showMessage(felter[position].hentBeskedTekst());
		spilgui.getFields()[position].setCar(guispiller[aktivspiller], false);
		spiller[aktivspiller].sætPosition(((GåTilCafeFelt)felter[position]).hentGåTilFeltNr());
		spilgui.getFields()[spiller[aktivspiller].hentPosition()].setCar(guispiller[aktivspiller], true);
		
	}



	public void startFelt(int aktivspiller) {
		spiller[aktivspiller].modtagGevinst(((StartFelt)felter[0]).hentPasserStart());
	}
}

