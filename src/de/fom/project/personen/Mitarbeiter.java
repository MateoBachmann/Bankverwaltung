package de.fom.project.personen;

import de.fom.project.geld.Konto;
import de.fom.project.util.io.Io;

import java.util.Scanner;

import static de.fom.project.personen.Kunde.alleKundenAnzeigen;

public class Mitarbeiter extends Person {
    private double mitarbeiterNr;
    private String vorgesetzer;
    private double gehalt;

    public Mitarbeiter(double mitarbeiterNr, String vorgesetzer, double gehalt,int alter, String name, String geschlecht ){
        super(alter, name, geschlecht);
        this.gehalt = gehalt;
        this.mitarbeiterNr = mitarbeiterNr;
        this.vorgesetzer = vorgesetzer;

    }
    public Kunde kundeErstellen(){
        double kundenNr = Io.requestDouble("KundenNummer angeben: ");
        String name = Io.requestString("Name angeben: ");
        String geschlecht = Io.requestString("Geschlecht angeben: ");
        int alter = Io.requestInt("Alter angeben: ");
        return new Kunde(kundenNr,alter,name,geschlecht);
    }
    public Konto kontoErstellen() {
        while (true) {
            double kundenNr = Io.requestDouble("KundenNummer angeben: ");
            try {
                Kunde kunde = Kunde.getKundeVonNr(kundenNr);
                return kunde.erstelleKonto();
            } catch (Exception e) {
                Io.output("Kunde nicht gefunden");
            }
        }

    }
    private void startmenu() {
        Scanner sc = new Scanner(System.in);
        int kundeOderMitarbeiter = sc.nextInt();


        while (true) {
            System.out.println("Willkommen in unserer Bank");
            System.out.println("Sind Sie:");
            System.out.println("1 = Kunde");
            System.out.println("2 = Mitarbeiter");


            switch (kundeOderMitarbeiter) {
                case 1:
                    // MitarbeiterMenü();
                    break;

                case 2:

                    break;





            }


        }

}
}





