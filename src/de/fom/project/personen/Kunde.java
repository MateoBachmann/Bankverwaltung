package de.fom.project.personen;
import de.fom.project.geld.Bargeld;
import de.fom.project.geld.Konto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Kunde extends Person {
    private double kundenNr;
    private List<Konto> kontos = new ArrayList<>();
    private List<Bargeld> bargeld;

    public double getMitarbeiterNr() {
        return kundenNr;
    }


    public Kunde(double kundenNr, int alter, String name, String geschlecht){
        super(alter, name, geschlecht);
        this.kundenNr = kundenNr;
    }

    public void erstelleKonto(){
        kontos.add(new Konto(this));
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
