import java.util.Scanner;

public class Exercici3 {
    public static void main(String[] args) {

        // Constant declaration for array length and console scanner
        final byte NUM_COUNT = 10;
        final Scanner sc = new Scanner(System.in);

        // Variable declaration for the array and the biggest number and its position
        // Initializing them to the lowest values, will be overwritten after the first loop
        double[] numArr = new double[NUM_COUNT];
        double bigNum = Double.MIN_VALUE;
        int bigPos = -1;

        // Loops as many times as the array length, prompting user to input real numbers
        // stores the number in the array position and checks if it is bigger than the current biggest num
        // swapping its value and position with it.
        for (int i = 0; i < NUM_COUNT; i++) {
            System.out.print("Introduïsca el " + (i + 1) + " numero real: ");
            double tmpNum = sc.nextDouble();            
            numArr[i] = tmpNum;
            
            if ((tmpNum % 2 == 0) && (tmpNum >= bigNum)) {
                bigNum = tmpNum;
                bigPos = i;
            }
        }

        // Prints the biggest number and its position in the array
        System.out.println("El major numero es " + bigNum + ". Esta en la posició  " + bigPos + " del array");
    }
}

