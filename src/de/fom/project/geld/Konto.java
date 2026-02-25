package de.fom.project.geld;
//import de.fom.project.exeptions.DigitalesGeld;
//import de.fom.project.exeptions.Kunde;

import de.fom.project.personen.Kunde;
import de.fom.project.util.io.Io;

import java.util.*;

public class Konto {

    private int kontonr;
    private DigitalesGeld wert;
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

    public int getKontonr() {
        return kontonr;
    }


    public double getWert() {
        return wert.getWert();
    }

    protected void changeWert(double wert) {
        this.wert.changeWert(wert);
    }


    // Diese Methode gibt es nur für Testzwecke da ansonsten kein geld auf kontos erstellt werden kann, in einem echtbetrieb müsste diese Methode enfernt werden
    public void testChangeWert(int wert) {
        this.wert.changeWert(wert);
    }

    //in echt müsste ein Kunde die Kontonummer kennen, da dies jedoch für diese Projektarbeit nicht sinvoll ist gibt es hier eine auswahl
    protected static Konto kontoAuswahl() {
        String title = "Bitte ein Konto auswählen";
        List<Konto> alleKonten = kontos.values().stream().toList();
        List<String> options = new ArrayList<String>();
        for (Konto k : kontos.values()) {
            options.add(k.getKontonr()+ "");
        }
        if  (options.isEmpty()) {
            return null;
        }
        int auswahl = Io.getMenuSelection(title,options.toArray(new String[0]));
        return alleKonten.get(auswahl-1);
    }
}
