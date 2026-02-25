package de.fom.project.personen;
import de.fom.project.geld.Bargeld;
import de.fom.project.geld.Konto;
import de.fom.project.util.io.Io;

import java.util.*;

public class Kunde extends Person {
    private int kundenNr;
    private List<Konto> kontos = new ArrayList<>();
    private List<Bargeld> bargeld;
    private static Map<Integer,Kunde> kundenListe = new HashMap<>();

    public List<Bargeld> getBargeld() {
        return bargeld;
    }


    public Kunde(int kundenNr, int alter, String name, String geschlecht){
        super(alter, name, geschlecht);
        if (kundenListe.containsKey(kundenNr) || kundenNr <= 0){
            throw new IllegalArgumentException("Kundennummer vorhanden");
        }
        this.kundenNr = kundenNr;
        this.bargeld = new ArrayList<>();
        kundenListe.put(kundenNr,this);
    }


     // Könnte auch Protected sein, wird jedoch zu anschaungszwecken in der main verwendet
    public static Kunde getKundeVonNr(int kundenNr){
        return kundenListe.getOrDefault(kundenNr, null);

    }
    public int getKundenNr() {
        return kundenNr;
    }


    public static void alleKundenAnzeigen() {
        if (kundenListe.isEmpty()) {
            Io.output("Keine Kunden vorhanden.");
            return;
        }
        for (Kunde k : kundenListe.values()) {
            Io.output("KundenNr: " + k.getKundenNr() + ", Name: " + k.getName());
        }
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
     * Hier ist Public ansonsten nicht Sinvoll da so jede klasse dem kunden bargeld enfernen kann, jedoch war eine Transaktionsklasse nicht teil des Projektes
     */
    public void bargeldEnfernen(List<Bargeld> scheine){
        bargeld.removeAll(scheine);
    }



    }


