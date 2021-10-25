import java.util.Scanner;

public class TestJava {
    // Method that replaces a character for its uppercase version, on the whole string
    public static String capLetter(String str, char letter) {
        String res = "";
        char upperLetter = Character.toUpperCase(letter);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == letter) {
                res += upperLetter;
            } else {
                res += str.charAt(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompts user to input a string and a character to replace
        System.out.print("Introduïsca una frase: ");
        String inputStr = sc.nextLine();
        System.out.print("Introduïsca el caràcter a modificar: ");
        char inputChar = sc.nextLine().charAt(0);

        System.out.println("La frase es: " + capLetter(inputStr, inputChar));
    }
}

