import java.util.Arrays;
import java.util.Scanner;

public class Exercici3 {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

	// Prompts user to input a phrase
        System.out.print("Introduïsca una frase: ");
        String inputPhrase = sc.nextLine();

	// Splits the phrase into word array, then sorts it alphabetically
        var strArr = inputPhrase.split(" ");
        Arrays.sort(strArr);

	// Prints the word array word by word
        System.out.println("Les paraules ordenades alfabèticament es");
        for (String str : strArr) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
}

