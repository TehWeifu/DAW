import java.util.Scanner;

public class Exercici1 {
    public static void main(String[] args) {
        
        // Constant declaration for array length and console scanner
        final byte NUM_COUNT = 5;
        final Scanner sc = new Scanner(System.in);

        // Variable declaration for array and sum count
        double[] numArr = new double[NUM_COUNT];
        double sum = 0.0;

        // Loops as many times as the array length, prompting user to input a real number
        // Storing the number in the array and adding it to the sum variable
        for (int i = 0; i < NUM_COUNT; i++) {
            System.out.print("Introduïsca el " + (i + 1) + " numero real: ");
            numArr[i]  = sc.nextDouble();

            sum += numArr[i];
        }

        // Outputs the average by dividing the sum and the array length
        System.out.println("La mitjana dels números introduïts es " + (sum / NUM_COUNT));
    }
}

