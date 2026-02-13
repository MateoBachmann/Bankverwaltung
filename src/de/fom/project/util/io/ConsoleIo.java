package de.fom.project.util.io;

import de.fom.project.util.exceptions.UnguelterWert;
import de.fom.project.util.exceptions.UngueltigeEingabe;

import java.util.Scanner;

public class ConsoleIo implements IoInterface {
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void output(String message) {
        System.out.println(message);
    }
    public double requestDouble(String message) throws UnguelterWert{
        for (int i=0; i <=10; i++) {
             try {
                return scanner.nextDouble();


             }catch (NumberFormatException e) {
                 System.out.println("Ungültige Angabe bitte nochmal versuchen!");
             }
        }
        throw new UngueltigeEingabe("Keine Gültige Angabe nach 10 versuchen!");
    }
    public double requestDouble() throws UnguelterWert{
        String line;
        for (int i=0; i <=10; i++) {
            try {
                return scanner.nextDouble();

            }catch (NumberFormatException e) {
                System.out.println("Ungültige Angabe bitte nochmal versuchen");
            }
        }
        throw new UngueltigeEingabe("Keine Gültige Angabe nach 10 versuchen");
    }
    public String requestString(String message){
        System.out.println(message);
        return scanner.nextLine();
    }

    public String requestString(){
        return scanner.nextLine();
    }

    public int menu(String titel,String[] optionen){
        System.out.println(titel);
        for (int i=0;i < optionen.length;i++) {
            System.out.println((i) + ". " + optionen[i]);
        }
        try{
            return scanner.nextInt();
        }catch (Exception e) {
            return -1;
        }
    }
}
