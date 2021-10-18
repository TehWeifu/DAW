import java.util.Scanner;

public class Exercici2 {

    // Method that returns the sum of 2 numbers
    public static int sumarnumeros(int num1, int num2) {
        return num1 + num2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNum1, inputNum2;

        // Prompts user to input 2 numbers and validates them
        do {
            System.out.print("Introduïsca un numero entre 1 i 15: ");
            inputNum1 = sc.nextInt();
        } while (inputNum1 < 1 || inputNum1 > 15);

        do {
            System.out.print("Introduïsca un altre numero sencer entre 1 i 15: ");
            inputNum2 = sc.nextInt();
        } while (inputNum2 < 1 || inputNum2 > 15);

        
        System.out.println("La suma de " + inputNum1 + " i " + inputNum2 + " es " + sumarnumeros(inputNum1, inputNum2));
    }
}

