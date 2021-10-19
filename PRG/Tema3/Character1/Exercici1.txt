import java.util.Scanner;

public class Exercici1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompts user to input 2 characters and declares its variables
        System.out.print("Introduïsca un caràcter: ");
        char inputCh1 = sc.nextLine().charAt(0);
        System.out.print("Introduïsca un caràcter: ");
        char inputCh2 = sc.nextLine().charAt(0);

        // Outputs the result of comparing the code of the 2 characters
        System.out.println();
        int compareRes = Character.compare(inputCh1, inputCh2);
        if (compareRes == 0) {
            System.out.println("Son el mateix caràcter");
        } else if (compareRes > 0) {
            System.out.println("El caràcter " + inputCh1 + " és major que el caràcter " + inputCh2);
        } else {
            System.out.println("El caràcter " + inputCh2 + " és major que el caràcter " + inputCh1);
        }

        // Outputs whether the characters are a number, a letter or other
        System.out.println();
        if (Character.isLetterOrDigit(inputCh1)) {
            if (Character.isLetter(inputCh1)) {
                System.out.println("El caràcter " + inputCh1 + " és una lletra");
            } else {
                System.out.println("El caràcter " + inputCh1 + " és un numero");
            }
        } else {
            System.out.println("El caràcter " + inputCh1 + " no és ni una lletra ni un numero");
        }
        if (Character.isLetterOrDigit(inputCh2)) {
            if (Character.isLetter(inputCh2)) {
                System.out.println("El caràcter " + inputCh2 + " és una lletra");
            } else {
                System.out.println("El caràcter " + inputCh2 + " és un numero");
            }
        } else {
            System.out.println("El caràcter " + inputCh2 + " no és ni una lletra ni un numero");
        }

        // Outputs the capitalized version of the character if it is a letter
        System.out.println();
        if (Character.isLetter(inputCh1)) {
            System.out.println("La lletra " + inputCh1 + " en majúscula és " + Character.toUpperCase(inputCh1));
        }
        if (Character.isLetter(inputCh2)) {
            System.out.println("La lletra " + inputCh2 + " en majúscula és " + Character.toUpperCase(inputCh2));
        }
    }
}

