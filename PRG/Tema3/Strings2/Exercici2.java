import java.util.Scanner;

public class Exercici2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompts user to input a phrase and the position of the word to be deleted
        System.out.print("Introduïsca una frase: ");
        String inputStr = sc.nextLine();

        System.out.print("Introduïsca el numero de la paraula a eliminar: ");
        int inputPos = sc.nextInt();

        // Declares an empty string for the result and the starting position
        // Loops over the input str, keeps tracks of the word it is currently in by counting spaces
        // then copies character by character into the result except when it is the specified word
        String resStr = "";
        int currentWord = 1;
        for (int i = 0; i < inputStr.length(); i++) {
            if (currentWord != inputPos) {
                resStr += inputStr.charAt(i);
            }
            if (Character.isSpaceChar(inputStr.charAt(i))) currentWord++;
        }

        // Outputs the sentence without the specified word
        System.out.println();
        System.out.println("La frase sense la " + inputPos + " paraula es:");
        System.out.println(resStr);
    }
}

