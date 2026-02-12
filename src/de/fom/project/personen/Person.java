package de.fom.project.personen;

import de.fom.project.exeptions.UngueltigesAlter;

public abstract class Person {
        private int alter;
        private String name;
        private String geschlecht;

    public Person(int alter, String name, String geschlecht) {
        this.alter = alter;
        this.name = name;
        this.geschlecht = geschlecht;
    }

    public void checkAlter(int alter) throws UngueltigesAlter {
        if(16 < alter){
            throw new UngueltigesAlter("Alter ungeültig");
        }
    }
}
