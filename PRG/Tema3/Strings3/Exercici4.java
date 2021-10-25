import java.util.Scanner;

public class Exercici4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompts user to input an ID
        System.out.print("Introduïsca un DNI: ");
        String inputDni = sc.nextLine();

        // Declares a bool variable to keep track is it is still possible for the ID to be valid
        // First checks the length and then loops over the string checking for each character to be a number
        // Then, checks the last character is a letter
        boolean isValid = true;
        if (inputDni.length() == 9) {
            for (int i = 0; (i < inputDni.length() - 1 && isValid); i++) {
                if (!Character.isDigit(inputDni.charAt(i))) isValid = false;
            }
            if (!Character.isLetter(inputDni.charAt(8))) isValid = false;
        } else {
            isValid = false;
        }

        if (isValid) {
            System.out.println("La part numèrica del NIF es: " + inputDni.substring(0, 8));
        } else {
            System.out.println("NIF no valid.");
        }
    }
}

