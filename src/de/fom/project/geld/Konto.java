package de.fom.project.geld;
//import de.fom.project.exeptions.DigitalesGeld;
//import de.fom.project.exeptions.Kunde;

import de.fom.project.personen.Kunde;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Konto {
    private int kontonr;
    private DigitalesGeld wert;
    //private DigitalesGeld;
    private Kunde kunde;
    private static Map<Integer, Konto> kontos = new HashMap<>();

    public Konto(Kunde kunde) {
        this.kunde = kunde;
        this.wert = new DigitalesGeld();

        while(true){
            int zufalszahl = new Random().nextInt(1000);
            if (!kontos.containsKey(zufalszahl)) {
                this.kontonr = zufalszahl;
                kontos.put(this.kontonr, this);
                return;
            }
        }

    }
    public double getWert() {
        return wert.getWert();
    }

    protected void changeWert(double wert) {
        this.wert.changeWert(wert);
    }



    protected Konto getKonto(int kontonr) throws NullPointerException {
        return kontos.get(kontonr);
    }


    //REMOVE THIS LATER ONLY FOR TESTING PU
    public void testChangeWert(int wert) {
        this.wert.changeWert(wert);
    }

}
