import java.util.Scanner;

public class TestJava {
    public static void printMenu(){
        System.out.println("MENU");
        System.out.println("1. Prestar");
        System.out.println("2. Informar");
        System.out.println("3. Mostrar tot");
        System.out.println("4. Eixir");
    }

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int LENGTH = 15;

        String[] titles = new String[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            titles[i] = ("Titol" + (i + i));
        }

        int[] numArr = new int[LENGTH];

        int menuOption;
        do {

            System.out.print("Introduisca una opcio:");
            menuOption = sc.nextInt();
        } while (menuOption != 4);
    }
}

