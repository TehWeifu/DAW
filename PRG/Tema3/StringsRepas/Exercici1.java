import java.util.Scanner;

public class Exercici1 {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        // variable to keep track of number of tries to guess the password
        int userTries = 0;

        // Prompts user to input the initial password
        System.out.print("Introduïsca una contrasenya: ");
        String inputPass = sc.nextLine();

        // Loops until the user guesses the password
        // Prompts user to input a guess
        // Then loops over every character, outputting the character if guesses correctly or '*' if not
        String userGuess = "";
        System.out.println("La longitud de la contrasenya es " + inputPass.length() + " lletres");
        do {
            userTries++;

            System.out.print("Encerta la paraula: ");
            userGuess = sc.nextLine();

            System.out.print("Has encertat: ");
            for (int i = 0; i < inputPass.length(); i++) {
                if (userGuess.length() > i && (inputPass.charAt(i) == userGuess.charAt(i))) {
                    System.out.print(inputPass.charAt(i));
                } else {
                    System.out.print('*');
                }
            }
            System.out.println();

        } while (!inputPass.equals(userGuess));
        System.out.println("Enhorabona, has encertar la contrasenya en " + userTries + " intents.");
    }
}

