// Exercici 4. Crea un programa que mostre el mes en lletres, donat un valor inicial de número de mes, mitjançant la
// sentència switch.

import java.util.Scanner;

public class Exercici4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		byte monthNum;

		do {
			System.out.print("Introduïsca un numero de mes (1-12): ");
			monthNum = input.nextByte();
		} while (monthNum < 1 || monthNum > 12);

		System.out.print("El mes " + monthNum + " correspon al mes ");

		switch (monthNum) {
			case 1 -> System.out.println("Gener");
			case 2 -> System.out.println("Febrer");
			case 3 -> System.out.println("Març");
			case 4 -> System.out.println("Abril");
			case 5 -> System.out.println("May");
			case 6 -> System.out.println("Juny");
			case 7 -> System.out.println("Juliol");
			case 8 -> System.out.println("August");
			case 9 -> System.out.println("Setembre");
			case 10 -> System.out.println("Octubre");
			case 11 -> System.out.println("Novembre");
			case 12 -> System.out.println("Desembre");
		}
	}
}
