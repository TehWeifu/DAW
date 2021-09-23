import java.util.Scanner;

public class Excercici15 {
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

		if (inputDay < 1 || inputDay > 30 || inputMonth < 1 || inputMonth > 12) {
			System.out.println("La fecha " + inputDay + "\\" + inputMonth + "\\" + inputYear + " no es correcta");
		} else {
			System.out.println("La fecha " + inputDay + "\\" + inputMonth + "\\" + inputYear + " es valida");
		}
	}
}
