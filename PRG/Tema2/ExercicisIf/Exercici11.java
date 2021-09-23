import java.util.Scanner;

public class Exercici11 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int inputNum;

		System.out.print("Introduzca un numero entre 0 y 9.999: ");
		inputNum = input.nextInt();

		if (inputNum > 9_999 || inputNum < 0) {
			System.out.println("El numero introducido no es valido");
		} else {
			System.out.print("El numero introducido tiene ");
			if (inputNum / 10 == 0) System.out.println("1 digito");
			else if (inputNum / 100 == 0) System.out.println("2 digitos");
			else if (inputNum / 1000 == 0) System.out.println("3 digitos");
			else System.out.println("4 digitos");
		}

//        if (inputNum > 9999 || inputNum < 0) {
//            System.out.println("El numero introducido no es valido");
//        } else {
//            if (inputNum == 0) {
//                System.out.print("El numero " + inputNum + " tiene 1 digito.");
//            } else {
//                System.out.print("El numero " + inputNum + " tiene " + (int) (Math.log10(inputNum) + 1) + " digito(s).");
//            }
//        }
	}
}
