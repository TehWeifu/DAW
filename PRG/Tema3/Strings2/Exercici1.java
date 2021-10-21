import java.util.Scanner;

public class Exercici1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompts user to input a phrase
        System.out.print("Introduïsca una frase: ");
        String inputStr = sc.nextLine();

        // Declares variable for counting word, current position and a temporal string
        // Checks it is not an empty string or filled with spaces.
        // Then loops over the phrase counting the words by adding 1 when it finds an
        // occourence of a space, then trims the remaining spaces in case there is more
        // than 1 space between words
        int wordCount = 0;
        String tmpString = inputStr;
        int tmpPos = 0;
        if (!inputStr.trim().isEmpty()) {
            while (tmpPos != -1) {
                tmpString = tmpString.substring(tmpPos).trim();
                tmpPos = tmpString.indexOf(' ');
                wordCount++;
            }
        }

        // Outputs the count on words either in singular or plural by checking the amount
        System.out.println("La frase introduïda te " + wordCount + " paraul" + (wordCount == 1 ? "a." : "es."));
    }
}

