package de.fom.project.geld;

import de.fom.project.personen.Kunde;
import de.fom.project.util.exceptions.KeinKontoAktiv;
import de.fom.project.util.exceptions.UnguelterWert;
import de.fom.project.util.io.Io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bankautomat {
    private Map<Integer,List<Bargeld>> bargeld = new HashMap<>();
    private Konto currentKonto;
    private Kunde currentKunde;







    public Bankautomat() {
        bargeld.put(5,new ArrayList<>());
        bargeld.put(10,new ArrayList<>());
        bargeld.put(20,new ArrayList<>());
        bargeld.put(50,new ArrayList<>());
        bargeld.put(100,new ArrayList<>());
        bargeld.put(200,new ArrayList<>());
    }



    public void karteEinlesen(Konto konto, Kunde kunde) {
        currentKonto = konto;
        currentKunde = kunde;

        menu();
    }



    private void menu(){
        String[] haubtMenu = {
                "Einzahlen", //1
                "Auzahlen",//2
                "Ueberweisung", //3
                "Beenden" //4
        };
        while(true){
            int auswahl = Io.getMenuSelection("Bankautomat\nIhr derzeitiges guthaben beträgt: " + Double.toString(currentKonto.getWert()) + "€",haubtMenu);
            if (auswahl == 1){

            }else if (auswahl == 2){
                Io.clearOutput();
                double wert = Io.requestDouble("Wie viel moechten Sie sich Auzahlen lassen?");
                try{
                    geldAuzahlen(wert);
                }catch (UnguelterWert e){
                    Io.output(e.getMessage());
                }
            }else if (auswahl == 3){

            } else if (auswahl == 4){
                karteEntnemhen();
                return;
            }
        }
    }

    public void karteEntnemhen(){
        currentKonto = null;
        currentKunde = null;
    }


    public void geldEinzahlen(List<Bargeld> scheine) throws KeinKontoAktiv {
        if (currentKonto == null || currentKunde == null) {
            throw new KeinKontoAktiv("KeinKontoAktiv");
        }
        bargeldHinzufuegen(scheine);
        currentKunde.bargeldEnfernen(scheine);
        for (Bargeld schein : scheine) {
            currentKonto.changeWert(schein.getWert());
        }
    }

    public List<Bargeld> geldAuzahlen(double amount) throws UnguelterWert {
        if ((amount < 0) || (amount % 5 != 0) || (amount > getGesamtwert()) || (amount >= currentKonto.getWert())){
            throw new UnguelterWert("Wert Ungueltig");
        }
        double originalAmount = amount;
        List<Bargeld> scheine = new ArrayList<>();
        while (amount > 0) {
            if (amount > 200 && getAnzahlScheineJeWert().get(200) >= 1){
                scheine.add(scheinAusgeben(200));
                amount -= 200;
            } else if (amount > 100 && getAnzahlScheineJeWert().get(100) >= 1) {
                scheine.add(scheinAusgeben(100));
                amount -= 100;
            } else if (amount > 50 && getAnzahlScheineJeWert().get(50) >= 1) {
                scheine.add(scheinAusgeben(50));
                amount -= 50;
            } else if (amount > 20 && getAnzahlScheineJeWert().get(20) >= 1) {
                scheine.add(scheinAusgeben(20));
                amount -= 20;
            } else if (amount > 10 && getAnzahlScheineJeWert().get(10) >= 1) {
                scheine.add(scheinAusgeben(10));
                amount -= 10;
            } else if (amount > 5 && getAnzahlScheineJeWert().get(5) >= 1) {
                scheine.add(scheinAusgeben(5));
                amount -= 5;
            } else {
                bargeldHinzufuegen(scheine);
                throw new UnguelterWert("Leider hat der Automat keine Passenden Scheine");
            }
        }
        currentKonto.changeWert(originalAmount * (-1));
        return scheine;
    }




    public void bargeldHinzufuegen(Bargeld schein){
        bargeld.get((int) schein.getWert()).add(schein);
    }


    public void bargeldHinzufuegen(List<Bargeld> scheine){
        for (Bargeld schein : scheine) {
            bargeld.get((int) schein.getWert()).add(schein);
        }
    }


    private Bargeld scheinAusgeben(int wert){
        Bargeld schein = bargeld.get(wert).getFirst();
        bargeld.get(wert).remove(schein);
        return schein;
    }

    private Map<Integer,Integer> getAnzahlScheineJeWert(){
        HashMap<Integer,Integer> anzahlScheineJeWert = new HashMap<>();
        for (Integer wert : bargeld.keySet()) {
            anzahlScheineJeWert.put(wert, bargeld.get(wert).toArray().length);
        }
        return anzahlScheineJeWert;
    }


    private double getGesamtwert(){
        double total = 0;
        for (Integer wert : getAnzahlScheineJeWert().keySet()) {
            total += wert * getAnzahlScheineJeWert().get(wert);
        }
        return total;
    }




    public List<Bargeld> getBargeld() {
        List<Bargeld> alleScheine = new ArrayList<>();
        for (List<Bargeld> scheine : bargeld.values()) {
            alleScheine.addAll(scheine);
        }
        return alleScheine;
    }

}
