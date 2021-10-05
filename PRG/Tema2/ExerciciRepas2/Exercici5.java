//

import java.util.Scanner;

public class Exercici5 {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	byte day;
	byte hour;
	
	do {
		System.out.print("Introduisca un dia de la setmanan (1-7): ");
		day = input.nextByte();
	} while (day < 1 || day > 7);
	
	do {
		System.out.print("Introduisca una hora del dia (0-24): ");
		day = input.nextByte();
	} while (hour < 0 || hour > 24);
	
	}	
}
