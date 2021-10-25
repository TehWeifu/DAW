import java.util.Scanner;

public class Exercici2 {
    // Method that changes the format of a name, searching for a comma and splitting the string
    // Then returns the string in the proper order by concatenating strings
    public static String formatName(String name) {
        int commaPos = name.indexOf(',');
        String lastName = name.substring(0, commaPos);
        String firstName = name.substring(commaPos + 1).trim();
        return (firstName + " " + lastName);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompts user to input his full name with a specific format
        System.out.print("Introduïsca el seu nom (cognoms, nom): ");
        String inputFullName = sc.nextLine();

        System.out.println("El seu nom complet es " + formatName(inputFullName));
    }
}

