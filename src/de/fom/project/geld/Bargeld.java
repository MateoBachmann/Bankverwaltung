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
            case 5, 10, 20, 50, 100, 200 -> true;
            default -> false;
        };
        if (!allowed) {
            throw new UnguelterWert("UnguelterWert:" + wert);
        }
    }

}
