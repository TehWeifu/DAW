import java.util.Scanner

public class Exercici11 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int inputNum;
		
		System.out.print("Introduzca un numero entre 0 y 9.999: ");
		inputNum = input.nextInt();
		
		if (inputNum > 9_999 || inputNum < 0) {
			System.out.println("El numero introducido no es valido");
		} else {
			System.out.print("El numero " + inputNum + " tiene " + (int) Math.ceil(inputNum);			
		}
	}
}

