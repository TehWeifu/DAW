import java.util.Scanner;

public class Exercici2 {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

	// variable to keep accumulate the whole prase and the input word
        String totalPhrase = "";
        String inputStr = "";

	// Loops until the user inputs "fi" (regardless of case). Concatenates the word to the phrase
        while (!inputStr.toLowerCase().equals("fi")) {
            totalPhrase += inputStr.toLowerCase().trim() + " ";

            System.out.print("Introduïsca una paraula: ");
            inputStr = sc.nextLine();
        }
        totalPhrase = totalPhrase.trim();

	// Prints the resulting string
        System.out.println("La frase final es");
        System.out.println(totalPhrase);
    }
}

