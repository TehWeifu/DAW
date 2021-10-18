import java.util.Scanner;

public class Exercici1 {

    // Method to print even numbers based on the input range of numbers
    public static void imprimepares(final int num1, final int num2) {
        // Calculates the range of the numbers, making sure the first number is even
        int maxNum = Math.max(num1, num2);
        int minNum = Math.min(num1, num2);
        if (minNum % 2 == 1) minNum++;

        // Loop to print the range of numbers, iterates every 2 numbers
        // Prints a new line every 10 numbers printed
        for (int i = minNum; i <= maxNum; i += 2) {
            if (i % 20 == minNum % 20) System.out.println();
            System.out.print(i + "\t");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNum1, inputNum2;

        // Prompts user to input 2 numbers and validates them
        do {
            System.out.print("Introduïsca un numero sencer positiu menor a 1.000: ");
            inputNum1 = sc.nextInt();
        } while (inputNum1 < 0 || inputNum1 > 1_000);

        do {
            System.out.print("Introduïsca un altre numero sencer positiu menor a 1.000: ");
            inputNum2 = sc.nextInt();
        } while (inputNum2 < 0 || inputNum2 > 1_000);

        imprimepares(inputNum1, inputNum2);
    }
}

