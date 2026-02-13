package de.fom.project.fiale;
import de.fom.project.geld.Bargeld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bankautomat {
    private HashMap<Integer,List<Bargeld>> bargeld;



    public Bankautomat() {

    }
    public void bargeldHinzufügen(Bargeld schein){
        bargeld.get(schein.getWert()).add(schein);
    }
    public void bargeldHinzufügen(List<Bargeld> scheine){
        for (Bargeld schein : scheine) {
            bargeld.get(schein.getWert()).add(schein);
        }
    }


    public Bargeld scheinAusgeben(int wert){
        Bargeld schein = bargeld.get(wert).getFirst();
        bargeld.get(wert).remove(schein);
        return schein;
    }

    private Map<Integer,Integer> getAnzahlScheineJeWert(){
        HashMap<Integer,Integer> anzahlScheineJeWert = new HashMap<>();
        for (Integer wert : bargeld.keySet()) {
            anzahlScheineJeWert.put(wert, bargeld.get(wert).toArray().length);
        }
        return anzahlScheineJeWert;
    }




    public List<Bargeld> getBargeld() {
        List<Bargeld> alleScheine = new ArrayList<>();
        for (List<Bargeld> scheine : bargeld.values()) {
            alleScheine.addAll(scheine);
        }
        return alleScheine;
    }

}
