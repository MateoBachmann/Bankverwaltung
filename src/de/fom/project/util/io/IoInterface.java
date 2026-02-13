package de.fom.project.util.io;

import java.util.List;

/***
 * Dieses Interface dient der erweiterbarkeit, sollten weitere I/O-classen erstellt werden, müssen diese dieses Interface implementieren und in der Klasse Io anstatt ConsoleIo verwendet werden
 */
public interface IoInterface {
    //public <T> T requestInput(String message);
    //public <T> T requestInput();

    public String requestString(String message);
    public String requestString();
    public double requestDouble(String message);
    public double requestDouble();
    public void output(String message);
    public int menu(String titel,String[] optionen);
}
