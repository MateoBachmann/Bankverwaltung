package de.fom.project;

import de.fom.project.geld.Bankautomat;
import de.fom.project.geld.Bargeld;
import de.fom.project.geld.Konto;
import de.fom.project.personen.Kunde;
import de.fom.project.util.io.Io;

import java.net.StandardSocketOptions;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.






public class Main {


    public static void startmenu(String[] args) {
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


                switch (kundeOderMitarbeiter) {
                    case 2:
                        //BankautomatMenü();
            }


        }
    }

    public static void main(String[] args) {
        while (true) {
            Io.output("Banksimulation gestartet");
            Kunde testKunde = new Kunde(1234,18,"Test Kunde", "Male");
            testKunde.erstelleKonto();
            Konto testKonto = testKunde.getKontos().getFirst();

            Bankautomat testBankautomat = new Bankautomat();
            for (int i = 1; i <= 50;i++) {
                int[] werte = {5,10,20,50,100,200};
                for (int wert : werte){
                    testBankautomat.bargeldHinzufuegen(new Bargeld(wert));
                }
            }
            testKonto.testChangeWert(50000);

            testBankautomat.karteEinlesen(testKonto, testKunde);
            break;

        }
    }
}