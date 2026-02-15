package de.fom.project.util.io;

import java.util.List;

public class Io {
    private static IoInterface io = new ConsoleIo(); // Hier kann enschieden werden welche Ausgabe (erweiterbarkeit)


    public static Double requestDouble(String message) {
        return io.requestDouble(message);
    }

    public static Double requestDouble() {
        return io.requestDouble();
    }

    public static int requestInt(String message) {
        return io.requestInt(message);
    }

    public static int requestInt() {
        return io.requestInt();
    }
    public static String requestString(String message) {
        return io.requestString(message);
    }

    public static String requestString() {
        return io.requestString();
    }

    public static void changeIo(IoInterface ioNew) {
        io = ioNew;
    }

    public static int getMenuSelection(String titel, String[] optionen) {
        return io.menu(titel,optionen);
    }

    public static void output(String message) {
        io.output(message);
    }

    public static void clearOutput() {
        io.clearOutput();
    }
}
