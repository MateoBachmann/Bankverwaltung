package de.fom.project.util.io;

import java.util.List;

public class Io {
    private static IoInterface io = new ConsoleIo(); // Hier kann enschieden werden welche Ausgabe (erweiterbarkeit)


    public static <T> T requestInput(String message) {
        return io.requestInput(message);
    }

    public static <T> T requestInput() {
        return io.requestInput();
    }

    public static void changeIo(IoInterface ioNew) {
        io = ioNew;
    }

    public static int getMenuSelection(String titel, String[] optionen) {
        return io.menu(titel,optionen);
    }
}
