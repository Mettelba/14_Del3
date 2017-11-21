package Game;
import Felter.Felt;


public class Regler {
	private Spiller[] spiller;
	private Felt[] felter;
	private int aktivspiller;
	private int position;
	private int felttype;
	private int indestående;
	private int feltejer;
	private int prisfordobler;
	private boolean svar;

	public Regler(Spiller[] spiller, Felt[] felter, int aktivspiller ) {
		this.spiller = spiller;
		this.felter = felter;
		this.aktivspiller = aktivspiller;

		felttype = felter[position].hentFeltType();
		indestående = spiller[aktivspiller].indeståendeSpillerKonto();
		prisfordobler = 1;
	}

	public void normalFeltKøbGrund(int aktivspiller, int position) {
		felter[position].sætEjer(aktivspiller);
		spiller[aktivspiller].hævKontoVærdi(felter[position].hentPris());
	}

	public int normalFeltEjetAfAnden(int aktivspiller, int position) {

		int feltnrpåpar = felter[position].hentPar();
		int betalt;

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
			//GUI BESKED "Du er gået bankerot og har desværre tabt spillet."
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

	public void fyrværkeriDelfinCafeFelt(int aktivspiller) {

		//GUI BESKED "Du er landet på" + felter[position].hentFeltTekst() +"  Du skal betale felter[position].hentEntre()+" kr. til onkel Mangepenge. Tryk på OK."

		//Hvis spilleren ikke har penge nok, overføres det der står på kontoen til onkelmangepenge og spilleren går bankerot
		if (indestående < felter[position].hentPrisForEntre()) {
			felter[12].sætOnkelsPenge(felter[12].hentOnkelsPenge() + indestående);
			//GUI BESKED "Du er gået bankerot og har desværre tabt spillet."
		} else {
			spiller[aktivspiller].modtagGevinst(felter[position].hentPrisForEntre());
			felter[12].sætOnkelsPenge(felter[12].hentOnkelsPenge() + felter[position].hentPrisForEntre());
		}
	}

	public void onkelMangePengeFelt(int aktivspiller) {
		//GUI BESKED "Du er er på besøg hos Onkel Mangepenge, og flink som han er har han givet dig hvad han havde i lommerne. Du har fået " + felter[12].hentOnkelsPenge();
		spiller[aktivspiller].modtagGevinst(felter[12].hentOnkelsPenge());
		felter[12].sætOnkelsPenge(2); //Onkel finder en daler på gulvet da du er gået.

	}

	public void gåPåCafeFelt(int aktivspiller) {

		//GUI BESKED "Din ven har ringet og vil have dig med på Café. Du syns det er en skide go idé. Tryk på OK"
		//GUI ok knap
		spiller[aktivspiller].sætPosition(felter[position].hentGåTilFeltNr());
	}



	public void startFelt(int aktivspiller) {
		spiller[aktivspiller].modtagGevinst(felter[1].hentPasserStart());
	}
}

