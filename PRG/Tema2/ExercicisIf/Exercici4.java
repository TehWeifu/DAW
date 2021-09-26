// 4. Demana dos números i digues quin es el major o si son iguals.

import java.util.Scanner;

public class Exercici4 {
	public static void main(String[] args) {
		// variable declaration
		Scanner input = new Scanner(System.in);
		double inputNum1;
		double inputNum2;

		// asks user for both input numbers
		System.out.print("Introduïsca un número real: ");
		inputNum1 = input.nextDouble();
		System.out.print("Introduïsca altre número real: ");
		inputNum2 = input.nextDouble();

		// checks for the biggest number by comparing them,
		// if none is bigger than the other that means they're equals
        if (inputNum1 > inputNum2) {
            System.out.println("El número " + inputNum1 + " és major que " + inputNum2);
        } else {
            if (inputNum1 < inputNum2) {
                System.out.println("El numero " + inputNum2 + " és major que " + inputNum1);
            } else {
                System.out.println("Els dos números son iguals");
            }
        }

		// Checks if they are equals and if not prints them in order using Math methods
//		if (inputNum1 == inputNum2) System.out.println("Els dos números son iguals");
//		else System.out.println("El número " + Math.max(inputNum1, inputNum2) + " és major que " + Math.min(inputNum1, inputNum2));
	}
}
