import java.text.DecimalFormat;
import java.util.Scanner;

class Fahrkartenautomat {
	public static void main(String[] args) {

		Scanner tastatur = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

		double zuZahlenderBetrag;
		double eingezahlterGesamtbetrag;
		double eingeworfeneMuenze;
		double rueckgabebetrag;
		double nochZuZahlen;
        int ticketNumber;

        // Geldbetrag eingeben
		System.out.print("Zu zahlender Betrag (Euro): ");
		zuZahlenderBetrag = tastatur.nextDouble();

        System.out.print("Anzahl der Tickets (1 - 10): ");
		while(){
			ticketNumber = tastatur.nextInt();
			if (ticketNumber < 1 || ticketNumber > 10) {
				System.out.println("Ungültige Ticket Anzahl!");
			}
		}
		zuZahlenderBetrag *= ticketNumber;

        // Geldeinwurf
		eingezahlterGesamtbetrag = 0.0;
		nochZuZahlen = 0.0;
		while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
			nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
			System.out.println("Noch zu zahlen: " + df.format(nochZuZahlen) + " EURO");
			System.out.print("Eingabe (mind. 5 Cent, höchstens 20 Euro): ");
			int eingabe = (int)(100 * tastatur.nextDouble());
			switch (eingabe) {
				case 5:
					eingeworfeneMuenze = 0.05;
					break;
				case 10:
					eingeworfeneMuenze = 0.1;
					break;
				case 20:
					eingeworfeneMuenze = 0.2;
					break;
				case 50:
					eingeworfeneMuenze = 0.5;
					break;
				case 100:
					eingeworfeneMuenze = 1;
					break;
				case 200:
					eingeworfeneMuenze = 2;
					break;
				case 500:
					eingeworfeneMuenze = 5;
					break;
				case 1000:
					eingeworfeneMuenze = 10;
					break;
				case 2000:
					eingeworfeneMuenze = 20;
					break;
				default:
					eingeworfeneMuenze = 0;
					System.out.println(">> Kein gültiges Zahlungsmittel!");
			}

			eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
		}
		
		//Fahrscheinausgabe
		System.out.println("\nFahrschein wird ausgegeben");
		for (int i = 0; i < 8; i++) {
			System.out.print("=");
			try {
				Thread.sleep(200);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("\n\n");
		
        // Rückgeldberechnung und -ausgabe
		rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
		if (rueckgabebetrag > 0.0) {
			System.out.println("Der Rückgabebetrag in Höhe von " + rueckgabebetrag + " Euro");
			System.out.println("wird in folgenden Münzen ausgezahlt:");

			while (rueckgabebetrag >= 20.0) { // 20-Euro-Münzen
				System.out.println("20 Euro");
				rueckgabebetrag = rueckgabebetrag - 20.0;
			}
			while (rueckgabebetrag >= 10.0) { // 10-Euro-Münzen
				System.out.println("10 Euro");
				rueckgabebetrag = rueckgabebetrag - 10.0;
			}
			while (rueckgabebetrag >= 5.0) { // 5-Euro-Münzen
				System.out.println("5 Euro");
				rueckgabebetrag = rueckgabebetrag - 5.0;
			}
			while (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
				System.out.println("2 Euro");
				rueckgabebetrag = rueckgabebetrag - 2.0;
			}
			while (rueckgabebetrag >= 1.0) { // 1-Euro-Münzen
				System.out.println("1 Euro");
				rueckgabebetrag = rueckgabebetrag - 1.0;
			}
			while (rueckgabebetrag >= 0.5) { // 50-Cent-Münzen
				System.out.println("50 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.5;
			}
			while (rueckgabebetrag >= 0.2) { // 20-Cent-Münzen
				System.out.println("20 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.2;
			}
			while (rueckgabebetrag >= 0.1) { // 10-Cent-Münzen
				System.out.println("10 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.1;
			}
			while (rueckgabebetrag >= 0.05) { // 5-Cent-Münzen
				System.out.println("5 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.05;
			}
		}

		System.out.println("\nVergessen Sie nicht, den Fahrschein\nvor Fahrtantritt entwerten zu lassen!\nWir wünschen Ihnen eine gute Fahrt.");

		tastatur.close();
	}
}