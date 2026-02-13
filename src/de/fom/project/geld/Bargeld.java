package de.fom.project.geld;

import de.fom.project.util.exceptions.UnguelterWert;

public class Bargeld extends Geld{
    /***
     * Bargeld einzahlen nur mit festen Werten (Switchcase)
     *
     */
    public Bargeld(int wert) throws UnguelterWert {
        super(wert);
        boolean allowed = switch (wert) {
            case 5 -> true;
            case 10 -> true;
            case 20 -> true;
            case 50 -> true;
            case 100 -> true;
            case 200 -> true;
            default -> false;
        };
        if (!allowed) {
            throw new UnguelterWert("UnguelterWert:" + wert);
        }
    }

}
