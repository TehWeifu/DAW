import java.util.Scanner;

public class Ejercicio1 {

    // Method that returns true if a String is composed by only digits.
    // Returns false if there is a non-digit character
    public static boolean isNumber(final String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }

    // Method that formats a phone number from 9 digits to (XXX-XX-XX-XX)
    // Returns the formatted string of null if it is not a value number
    public static String formatPhoneNumber(final String str) {
        if (str.length() != 9) return null;
        String res = "";
        res += str.substring(0, 3);
        res += '-';
        res += str.substring(3, 5);
        res += '-';
        res += str.substring(5, 7);
        res += '-';
        res += str.substring(7, 9);
        return res;
    }

    public static void main(String[] args) {

        // Scanner declaration and initialization
        Scanner sc = new Scanner(System.in);

        // Prompts user to input a phone Number and validates for the length and its contents
        String inputTlf;
        do {
            System.out.print("Introduce un número de teléfono: ");
            inputTlf = sc.nextLine().trim();
        } while (inputTlf.length() != 9 || (!isNumber(inputTlf)));

        // Prints the resulting string by calling the "formatPhoneNumber" method
        System.out.println("Su número de teléfono con formato es: " + formatPhoneNumber(inputTlf));
    }
}

