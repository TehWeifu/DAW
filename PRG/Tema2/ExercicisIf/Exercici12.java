//12. Demana el día, mes i any d’una data correcta i mostra la data del dia següent.
//    Suposem que tots els mesos tenen 30 dies.

import java.util.Scanner;

public class TestJava {
	public static void main(String[] args) {
		// variable declaration
		Scanner input = new Scanner(System.in);
		byte inputDay;
		byte inputMonth;
		long inputYear;

		byte nextDay;
		byte nextMonth;
		long nextYear;

		// ask user for day, month, year
		System.out.print("Introduïsca un dia (1-30): ");
		inputDay = input.nextByte();
		System.out.print("Introduïsca un mes (1-12): ");
		inputMonth = input.nextByte();
		System.out.print("Introduïsca un any: ");
		inputYear = input.nextLong();

		// adds a day and assigns the input values to the next day values
		nextDay = (byte) (inputDay + 1);
		nextMonth = inputMonth;
		nextYear = inputYear;

		// checks if day is over the month day's count, if so it resets the days and adds one to the month
		if (nextDay > 30) {
			nextDay = 1;
			nextMonth++;
		}

		// checks if month is over the year month's count, if so it resets the days and adds one to the month
		if (nextMonth > 12) {
			nextDay = 1;
			nextMonth = 1;
			nextYear++;
		}

		// Mostra la data original i l'endemà.
		System.out.println("El dia següent a " + inputDay + "\\" + inputMonth + "\\" + inputYear + " es "
				+ nextDay + "\\" + nextMonth + "\\" + nextYear);
	}
}
