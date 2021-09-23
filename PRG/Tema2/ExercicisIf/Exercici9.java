import java.util.Scanner;

public class Exercici9 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int inputNum1;
		int inputNum2;
		
		System.out.print("Introduzca un numero entero: ");
		inputNum1 = input.nextInt();
		System.out.print("Introduzca otro numero entero: ");
		inputNum2 = input.nextInt();
		
		System.out.print("Los numeros en orden descendente son: ");
		
		if (inputNum1 > inputNum2) {
			System.out.println(inputNum1 + " " + inputNum2);
		} else {
			System.out.println(inputNum2 + " " + inputNum1);
		}		
	}
}
