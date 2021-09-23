import java.util.Scanner;

public class Exercici7 {
	public static void main(String[] args) {
		// variable declaration
		Scanner input = new Scanner(System.in);
		double inputNum1;
		double inputNum2;

		// ask the user for two integers
		System.out.print("Introduïsca un nombre real: ");
		inputNum1 = input.nextDouble();
		System.out.print("Introduïsca altre nombre real: ");
		inputNum2 = input.nextDouble();

		// obtains the bigger one by comparing them and outputs the corresponding statement
		if (inputNum1 > inputNum2) {
			System.out.println("El nombre " + inputNum1 + " és major que " + inputNum2);
		} else {
			System.out.println("El nombre " + inputNum2 + " és major que " + inputNum1);
		}

		// obtains the bigger and smaller number by using the Math functions
//        System.out.println("El nombre " + Math.max(inputNum1, inputNum2) + " és major que " + Math.min(inputNum1, inputNum2));
	}
}
