package Game;
import Felter.*;


public class RegelController {
	private Spiller[] spiller;
	private Felt[] felter;

	private int feltejer;
	private int prisfordobler;


	public RegelController(Spiller[] spiller, Felt[] felter) {
		this.spiller = spiller;
		this.felter = felter;
		prisfordobler = 1;
	}

	public void normalFeltKøbGrund(int aktivspiller, int position) {
		felter[position].sætEjer(aktivspiller);
		spiller[aktivspiller].hævKontoVærdi(felter[position].hentPris());
	}

	public int normalFeltEjetAfAnden(int aktivspiller, int position) {

		int feltnrpåpar = ((NormalFelt)felter[position]).hentPar();
		int betalt;
		int indestående = spiller[aktivspiller].indeståendeSpillerKonto();

		//Bestem pris
		if (feltejer == felter[feltnrpåpar].hentEjer()) {//Hvis ejeren af feltet også ejer den tilhørende feltpartner.
			prisfordobler = 2;
		}

		//Overfør penge 
		int tilbetaling = felter[position].hentPris()*prisfordobler;

		//hvis aktivspiller ikke har penge nok til at betale så betaler man det man har og går bankerot.
		if (indestående < tilbetaling) {
			spiller[felter[position].hentEjer()].modtagGevinst(indestående);
			betalt = indestående;
			
		}else {
			spiller[felter[position].hentEjer()].modtagGevinst(tilbetaling);
			spiller[aktivspiller].hævKontoVærdi(tilbetaling);
			betalt = tilbetaling;
			
		}
		return betalt;
	}


	public void togFelt(int aktivspiller) {
		
		

		spiller[aktivspiller].sætEkstraTur(true);
	}

	public int fyrværkeriDelfinCafeFelt(int aktivspiller, int position) {
		int indestående = spiller[aktivspiller].indeståendeSpillerKonto();
		int betalt;
		
		//Hvis spilleren ikke har penge nok, overføres det der står på kontoen til onkelmangepenge og spilleren går bankerot
		if (indestående <  ((EntreFelt) felter[position]).hentPrisForEntre()) {
			((OnkelMangePengeFelt) felter[Konstanter.ONKELSFELT]).sætOnkelsPenge(((OnkelMangePengeFelt) felter[Konstanter.ONKELSFELT]).hentOnkelsPenge() + indestående);
			betalt = indestående;
		} else {
			spiller[aktivspiller].modtagGevinst(((EntreFelt)felter[position]).hentPrisForEntre());
			((OnkelMangePengeFelt)felter[Konstanter.ONKELSFELT]).sætOnkelsPenge(((OnkelMangePengeFelt)felter[Konstanter.ONKELSFELT]).hentOnkelsPenge() + ((EntreFelt)felter[position]).hentPrisForEntre());
			betalt = ((EntreFelt)felter[position]).hentPrisForEntre();
		}
		return betalt;
	}

	public int onkelMangePengeFelt(int aktivspiller) {
		int returværdi = ((OnkelMangePengeFelt)felter[Konstanter.ONKELSFELT]).hentOnkelsPenge();
		//GUI BESKED "Du er er på besøg hos Onkel Mangepenge, og flink som han er har han givet dig hvad han havde i lommerne. Du har fået " + felter[12].hentOnkelsPenge();
		spiller[aktivspiller].modtagGevinst(((OnkelMangePengeFelt)felter[Konstanter.ONKELSFELT]).hentOnkelsPenge());
		
		((OnkelMangePengeFelt)felter[Konstanter.ONKELSFELT]).sætOnkelsPenge(2); //Onkel finder en daler på gulvet da du er gået.
		return returværdi;
	}

	public void gåPåCafeFelt(int aktivspiller, int position) {

		//GUI BESKED "Din ven har ringet og vil have dig med på Café. Du syns det er en skide go idé. Tryk på OK"
		//GUI ok knap
		spiller[aktivspiller].sætPosition(((GåTilCafeFelt)felter[position]).hentGåTilFeltNr());
	}



	public void startFelt(int aktivspiller) {
//		spiller[aktivspiller].modtagGevinst(felter[1].hentPasserStart());
	}
}

