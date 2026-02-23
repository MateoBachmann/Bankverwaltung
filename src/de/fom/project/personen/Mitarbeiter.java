package de.fom.project.personen;

import de.fom.project.geld.Konto;
import de.fom.project.util.exceptions.UngueltigesAlter;
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
        int kundenNr = Io.requestInt("KundenNummer angeben: ");
        while(Kunde.getKundeVonNr(kundenNr) != null){
            kundenNr = Io.requestInt("KundenNummer bereits belegt bitte waeheln Sie eine neue: ");
        }
        String name = Io.requestString("Name angeben: ");

        String geschlecht = Io.requestString("Geschlecht angeben: ");
        int alter = Io.requestInt("Alter angeben: ");
        return new Kunde(kundenNr, alter, name, geschlecht);

    }
    public Konto kontoErstellen() {
        while (true) {
            int kundenNr = Io.requestInt("KundenNummer angeben: ");
            try {
                Kunde kunde = Kunde.getKundeVonNr(kundenNr);
                return kunde.erstelleKonto();
            } catch (Exception e) {
                Io.output("Kunde nicht gefunden");
            }
        }

    }
    public void menu() {
        String title = "Mitarbeiter Menu";
        String[] optionen = {
                "Alle Kunden Anzeigen",
                "Kunden Erstellen",
                "Konto Erstellen",
                "Zurueck"
        };
        while (true) {
            int menuAuswahl = Io.getMenuSelection(title, optionen);
            switch (menuAuswahl) {
                case 1:
                    Kunde.alleKundenAnzeigen();
                    break;
                case 2: {
                    try {
                        kundeErstellen();
                    } catch (UngueltigesAlter e) {
                        Io.output(e.getMessage());
                    }
                    break;
                }
                case 3:
                    kontoErstellen();
                    Io.output("Konto Erstellt");
                    break;
                case 4:
                    return;
            }
        }
    }
}





