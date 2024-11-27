import java.util.Scanner;
import java.util.Random;

public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean keepPlaying = true;

        while (keepPlaying) {
            Random random = new Random();
            int ranNumber = random.nextInt(20) + 1; // Neue zufällige Zahl für jede Runde
            System.out.println("Errate die Zahl des Computers, von 1 bis 20.");

            boolean game = true;

            while (game) {
                System.out.print("Gib deine Schätzung ein: ");

                // Überprüfe, ob die Eingabe ein Integer ist
                if (scanner.hasNextInt()) {
                    int number = scanner.nextInt();

                    // Prüfe, ob die Zahl im erlaubten Bereich liegt
                    if (number < 1 || number > 20) {
                        System.out.println("Du musst eine Zahl zwischen 1 und 20 eingeben.");
                    } else {
                        // Logik für die Schätzung
                        if (number == ranNumber) {
                            System.out.println("Richtig! Gewonnen!");
                            game = false; // Beende die aktuelle Runde
                        } else if (number < ranNumber) {
                            System.out.println("Versuch höher zu schätzen");
                        } else {
                            System.out.println("Versuch tiefer zu schätzen");
                        }
                    }
                } else {
                    System.out.println("Falsche Eingabe! Bitte gib eine ganze Zahl ein.");
                    scanner.next(); // Ungültige Eingabe überspringen / löschen
                }
            }

            // Neuen Runde?
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Möchtest du eine neue Runde spielen? (J/N): ");
                String answer = scanner.next().trim().toUpperCase();

                if (answer.equals("J")) {
                    validInput = true;
                    System.out.println("Eine neue Runde startet!");
                } else if (answer.equals("N")) {
                    validInput = true;
                    keepPlaying = false;
                    System.out.println("Danke fürs Spielen! Auf Wiedersehen!");
                } else {
                    System.out.println("Ungültige Eingabe! Bitte antworte mit 'J' für Ja oder 'N' für Nein.");
                }
            }
        }
    }
}