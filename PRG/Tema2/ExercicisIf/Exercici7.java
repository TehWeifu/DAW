import java.util.Scanner;

public class Exercici7 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int inputNum1;
		int inputNum2;
		
		System.out.print("Introduzca un numero entero: ");
		inputNum1 = input.nextInt();
		System.out.print("Introduzca otro numero entero: ");
		inputNum2 = input.nextInt();
		
		if (inputNum1 > inputNum2) {
			System.out.println("El numero " + inputNum1 + " es mayor que " + inputNum2);
		} else {
			System.out.println("El numero " + inputNum2 + " es mayor que " + inputNum1);			
		}
	}
}
