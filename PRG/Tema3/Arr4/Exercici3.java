import java.util.Arrays;
import java.util.Scanner;

public class Exercici3 {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        // Declares three arrays with constant length
        String[] firstNames = new String[3];
        String[] lastNames = new String[3];
        String[] fullNames = new String[3];

        // Loops over the arrays length and saves on each array the name or surname, splitting it by comma ','
        // Then concatenes both with a space in the resulting array
        for (int i = 0; i < firstNames.length; i++) {
            System.out.print("Introduïsca els noms i cognoms (noms, cognoms): ");
            String inputName = sc.nextLine();
            firstNames[i] = inputName.substring(0, inputName.indexOf(',')).trim();
            lastNames[i] = inputName.substring(inputName.indexOf(',') + 1).trim();

            fullNames[i] = (lastNames[i] + " " + firstNames[i]);
        }

        // Prints all 3 arrays by using the toStringMethod
        System.out.println("El array de noms es");
        System.out.println(Arrays.toString(firstNames));

        System.out.println("El array de cognoms es");
        System.out.println(Arrays.toString(lastNames));

        System.out.println("El array de noms complets es");
        System.out.println(Arrays.toString(fullNames));
    }
}

