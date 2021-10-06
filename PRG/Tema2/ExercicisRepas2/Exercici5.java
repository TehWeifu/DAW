//		5. Un restaurant que només treballa divendres, dissabtes i diumenges serveix el següent menú de menjars depenent del dia i hora de la setmana, segons
//		la següent taula:
//			Dia i Hora 						Menjar
//			Divendres abans de 16 h 		Pollastre
//			Divendres després de 16 h 		Amanida
//			Dissabte abans de 12 h 			Carn
//			Dissabte Entre 12 i 20 h 		Minutes
//			Dissabte després de 20 h 		Copetin
//			Diumenge tot el dia 			Pasta
//		Es desitja implementar un programa en Java que, donats un dia i una hora, emeta un missatge indicant quin és el menú que correspon servir.
//		El dia de la setmana serà representat mitjançant un valor sencer (entre 1 i 7).
//		L'hora serà representada mitjançant un valor real (entre 0 i 24).
//		En cas que el dia de la setmana no corresponga a cap dels presentats en la taula, s'ha d'emetre un missatge que diga "Gràcies, torne un altre dia".

import java.util.Scanner;

public class TestJava {
	public static void main(String[] args) {
		// variable delcaration
		Scanner input = new Scanner(System.in);
		byte day;
		byte hour;

		// prompts user asking for a day and checking if it is in the valid range
		do {
			System.out.print("Introduïsca un dia de la setmana (1-7): ");
			day = input.nextByte();
		} while (day < 1 || day > 7);

		// prompts user asking for an hour and checking if it is in the valid range
		do {
			System.out.print("Introduïsca una hora del dia (0-24): ");
			hour = input.nextByte();
		} while (hour < 0 || hour > 24);

		// compares the day and then the hour to output the meal
		if (day == 7) {
			System.out.println("Es servira Pasta");
		} else if (day == 6) {
			if (hour < 12) {
				System.out.println("Es servira Carn");
			} else if (hour < 20) {
				System.out.println("Es servira Minutes");
			} else {
				System.out.println("Es servira Copetin");
			}
		} else if (day == 5){
			if (hour < 16) {
				System.out.println("Es servira Pollastre");
			} else {
				System.out.println("Es servira Amanida");
			}
		} else {
			System.out.println("Gracies, torne un altre dia");
		}
	}
}
