import java.util.Scanner;

public class Exercici3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompts user to input a sentence
        System.out.print("Introduïsca una frase: ");
        String inputStr = sc.nextLine();

        // Declares a string to keep track of the current word and the resulting string
        // Loops over the input string updating the word string
        // When it finds a space, puts the current word at the beginning of the result string
        // And resets the current word.
        // After the loops ends, adds the last word to the result and trims white spaces.
        String resStr = "";
        String tmpWord = "";
        for (int i = 0; i < inputStr.length(); i++) {
            tmpWord += inputStr.charAt(i);

            if (Character.isSpaceChar(inputStr.charAt(i))) {
                resStr = tmpWord + resStr;
                tmpWord = "";
            }
        }
        resStr = (tmpWord + " " + resStr).trim();

        // Outputs the resulting sentence
        System.out.println("La frase invertida és:");
        System.out.println(resStr);
    }
}

