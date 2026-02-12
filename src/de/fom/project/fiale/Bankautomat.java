package de.fom.project.fiale;
import de.fom.project.geld.Bargeld;
import java.util.List;

public class Bankautomat {
    private List<Bargeld> bargeld;



    public Bankautomat() {

    }
    public double bargeldHinzufügen(Bargeld schein){
        bargeld.add(schein);
    }
    public double bargeldHinzufügen(List<Bargeld> scheine){
        bargeld.addAll(scheine);
    }
}
