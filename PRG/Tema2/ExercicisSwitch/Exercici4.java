// Exercici 4. Crea un programa que mostre el mes en lletres, donat un valor inicial de número de mes, mitjançant la
// sentència switch.

import java.util.Scanner;

public class Exercici4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		byte monthNum;
		
		do {
			System.out.print("Introduisca un numero de mes (1-12): ");
			monthNum = input.nextByte();
		} while (monthNum < 1 || monthNum > 12);
		
		System.out.print("El mes " + monthNum + " correspon al mes ");
		
		switch (monthNum) {
			case 1:
				System.out.println("Gener");
				break;
			case 2:
				System.out.println("Febrer");
				break;
			case 3:
				System.out.println("Març");
				break;
			case 4:
				System.out.println("Abril");
				break;
			case 5:
				System.out.println("May");
				break;
			case 6:
				System.out.println("Juni");
				break;
			case 7:
				System.out.println("Juliol");
				break;
			case 8:
				System.out.println("August");
				break;
			case 9:
				System.out.println("Setembre");
				break;
			case 10:
				System.out.println("Octobre");
				break;
			case 11:
				System.out.println("Novembre");
				break;
			case 12:
				System.out.println("Decembre");
				break;
				
		}
	}
}
