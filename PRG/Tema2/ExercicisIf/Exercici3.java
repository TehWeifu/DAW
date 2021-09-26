//3. Demana dos números i digues quin es el major.

import java.util.Scanner;

public class Exercici3 {
	public static void main(String[] args) {
		// variable declaration
		Scanner input = new Scanner(System.in);
		double inputNum1;
		double inputNum2;

		// ask the user for two integers
		System.out.print("Introduïsca un número real: ");
		inputNum1 = input.nextDouble();
		System.out.print("Introduïsca un altre número real: ");
		inputNum2 = input.nextDouble();

		// obtains the bigger one by comparing them and outputs the corresponding statement
		if (inputNum1 > inputNum2) {
			System.out.println("El número " + inputNum1 + " és major que " + inputNum2);
		} else {
			System.out.println("El número " + inputNum2 + " és major que " + inputNum1);
		}

		// obtains the bigger and smaller number by using the Math functions
//        System.out.println("El número " + Math.max(inputNum1, inputNum2) + " és major que " + Math.min(inputNum1, inputNum2));
	}
}
