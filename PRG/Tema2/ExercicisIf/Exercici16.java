import java.util.Scanner;

public class TestJava {
	public static void main(String[] args) {
		// variable declaration
		Scanner input = new Scanner(System.in);
		byte inputDay;
		byte inputMonth;
		long inputYear;

		System.out.print("Introduzca un dia (1-30): ");
		inputDay = input.nextByte();
		System.out.print("Introduzca un mes (1-12): ");
		inputMonth = input.nextByte();
		System.out.print("Introduzca un any: ");
		inputYear = input.nextLong();

		if (inputDay < 1 || inputDay > 31 || inputMonth < 1 || inputMonth > 12) {
			System.out.println("La fecha " + inputDay + "\\" + inputMonth + "\\" + inputYear + " no es correcta");
		} else {
			if ((inputMonth == 4 || inputMonth == 6 || inputMonth == 9 ||inputMonth == 11) && inputDay > 30) {
				System.out.println("La fecha " + inputDay + "\\" + inputMonth + "\\" + inputYear + " no es correcta");
			} else if (inputMonth == 2 && inputDay > 28) {
				System.out.println("La fecha " + inputDay + "\\" + inputMonth + "\\" + inputYear + " no es correcta");

			} else {
				System.out.println("La fecha " + inputDay + "\\" + inputMonth + "\\" + inputYear + " es valida");
			}
		}
	}
}
