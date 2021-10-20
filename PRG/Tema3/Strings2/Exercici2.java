import java.util.Scanner;

public class Exercici2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduïsca una frase: ");
        String inputStr = sc.nextLine();

        System.out.print("Introduïsca el numero de la paraula a eliminar: ");
        int inputPos = sc.nextInt();

        String resStr = "";
        int currentWord = 1;
        for (int i = 0; i < inputStr.length(); i++) {
            if (currentWord != inputPos) {
                resStr += inputStr.charAt(i);
            }
            if (Character.isSpaceChar(inputStr.charAt(i))) currentWord++;
        }

        System.out.println(resStr);
    }
}

