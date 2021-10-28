import java.util.Scanner;

public class Exercici2 {
    public static void main(String[] args) {
        
        // Constant declaration for array length and console scanner
        final byte NUM_COUNT = 10;
        final Scanner sc = new Scanner(System.in);

        // Variable declaration for the array and 
        double[] numArr = new double[NUM_COUNT];
        double sum = 0.0;
        
        // Loops as many times as the array length, prompting user to input a number
        // stores the number on each array Position
        // adds to the sum variable if it is in an even position
        for (int i = 0; i < NUM_COUNT; i++) {
            System.out.print("Introduïsca el " + (i + 1) + " numero real: ");
            numArr[i]  = sc.nextDouble();

            if (i % 2 == 0) sum += numArr[i];
        }

        // Outputs the average of the even positions dividing the length by half
        System.out.println("La mitjana dels números en posicions parelles es " + (sum / (NUM_COUNT / 2)));
    }
}

