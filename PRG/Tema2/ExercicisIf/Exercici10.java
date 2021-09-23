import java.util.Scanner;

public class Exercici10 {
	public static void main(String[] args) {
		// declares variables
		Scanner input = new Scanner(System.in);
		int inputNum1;
		int inputNum2;
		int inputNum3;
		
		// ask for inputs to the user
		System.out.print("Introduzca el primer entero: ");
		inputNum1 = input.nextInt();
		System.out.print("Introduzca el segundo entero: ");
		inputNum2 = input.nextInt();
		System.out.print("Introduzca el tercer entero: ");
		inputNum3 = input.nextInt();
		
		// Shows output
		// First displays the result line, same for every case
		System.out.print("Los numeros en orden descendente son: ");
		
		// First checks for a number to be the biggest 
		// and displays it on the same line
		// then checks which one of the other two is the second biggest
		// and displays that one first and the smallest one last
		if (inputNum1 >= inputNum2 && inputNum1 >= inputNum3) {
			System.out.print(inputNum1 + " ");
			if (inputNum2 >= inputNum3) {
				System.out.println(inputNum2 + " " + inputNum3);
			} else {
				System.out.println(inputNum3 + " " + inputNum2);
			}
		} else {
			if (inputNum2 >= inputNum1 && inputNum2 >= inputNum3) {
				System.out.print(inputNum2 + " ");
				if (inputNum1 >= inputNum3) {
					System.out.println(inputNum1 + " " + inputNum3);
				} else {
					System.out.println(inputNum3 + " " + inputNum1);
				}
			} else {
				System.out.print(inputNum3 + " ");
				if (inputNum1 >= inputNum2) {
					System.out.println(inputNum1 + " " + inputNum2);
				} else {
					System.out.println(inputNum2 + " " + inputNum1);
				}
			}
		}
	}
}
