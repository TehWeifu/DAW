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


		System.out.print("Introduzca un dia (1-30): ");
		inputDay = input.nextByte();
		System.out.print("Introduzca un mes (1-12): ");
		inputMonth = input.nextByte();
		System.out.print("Introduzca un any: ");
		inputYear = input.nextLong();

		nextDay = (byte) (inputDay + 1);
		nextMonth = inputMonth;
		nextYear = inputYear;

		if (nextDay > 30) {
			nextDay = 1;
			nextMonth++;
		}
		if (nextMonth > 12) {
			nextDay = 1;
			nextMonth = 1;
			nextYear++;
		}

		System.out.println("El dia siguiente a " + inputDay + "\\" + inputMonth + "\\" + inputYear + " es "
				+ nextDay + "\\" + nextMonth + "\\" + nextYear);
	}
}
