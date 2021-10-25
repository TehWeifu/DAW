import java.util.Scanner;

public class Exercici1 {
    // Method to count the space separated words of a string
    public static int countWords(String str) {
        int wordCount = 0;
        String tmpString = str;
        int tmpPos = 0;
        if (!str.trim().isEmpty()) {
            while (tmpPos != -1) {
                tmpString = tmpString.substring(tmpPos).trim();
                tmpPos = tmpString.indexOf(' ');
                wordCount++;
            }
        }
        return wordCount;
    }

    // Method to remove the k-ish word of an string
    public static String removeWord(String str, int pos) {
        String resStr = "";
        int currentWord = 1;
        for (int i = 0; i < str.length(); i++) {
            if (currentWord != pos) {
                resStr += str.charAt(i);
            }
            if (Character.isSpaceChar(str.charAt(i))) currentWord++;
        }
        return resStr;
    }

    // Method to reverse the word of a string
    public static String reverseSentence(String str) {
        String resStr = "";
        String tmpWord = "";
        for (int i = 0; i < str.length(); i++) {
            tmpWord += str.charAt(i);

            if (Character.isSpaceChar(str.charAt(i))) {
                resStr = tmpWord + resStr;
                tmpWord = "";
            }
        }
        resStr = (tmpWord + " " + resStr).trim();
        return resStr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prints menu and prompts user to input an option
        byte inputMenu;
        do {
            System.out.println("************ MENU *************");
            System.out.println("*\t1. Comptar paraules       *");
            System.out.println("*\t2. Eliminar paraules      *");
            System.out.println("*\t3. Escriure a la inversa  *");
            System.out.println("*******************************");
            System.out.print("Tria una opció: ");
            inputMenu = sc.nextByte();
            sc.nextLine();
            System.out.println();
        } while (inputMenu < 1 || inputMenu > 3);

        // Prompts user to input a sentence regardless of the option chosen
        System.out.print("Introduïsca una frase: ");
        String inputStr = sc.nextLine();

        // Calls a method based on the option chosen and displays the result
        switch (inputMenu) {
            case 1:
                System.out.println("La frase te " + countWords(inputStr) + " paraules");
                break;
            case 2:
                System.out.print("Introduïsca la posició de la paraula a eliminar: ");
                int inputPos = sc.nextInt();
                System.out.print("La frase sense la " + inputPos + " paraula es: " + removeWord(inputStr, inputPos));
                break;
            case 3:
                System.out.println("La frase invertida es: " + reverseSentence(inputStr));
                break;
        }
    }
}

