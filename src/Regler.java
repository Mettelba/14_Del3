import Felter.Felt;


public class Regler {
	Spiller[] spiller;
	Felt[] felter;
	int aktivspiller;
	int position;
	int felttype;
	int indestående;
	int feltejer;
	int prisfordobler;
	boolean svar;


	public Regler(Spiller[] spiller, Felt[] felter, int aktivspiller ) {
		this.spiller = spiller;
		this.felter = felter;
		this.aktivspiller = aktivspiller;
		position = spiller[aktivspiller].hentPosition();
		felttype = felter[position].hentFeltType();
		indestående = spiller[aktivspiller].indeståendeSpillerKonto();
		feltejer = felter[position].hentEjer();
		prisfordobler = 1;

	}

	


	public void normalFelt() {


		//Felt er ejet af spillet spiller 0
		if (feltejer == 0 && spiller[aktivspiller].indeståendeSpillerKonto() > felter[position].hentPris()) {//har aktivspiller råd til at købe det.
			//Her kan du så få lov at købe grunden hvis du vil.
			//GUI besked vil du købe grunden ja/nej.

			if (svar == true) {
				felter[position].sætEjer(aktivspiller);
				spiller[aktivspiller].hævKontoVærdi(felter[position].hentPris());
			}
		}

		//Felt er ejet af en anden spiller og det ikke er spiller 0
		if (feltejer != aktivspiller && feltejer != 0) {
			int feltnrpåpar = felter[position].hentPar();
			if (feltejer == felter[feltnrpåpar].hentEjer()) {//Hvis ejeren af feltet også ejer den tilhørende feltpartner.
				prisfordobler = 2;
				if(felter[position].hentBod()==true) {//Hvis der er bod på
					prisfordobler = 4;
				}
			}
			//Overfør penge 
			int tilbetaling = felter[position].hentHusleje()*prisfordobler;

			//hvis aktivspiller ikke har penge nok til at betale så betaler man det man har og går bankerot.
			if (indestående < tilbetaling) {
				spiller[felter[position].hentEjer()].modtagGevinst(indestående);
				//GUI BESKED "Du er gået bankerot og har desværre tabt spillet."
			}else {
				spiller[felter[position].hentEjer()].modtagGevinst(tilbetaling);
				spiller[aktivspiller].hævKontoVærdi(tilbetaling);
			}

		}
	}

	public void togFelt() {
		//GUI BESKED "Du er landet på toget, og får derfor en ekstra tur. Tryk Ok.
		spiller[aktivspiller].sætEkstraTur(true);
	}

	public void fyrværkeriDelfinCafeFelt() {

		//GUI BESKED "Du er landet på" + felter[position].hentFeltTekst() +"  Du skal betale felter[position].hentEntre()+" kr. til onkel Mangepenge. Tryk på OK."

		//Hvis spilleren ikke har penge nok, overføres det der står på kontoen til onkelmangepenge og spilleren går bankerot
		if (indestående < felter[position].hentEntre()) {
			felter[12].sætOnkelsPenge(felter[12].hentOnkelsPenge() + indestående);
			//GUI BESKED "Du er gået bankerot og har desværre tabt spillet."
		} else {
			spiller[aktivspiller].modtagGevinst(felter[position].hentEntre());
			felter[12].sætOnkelsPenge(felter[12].hentOnkelsPenge() + felter[position].hentEntre());
		}
	}

	public void onkelMangePengeFelt() {
		//GUI BESKED "Du er er på besøg hos Onkel Mangepenge, og flink som han er har han givet dig hvad han havde i lommerne. Du har fået " + felter[12].hentOnkelsPenge();
		spiller[aktivspiller].modtagGevinst(felter[12].hentOnkelsPenge());
		felter[12].sætOnkelsPenge(2); //Onkel finder en daler på gulvet da du er gået.

	}

	public void gåPåCafeFelt() {

		//GUI BESKED "Din ven har ringet og vil have dig med på Café. Du syns det er en skide go idé. Tryk på OK"
		//GUI ok knap
		spiller[aktivspiller].sætPosition(felter[position].hentGåTilFeltNr());
	}



	public void startFelt() {
		spiller[aktivspiller].modtagGevinst(felter[1].hentPasserStart());
	}
}
