import java.util.Scanner;

public class Exercici12 {
	public static void main(String[] args) {
		// variable declaration
		Scanner input = new Scanner(System.in);
		int inputNum;
		int tmpNum;

		// Ask for input and assigns it to the temporal variable
		System.out.print("Introduïsca un número entre 0 y 9.999: ");
		inputNum = input.nextInt();
		tmpNum = inputNum;

		// outputs the digits one by one doing the mod and diving each time the number by 10
		if (inputNum > 9_999 || inputNum < 0) {
			System.out.println("El número introduït no és valid");
		} else {
			System.out.print("El número " + inputNum + " al revés és ");

			System.out.print(tmpNum % 10);
			tmpNum /= 10;
			if (tmpNum > 0) {
				System.out.print(tmpNum % 10);
				tmpNum /= 10;
			}
			if (tmpNum > 0) {
				System.out.print(tmpNum % 10);
				tmpNum /= 10;
			}
			if (tmpNum > 0) {
				System.out.print(tmpNum % 10);
			}
		}
	}
}
