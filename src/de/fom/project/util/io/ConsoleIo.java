package de.fom.project.util.io;

import de.fom.project.util.exceptions.UnguelterWert;

import java.util.Scanner;

public class ConsoleIo implements IoInterface {
    private static Scanner scanner = new Scanner(System.in);

    public void output(String message) {
        System.out.println(message);
    }
    public double requestDouble(String message) throws UnguelterWert{
        while (true) {
            System.out.println(message);
             try {
                double returnValue = scanner.nextDouble();
                scanner.nextLine();
                return returnValue;
             }catch (Exception e) {
                 System.out.println("Ungültige Angabe bitte nochmal versuchen!");
                 scanner.nextLine();
             }
        }
    }
    public double requestDouble(){
        while (true) {
            try {
                double returnValue = scanner.nextDouble();
                scanner.nextLine();
                return returnValue;

            }catch (Exception e) {
                System.out.println("Ungültige Angabe bitte nochmal versuchen");
                scanner.nextLine();
            }
        }
    }
    public int requestInt(String message) throws UnguelterWert{
        while (true) {
            System.out.println(message);
            try {
                int returnValue = scanner.nextInt();
                scanner.nextLine();
                return returnValue;
            }catch (Exception e) {
                System.out.println("Ungültige Angabe bitte nochmal versuchen!");
                scanner.nextLine();
            }
        }
    }
    public int requestInt(){
        while (true) {
            try {
                int returnValue = scanner.nextInt();
                scanner.nextLine();
                return returnValue;

            }catch (Exception e) {
                System.out.println("Ungültige Angabe bitte nochmal versuchen");
                scanner.nextLine();
            }
        }
    }
    public String requestString(String message){
        System.out.println(message);
        return scanner.nextLine();
    }
    // Nicht Schoen aber es funktioniert immer im Vergleich zu anderen methoden
    public void clearOutput() {
        for (int i=0; i <=50; i++) {
            output("");
        }
    }

    public String requestString(){
        return scanner.nextLine();
    }

    public int menu(String titel,String[] optionen){
        while(true) {
            System.out.println(titel);
            for (int i = 0; i < optionen.length; i++) {
                System.out.println((i + 1) + ". " + optionen[i]);
            }
            int answer = requestInt();
            if (answer > 0 && answer <= optionen.length) {
                return answer;
            }
        }
    }
}
