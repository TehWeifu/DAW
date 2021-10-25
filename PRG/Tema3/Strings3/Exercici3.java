import java.util.Scanner;

public class Exercici3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompts user to input a phrase
        System.out.print("Introduïsca una frase: ");
        String inputStr = sc.nextLine();

        // Declares variables to count the 'a' or 'A' occurrences and a result string with the modified values
        // Then loops over the original string, doing the count and copying the original or switched character
        int countUpper = 0;
        int countLower = 0;
        String resStr = "";
        for (int i = 0; i < inputStr.length(); i++) {
            switch (inputStr.charAt(i)) {
                case 'a':
                    countLower++;
                    resStr += 'i';
                    break;
                case 'A':
                    countUpper++;
                    resStr += 'I';
                    break;
                default:
                    resStr += inputStr.charAt(i);
                    break;
            }
        }

        // Prints the count of letters and the resulting string
        System.out.println("La frase te un total de " + countLower + " 'a' minuscules.");
        System.out.println("La frase te un total de " + countUpper + " 'A' majúscules.");
        System.out.println("La frase amb 'i' en lloc de 'a' es: " + resStr);
    }
}

