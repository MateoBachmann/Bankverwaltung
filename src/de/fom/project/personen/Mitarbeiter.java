package de.fom.project.personen;

public class Mitarbeiter extends Person {
    private double mitarbeiterNr;
    private String vorgesetzer;
    private double gehalt;

    public Mitarbeiter(double mitarbeiterNr, String vorgesetzer, double gehalt,int alter, String name, String geschlecht ){
        super(alter, name, geschlecht);
        this.gehalt = gehalt;
        this.mitarbeiterNr = mitarbeiterNr;
        this.vorgesetzer = vorgesetzer;

    }




}
