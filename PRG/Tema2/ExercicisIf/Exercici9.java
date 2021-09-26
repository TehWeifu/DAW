// 9. Demana una nota de 0 a 10 i mostrar-la de la forma: Insuficient, Suficient, Bé, ...

import java.util.Scanner;

public class TestJava {
	public static void main(String[] args) {
		// variable declaration
		Scanner input = new Scanner(System.in);
		double inputGrade;

		// Ask for input to the user
		System.out.print("Introduïsca una nota entre 1 y 10: ");
		inputGrade = input.nextDouble();

		// First checks if grade is in range and then chooses between if states for the right statement
		if (inputGrade < 0.0 || inputGrade > 10.0) {
			System.out.println("Aquesta nota no és vàlida.");
		} else {
			System.out.print("La nota " + inputGrade + " equival a ");

			if (inputGrade == 10.0) System.out.println("\"M.H.\"");
			else if (inputGrade >= 9.0) System.out.println("\"Excel·lent\"");
			else if (inputGrade >= 7.0) System.out.println("\"Notable\"");
			else if (inputGrade >= 6.0) System.out.println("\"Bé\"");
			else if (inputGrade >= 5.0) System.out.println("\"Suficient\"");
			else System.out.println("\"Insuficient\"");
		}
	}
}
