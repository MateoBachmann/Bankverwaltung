package de.fom.project;

import de.fom.project.geld.Bankautomat;
import de.fom.project.geld.Bargeld;
import de.fom.project.geld.Konto;
import de.fom.project.personen.Kunde;
import de.fom.project.personen.Mitarbeiter;
import de.fom.project.util.exceptions.UngueltigesAlter;
import de.fom.project.util.io.Io;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.






public class Main {
    static Bankautomat testBankautomat = new Bankautomat();
    static Mitarbeiter testMitarbeiter = new Mitarbeiter(1,"0",5000,26,"Max Mustermann","test");

    public static void main(String[] args) {
        String[] haubtMenu = {
                "Mitarbeiter",      //1
                "Kunde"             //2
        };
        while(true){
            int menuAuswahl = Io.getMenuSelection("Willkommen in der Bank",haubtMenu);
            switch (menuAuswahl) {
                case 1:
                    testMitarbeiter.menu();
                    break;
                case 2:
                    //todo: hier noch Auswahl welcher Kunde
                    Konto konto = null;
                    Kunde kunde = null;
                    testBankautomat.karteEinlesen(konto, kunde);
                    testBankautomat.menu();
                    break;


            }
        }
    }
}














