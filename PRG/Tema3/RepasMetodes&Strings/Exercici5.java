import java.util.Scanner;

public class Exercici5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompts user to input a phrase, the character to be replaced and the new character
        System.out.print("Introduïsca una frase: ");
        String inputStr = sc.nextLine();
        System.out.print("Introduïsca el caràcter que vols canviar: ");
        char inputOldChar = sc.nextLine().charAt(0);
        System.out.print("Introduïsca el nou caràcter per el que el vols canviar: ");
        char inputNewChar = sc.nextLine().charAt(0);

        // Loops over the array, copying the new character when it finds the character to be replaced
        // or the original character if it doesn't find an occurrence
        String resStr = "";
        for (int i = 0; i < inputStr.length(); i++) {
            if (inputStr.charAt(i) == inputOldChar) {
                resStr += inputNewChar;
            } else {
                resStr += inputStr.charAt(i);
            }
        }

        System.out.println("La frase canviada es: " + resStr);
    }
}

