import java.util.Scanner;

public class Exercici8 {
	public static void main(String[] args) {
		// variable declaration
		Scanner input = new Scanner(System.in);
		double inputNum1;
		double inputNum2;

		// asks user for both input numbers
		System.out.print("Introduïsca un nombre real: ");
		inputNum1 = input.nextDouble();
		System.out.print("Introduïsca altre nombre real: ");
		inputNum2 = input.nextDouble();

		// checks for the biggest number by comparing them,
		// if none is bigger than the other that means they're equals
//        if (inputNum1 > inputNum2) {
//            System.out.println("El nombre " + inputNum1 + " és major que " + inputNum2);
//        } else {
//            if (inputNum1 < inputNum2) {
//                System.out.println("El numero " + inputNum2 + " és major que " + inputNum1);
//            } else {
//                System.out.println("Els dos nombres son iguals");
//            }
//        }

		// Checks if they are equals and if not prints them in order using Math methods.
		if (inputNum1 == inputNum2) System.out.println("Els dos nombres son iguals");
		else System.out.println("El nombre " + Math.max(inputNum1, inputNum2) + " és major que " + Math.min(inputNum1, inputNum2));
	}
}
