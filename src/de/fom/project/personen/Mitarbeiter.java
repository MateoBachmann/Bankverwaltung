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
        class MitarbeiterMenü {

            private Scanner sc = new Scanner(System.in);


            public MitarbeiterMenü() {
                boolean aktiv = true;

                while (aktiv) {
                    System.out.println("--- Kundenbereich ---");
                    System.out.println("1 = Kunde anlegen");
                    System.out.println("2 = Kunden anzeigen");
                    System.out.println("0 = Programm beenden");

                    int auswahl = sc.nextInt();

                    switch (auswahl) {
                        case 1:
                            kundeErstellen();

                        case 2:
                            Kunde.alleKundenAnzeigen();
                            break;
                        case 0:
                            aktiv = false;
                            break;
                        default:
                            System.out.println("Ungültig");
                    }
                }
            }

            }
        }
    }



