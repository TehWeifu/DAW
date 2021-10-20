import java.util.Scanner;

public class Exercici1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduïsca una frase: ");
        String inputStr = sc.nextLine();

        int wordCount = 0;
        String tmpString = inputStr;
        int tmpPos = 0;
        while (tmpPos != -1) {
            tmpString = tmpString.substring(tmpPos).trim();
            tmpPos = tmpString.indexOf(' ');
            wordCount++;
        }

        if (inputStr.trim().isEmpty()) wordCount = 0;

        System.out.println("La frase introduïda te " + wordCount + " paraula/es.");
    }
}

