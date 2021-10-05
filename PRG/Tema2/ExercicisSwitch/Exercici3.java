// Exercici 3. L'algoritme per a calcular la lletra del NIF és el següent:
// 1. Calcula el resto de dividir el número de DNI per 23
// 2. La lletra del NIF corresponent amb la següent taula:
// 	Si el resto és:	La lletra és:
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
// Crea un programa que donat un NIF et torne la lletra segons l'algoritme anterior.
// Utilitza una sentència switch.

import java.util.Scanner;

public class ExerciseXXX {
    public static void main(String[] args) {
        // variable declaration
        Scanner input = new Scanner(System.in);
        long dniNum;

        // prompts user asking for an ID number and checks if it is valid
        do {
            System.out.print("Introduïsca el numero del DNI: ");
            dniNum = input.nextLong();
        } while (dniNum < 0 || dniNum > 99_999_999);

        // Outputs the corresponding letter by doing the mod operation and 
        // doing a switch en the result
        System.out.printf("Al numero de DNI %08d li correspon la lletra ", dniNum);
        switch ((byte) (dniNum % 23)) {
            case 0 -> System.out.println('T');
            case 1 -> System.out.println('R');
            case 2 -> System.out.println('W');
            case 3 -> System.out.println('A');
            case 4 -> System.out.println('G');
            case 5 -> System.out.println('M');
            case 6 -> System.out.println('Y');
            case 7 -> System.out.println('F');
            case 8 -> System.out.println('P');
            case 9 -> System.out.println('D');
            case 10 -> System.out.println('X');
            case 11 -> System.out.println('B');
            case 12 -> System.out.println('N');
            case 13 -> System.out.println('J');
            case 14 -> System.out.println('Z');
            case 15 -> System.out.println('S');
            case 16 -> System.out.println('Q');
            case 17 -> System.out.println('V');
            case 18 -> System.out.println('H');
            case 19 -> System.out.println('L');
            case 20 -> System.out.println('C');
            case 21 -> System.out.println('K');
            case 22 -> System.out.println('E');
        }
    }
}
