import java.util.Scanner;

public class Exercici4 {
    // Method to print a color name based on the initial char
    public static void imprimeColor (final char ch) {
        switch (ch) {
            case 'v':
                System.out.println("Verd");
                break;
            case 'a':
                System.out.println("Groc");
                break;
            case 'g':
                System.out.println("Gris");
                break;
            case 'n':
                System.out.println("Negre");
                break;
            case 'b':
                System.out.println("Blanc");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompts user to input a character and validates it
        char inputChar;
        do {
            System.out.print("Introduïsca una opció (v, a, g, n, b): ");
            inputChar = sc.next().charAt(0);
        } while (inputChar != 'v' && inputChar != 'a' && inputChar != 'g' && inputChar != 'n' && inputChar != 'b');

        imprimeColor(inputChar);
    }
}

