package de.fom.project.geld;
//import de.fom.project.exeptions.DigitalesGeld;
//import de.fom.project.exeptions.Kunde;

import de.fom.project.personen.Kunde;

public class Konto {
    private double kontonr;
    private String iban;
    private DigitalesGeld wert;
    //private DigitalesGeld;
    private Kunde kunde;

    public Konto(Kunde kunde) {
        this.kunde = kunde;
        this.wert = new DigitalesGeld();

    }
    public double getWert() {
        return wert.getWert();
    }

    protected void changeWert(double wert) {
        this.wert.changeWert(wert);
    }


    //REMOVE THIS LATER ONLY FOR TESTING PU
    public void testChangeWert(int wert) {
        this.wert.changeWert(wert);
    }

}
