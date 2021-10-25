import java.util.Scanner;

public class Exercici4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompts user to input a phrase
        System.out.print("Introduïsca una frase: ");
        String inputStr = sc.nextLine();

        // Declares counting variables and loops over the string, increment each variable
        // if the character is uppercase or lowercase on each case
        int countUpper = 0;
        int countLower = 0;
        for (int i = 0; i < inputStr.length(); i++) {
            if (Character.isUpperCase(inputStr.charAt(i))) countUpper++;
            if (Character.isLowerCase(inputStr.charAt(i))) countLower++;
        }

        System.out.println("La frase te " + countLower + " minuscules i " + countUpper + " majúscules.");        
    }
}

