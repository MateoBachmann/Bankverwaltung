package de.fom.project;

import de.fom.project.geld.Bankautomat;
import de.fom.project.geld.Bargeld;
import de.fom.project.geld.Konto;
import de.fom.project.personen.Kunde;
import de.fom.project.personen.Mitarbeiter;
import de.fom.project.util.exceptions.UngueltigesAlter;
import de.fom.project.util.io.Io;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.






public class Main {
    static Bankautomat testBankautomat = new Bankautomat();
    static Mitarbeiter testMitarbeiter = new Mitarbeiter(1,"0",5000,26,"Max Mustermann","test");

    public static void main(String[] args) {
        Kunde testKunde = new Kunde(1,18,"Test Kunde 1", "Testkunde");
        testKunde.erstelleKonto();
        Kunde testKunde2 = new Kunde(1,20,"Test Kunde 2", "Testkunde");
        testKunde2.erstelleKonto();





        String[] haubtMenu = {
                "Mitarbeiter",      //1
                "Kunde",             //2
                "Program beenden"
        };
        while(true){
            int menuAuswahl = Io.getMenuSelection("Willkommen in der Bank",haubtMenu);
            switch (menuAuswahl) {
                case 1:
                    testMitarbeiter.menu();
                    break;
                case 2:
                    Kunde kunde = kundeAuswaehlen();
                    if (kunde == null){
                        break;
                    }
                    Konto konto = kontoAuswahl(kunde);
                    if (konto == null){
                        break;
                    }
                    testBankautomat.karteEinlesen(konto, kunde);
                    break;
                case 3:
                    return;

            }
        }
    }

    public static Kunde kundeAuswaehlen(){
        Kunde kunde = null;
        while(kunde == null){
            Kunde.alleKundenAnzeigen();
            int auswahl = Io.requestInt("Bitte die Kundennummer des gewünschten Kundens auswählen -1 zum abrechen");
            kunde = Kunde.getKundeVonNr(auswahl);
            if (auswahl == -1) {
                return null;
            }
        }
        return kunde;
    }

    public static Konto  kontoAuswahl(Kunde kunde){
        List<Konto> moeglicheKonten = kunde.getKontos();
        String title = "Bitte ein Konto auswählen";
        List<String> options = new ArrayList<String>();
        for (Konto k : moeglicheKonten) {
            options.add(k.getIban()+ " " + k.getWert() + "€");
        }
        if  (options.size() == 0) {
            return null;
        }
        int auswahl = Io.getMenuSelection(title,options.toArray(new String[0]));
        return moeglicheKonten.get(auswahl-1);
    }


}














