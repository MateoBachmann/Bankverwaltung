package de.fom.project.personen;
import de.fom.project.geld.Bargeld;
import de.fom.project.geld.Konto;

public class Kunden extends Person {
    private double kundenNr;
    //private Konto;
    //private Bargeld;

    public Kunden(double kundenNr, int alter, String name, String geschlecht){
        super(alter, name, geschlecht);
        this.kundenNr = kundenNr;
    }





}
