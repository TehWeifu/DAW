import java.util.Scanner;

public class Exercici14 {
	public static void main(String[] args) {
		// variable declaration
		Scanner input = new Scanner(System.in);
		double inputGrade;

		// Ask for input to the user
		System.out.print("Introduïsca una nota entre 1 y 10: ");
		inputGrade = input.nextDouble();

		// First checks if grade is in range and then chooses between if states for the right statement
		if (inputGrade < 0.0 || inputGrade > 10.0) {
			System.out.println("Esta nota no es valida.");
		} else {
			System.out.print("La nota " + inputGrade + " equivale a ");

			if (inputGrade == 10.0) System.out.println("\"M.H.\"");
			else if (inputGrade >= 9.0) System.out.println("\"Sobresaliente\"");
			else if (inputGrade >= 7.0) System.out.println("\"Notable\"");
			else if (inputGrade >= 6.0) System.out.println("\"Bien\"");
			else if (inputGrade >= 5.0) System.out.println("\"Suficiente\"");
			else System.out.println("\"Insuficiente\"");
		}
	}
}
