package de.fom.project.personen;
import de.fom.project.geld.Bargeld;
import de.fom.project.geld.Konto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kunde extends Person {
    private double kundenNr;
    private List<Konto> kontos = new ArrayList<>();
    private List<Bargeld> bargeld;
    private static Map<Double,Kunde> kundenListe = new HashMap<>();
    public double getMitarbeiterNr() {
        return kundenNr;
    }


    public Kunde(double kundenNr, int alter, String name, String geschlecht){
        super(alter, name, geschlecht);
        this.kundenNr = kundenNr;
        kundenListe.put(kundenNr,this);
    }
    protected static Kunde getKundeVonNr(double kundenNr) throws Exception{
            return kundenListe.get(kundenNr);

    }

    public Konto erstelleKonto(){
        Konto konto = new Konto(this);
        kontos.add(konto);
        return konto;
    }

    public List<Konto> getKontos() {
        return kontos;
    }


    /**
     * muss Public sein, damit der Bankautomat drauf zugreifen kann.
     * Hier ist Public ansonsten nicht Sinfoll da so jede klasse dem kunden bargeld enfernen kann, jedoch war eine Transaktionsklasse nicht teil des Projektes
     */
    public void bargeldEnfernen(List<Bargeld> scheine){
        bargeld.removeAll(scheine);
    }
}
