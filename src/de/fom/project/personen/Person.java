package de.fom.project.personen;

import de.fom.project.util.exceptions.UngueltigesAlter;

public abstract class Person {
        private int alter;
        private String name;
        private String geschlecht;

    public Person(int alter, String name, String geschlecht) throws UngueltigesAlter {
        if (!checkAlter(alter)) {
            throw new UngueltigesAlter("Person zu jung");
        }
        this.alter = alter;
        this.name = name;
        this.geschlecht = geschlecht;
    }

    public boolean checkAlter(int alter) {
        //
        return alter >= 16;
    }
}
