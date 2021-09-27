// 5. Demana dos números i mostrar’ls ordenats de major a menor.
import java.util.Scanner;

public class Exercici5 {
	public static void main(String[] args) {
		// variable declaration
		Scanner input = new Scanner(System.in);
		double inputNum1;
		double inputNum2;

		// ask user for two numbers as inputs
		System.out.print("Introduïsca un número real: ");
		inputNum1 = input.nextDouble();
		System.out.print("Introduïsca un altre número real: ");
		inputNum2 = input.nextDouble();

		// outputs both numbers in order by comparing them first
		System.out.print("Els números en ordre descendent son: ");
		if (inputNum1 > inputNum2) {
			System.out.println(inputNum1 + " " + inputNum2);
		} else {
			System.out.println(inputNum2 + " " + inputNum1);
		}

		// outputs both numbers in order by using the Math max/min methods
//        System.out.println("Els números en ordre descendent son: " + Math.max(inputNum1, inputNum2) + " " + Math.min(inputNum1, inputNum2));
	}
}
