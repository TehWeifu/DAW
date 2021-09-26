// 6. Demana tres números i mostrar'ls ordenats de major a menor.

import java.util.Scanner;

public class Exercici6 {
	public static void main(String[] args) {
		// declares variables
		Scanner input = new Scanner(System.in);
		double inputNum1;
		double inputNum2;
		double inputNum3;

		// ask for inputs to the user
		System.out.print("Introduïsca el primer número real: ");
		inputNum1 = input.nextDouble();
		System.out.print("Introduïsca el segon número real: ");
		inputNum2 = input.nextDouble();
		System.out.print("Introduïsca el tercer número real: ");
		inputNum3 = input.nextDouble();

		// initializes three temp variables with the input values
		var tmpA = inputNum1;
		var tmpB = inputNum2;
		var tmpC = inputNum3;

		// Sorts the numbers by comparing them two at the time
		// and swapping their values if one later one is bigger than the first one
		if (tmpB > tmpA) {
			// swap A and B
			var tmpSwap = tmpA;
			tmpA = tmpB;
			tmpB = tmpSwap;
		}

		if (tmpC > tmpA) {
			// swap A and C
			var tmpSwap = tmpA;
			tmpA = tmpC;
			tmpC = tmpSwap;
		}

		if (tmpC > tmpB) {
			// swap B and C
			var tmpSwap = tmpB;
			tmpB = tmpC;
			tmpC = tmpSwap;
		}

		// Outputs the descending order
		System.out.println("Los números en ordre descendent son: " + tmpA + "  " + tmpB + "  " + tmpC);
	}
}
