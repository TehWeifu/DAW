// 7. Demana un número entre 0 i 9.999 i digues quantes xifres té.

import java.util.Scanner;

public class Exercici7 {
	public static void main(String[] args) {
		// variable declaration
		Scanner input = new Scanner(System.in);
		int inputNum;

		// Ask user for an integer
		System.out.print(" un número sencer entre 0 y 9.999: ");
		inputNum = input.nextInt();

		// checks how many digits a number has by dividing it by powers of 10
		if (inputNum > 9_999 || inputNum < 0) {
			System.out.println("El número introduït no es valido");
		} else {
			System.out.print("El número introduït té ");
			if (inputNum / 10 == 0) System.out.println("1 xifra");
			else if (inputNum / 100 == 0) System.out.println("2 xifres");
			else if (inputNum / 1000 == 0) System.out.println("3 xifra");
			else System.out.println("4 xifres");
		}

//        // checks how many a digits has by using Math log10 method
//        if (inputNum > 9999 || inputNum < 0) {
//            System.out.println("El número introduït no es valid");
//        } else {
//            if (inputNum == 0) {
//                System.out.print("El número " + inputNum + " té 1 xifra.");
//            } else {
//                System.out.print("El número " + inputNum + " té " + (int) (Math.log10(inputNum) + 1) + " xifre(s).");
//            }
//        }
	}
}
