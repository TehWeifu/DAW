import java.util.Scanner;

public class Exercici5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Introduzca un numero entero: ");
		double inputNum = input.nextInt();
		
		if (inputNum > 0) {
			System.out.println("El numero es positivo");
		} else if (inputNum < 0) {
			System.out.println("El numero es negativo");
		} else {
			System.out.println("El numero es cero");
		}
	}
}
