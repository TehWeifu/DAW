import java.util.Scanner;

public class Exercici5 {
	public static void main(String[] args) {
		//variable declaration
		Scanner input = new Scanner(System.in);
		double inputNum;

		// ask user for a number
		System.out.print("Introduïsca un número real: ");
		inputNum = input.nextDouble();

		// checks whether the number is positive or negative by comparing it to 0
		if (inputNum > 0.0) {
			System.out.println("El número és positiu");
		} else if (inputNum < 0.0) {
			System.out.println("El número és negatiu");
		} else {
			System.out.println("El número és zero");
		}
	}
}
