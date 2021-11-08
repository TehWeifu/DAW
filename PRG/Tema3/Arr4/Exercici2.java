import org.jetbrains.annotations.Contract;

import java.util.Arrays;
import java.util.Scanner;

public class Exercici2 {

    // Method that returns the smallest temperature in the array, making sure it is initialized
    @Contract(pure = true)
    public static double smallest(double[] arr) {
        double min = Double.MAX_EXPONENT;

        for (double tmp : arr) {
            if (tmp < -290) return min;
            if (tmp < min) min = tmp;
        }
        return min;
    }

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);


        // Prompts user to input a number of temperatures that he will input
        // Declares and initializes an array with that length, and fills it with sentinel values (-300)
        System.out.print("Introduïsca el numero de temperatures que vols introduir: ");
        final int INPUT_LENGTH = sc.nextInt();
        double[] tmpArr = new double[INPUT_LENGTH];
        Arrays.fill(tmpArr, -300);

        // Loops onces for every temperature input, making sure the user has chosen the keep inputting data option
        // Makes simple validation and then stores every temperature in the array, then prompts user to keep going
        char menuOption = 'S';
        for (int i = 0; (i < tmpArr.length && menuOption == 'S'); i++) {

            double tmpInput;
            do {
                System.out.print("Introduïsca una temperatura: ");
                tmpInput = sc.nextDouble();
            } while (tmpInput < -273.15);

            tmpArr[i] = tmpInput;

            System.out.print("Vols introduir mes temperatures? (S/N): ");
            sc.nextLine();
            menuOption = sc.nextLine().charAt(0);
        }

        // Prints the lowest temperature by calling the method
        System.out.print("La temperatura mes baixa introduïda es " + smallest(tmpArr));
    }
}

