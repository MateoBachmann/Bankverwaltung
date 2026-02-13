package de.fom.project.geld;
//import de.fom.project.exeptions.DigitalesGeld;
//import de.fom.project.exeptions.Kunde;

import de.fom.project.personen.Kunde;

public class Konto {
    private double kontonr;
    private String iban;
    //private DigitalesGeld;
    private Kunde kunde;

    public Konto(Kunde kunde) {
        this.kunde = kunde;

    }

}
