// 10. Demana el dia, mes i any d’una data i indicar si la data és correcta.
//     Suposem que tots els mesos tenen 30 dies

import java.util.Scanner;

public class Exercici10 {
	public static void main(String[] args) {
		// variable declaration
		Scanner input = new Scanner(System.in);
		byte inputDay;
		byte inputMonth;
		long inputYear;

		// as user for day, month, year
		System.out.print("Introduïsca un dia (1-30): ");
		inputDay = input.nextByte();
		System.out.print("Introduïsca un mes (1-12): ");
		inputMonth = input.nextByte();
		System.out.print("Introduïsca un any: ");
		inputYear = input.nextLong();

		// checks days are between 1 and 30 and months are between 1 and 12
		if (inputDay < 1 || inputDay > 30 || inputMonth < 1 || inputMonth > 12) {
			System.out.println("La data " + inputDay + "\\" + inputMonth + "\\" + inputYear + " no és correcta");
		} else {
			System.out.println("La data " + inputDay + "\\" + inputMonth + "\\" + inputYear + " és correcta");
		}
	}
}
