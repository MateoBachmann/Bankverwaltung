package de.fom.project.geld;

public abstract class Geld {
    private double wert;

    public Geld(double wert){
        this.wert = wert;
    }
    public double getWert() {
        return wert;
    }
    protected void setWert(double wert) {
        this.wert = wert;
    }
}
