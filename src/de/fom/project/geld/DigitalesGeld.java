package de.fom.project.geld;

public class DigitalesGeld extends Geld {

    public DigitalesGeld(double wert){
        super(wert);
    }

    public double getWert(){
        return super.getWert();
    }

    public void addWert(double wert){
        super.setWert(this.getWert() + wert);
    }
    public void removeWert(double wert){
        super.setWert(this.getWert() - wert);
    }


}
