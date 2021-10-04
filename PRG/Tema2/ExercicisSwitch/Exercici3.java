// Exercici 3. El algoritme per a calcular la lletra del NIF es el següent:
// 1. Calcula el resto de dividir el número de DNI per 23
// 2. La letra del NIF corresponent amb la següent taula:
// 	Si el resto es:	La letra es:
// 	0			T
// 	1			R
// 	2			W
// 	3			A
// 	4			G
// 	5			M
// 	6			Y
// 	7			F
// 	8			P
// 	9			D
// 	10			X
// 	11			B
// 	12			N
// 	13			J
// 	14			Z
// 	15			S
// 	16			Q
// 	17			V
// 	18			H
// 	19			L
// 	20			C
// 	21			K
// 	22			E
// Crea un programa que donat un NIF et torne la lletra segons el algoritme anterior.
// Utilitza una sentencia switch.

import java.util.Scanner;

public class Exercici3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long dniNum = 0;
		
		do {
			System.out.print("Introduisca el numero del DNI: ");
			dniNum = input.nextLong();
		} while (dniNum < 0 || dniNum > 99_999_999);
		
		System.out.printf("Al numero de DNI %08d li correspon la lletra ", dniNum);
		
		switch ((byte) (dniNum % 23)) {
			case 0:
				System.out.println('T');
				break;
			case 1:
				System.out.println('R');
				break;
			case 2:
				System.out.println('W');
				break;
			case 3:
				System.out.println('A');
				break;
			case 4:
				System.out.println('G');
				break;
			case 5:
				System.out.println('M');
				break;
			case 6:
				System.out.println('Y');
				break;
			case 7:
				System.out.println('F');
				break;
			case 8:
				System.out.println('P');
				break;
			case 9:
				System.out.println('D');
				break;
			case 10:
				System.out.println('X');
				break;
			case 11:
				System.out.println('B');
				break;
			case 12:
				System.out.println('N');
				break;
			case 13:
				System.out.println('J');
				break;
			case 14:
				System.out.println('Z');
				break;
			case 15:
				System.out.println('S');
				break;
			case 16:
				System.out.println('Q');
				break;
			case 17:
				System.out.println('V');
				break;
			case 18:
				System.out.println('H');
				break;
			case 19:
				System.out.println('L');
				break;
			case 20:
				System.out.println('C');
				break;
			case 21:
				System.out.println('K');
				break;
			case 22:
				System.out.println('E');
				break;
			
		}
	}
}

