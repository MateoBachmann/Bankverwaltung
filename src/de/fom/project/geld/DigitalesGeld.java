package de.fom.project.geld;

public class DigitalesGeld extends Geld {

    public DigitalesGeld(){
        super(0);
    }

    //könnte auch weggelassen werden, jedoch wird hier die Überschreibung von Methoden verwendet
    public double getWert(){
        return super.getWert();
    }

    protected void changeWert(double wert){
        super.setWert(this.getWert() + wert);
    }



}
