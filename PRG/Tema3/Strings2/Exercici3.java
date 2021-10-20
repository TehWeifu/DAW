import java.util.Scanner;

public class Exercici3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduïsca una frase: ");
        String inputStr = sc.nextLine();

        String resStr = "";
        String tmpWord = "";
        for (int i = 0; i < inputStr.length(); i++) {
            tmpWord += inputStr.charAt(i);

            if (Character.isSpaceChar(inputStr.charAt(i))) {
                resStr = tmpWord + resStr;
                tmpWord = "";
            }
        }
        resStr = tmpWord + " " + resStr;

        System.out.println("La frase invertida es:");
        System.out.println(resStr);
    }
}

