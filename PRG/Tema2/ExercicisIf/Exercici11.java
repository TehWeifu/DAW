// 11. Demana el día, mes i any d’una data e indicar si la data és correcta.
//     Amb mesos de 28, 30 i 31 dies. Sense anys de trapás (bisiestos)

import java.util.Scanner;

public class Exercici11 {
	public static void main(String[] args) {
		// variable declaration
		Scanner input = new Scanner(System.in);
		byte inputDay;
		byte inputMonth;
		long inputYear;

		// ask user for day, month and year
		System.out.print("Introduïsca un dia (1-30): ");
		inputDay = input.nextByte();
		System.out.print("Introduïsca un mes (1-12): ");
		inputMonth = input.nextByte();
		System.out.print("Introduïsca un any: ");
		inputYear = input.nextLong();

		// First checks days are between 1 and 31 and months are between 1 and 12
		// Then checks the day is not over 30 for April, June, September and November
		if (inputDay < 1 || inputDay > 31 || inputMonth < 1 || inputMonth > 12) {
			System.out.println("La data " + inputDay + "\\" + inputMonth + "\\" + inputYear + " no és correcta");
		} else {
			if ((inputMonth == 4 || inputMonth == 6 || inputMonth == 9 ||inputMonth == 11) && inputDay > 30) {
				System.out.println("La data " + inputDay + "\\" + inputMonth + "\\" + inputYear + " no és correcta");
			} else if (inputMonth == 2 && inputDay > 28) {
				System.out.println("La data " + inputDay + "\\" + inputMonth + "\\" + inputYear + " no és correcta");

			} else {
				System.out.println("La data " + inputDay + "\\" + inputMonth + "\\" + inputYear + " és correcta");
			}
		}
	}
}
