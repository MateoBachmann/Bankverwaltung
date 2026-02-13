package de.fom.project.personen;
import de.fom.project.geld.Bargeld;
import de.fom.project.geld.Konto;

import java.util.HashMap;
import java.util.List;

public class Kunde extends Person {
    private double kundenNr;
    private List<Konto> kontos;
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
}
