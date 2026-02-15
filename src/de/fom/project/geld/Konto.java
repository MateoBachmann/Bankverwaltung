package de.fom.project.geld;
//import de.fom.project.exeptions.DigitalesGeld;
//import de.fom.project.exeptions.Kunde;

import de.fom.project.personen.Kunde;

import java.util.HashMap;
import java.util.Map;

public class Konto {
    private double kontonr;
    private String iban;
    private DigitalesGeld wert;
    //private DigitalesGeld;
    private Kunde kunde;
    private static Map<String, Konto> kontos = new HashMap<>();

    public Konto(Kunde kunde) {
        this.kunde = kunde;
        this.wert = new DigitalesGeld();
        //generate Iban
        this.iban = "";
        this.kontos.put(this.iban, this);
    }
    public double getWert() {
        return wert.getWert();
    }

    protected void changeWert(double wert) {
        this.wert.changeWert(wert);
    }


    protected Konto getKonto(String iban) throws NullPointerException {
        return kontos.get(iban);
    }


    //REMOVE THIS LATER ONLY FOR TESTING PU
    public void testChangeWert(int wert) {
        this.wert.changeWert(wert);
    }

}
