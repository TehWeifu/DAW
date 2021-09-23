import java.util.Scanner;

public class Exercici6 {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int inputNum1;
        int inputNum2;

        System.out.print("Introduzca un numero enterto: ");
        inputNum1 = input.nextInt();
        System.out.print("Introduzca otro numero enterto: ");
        inputNum2 = input.nextInt();

        if (inputNum1 % inputNum2 == 0) {
            if (inputNum2 % inputNum1 == 0) {
                System.out.println("Son el mismo numero");
            } else {
                System.out.println("El numero " + inputNum1 + " es multiplo de " + inputNum2);
            }
        } else {
            if (inputNum2 % inputNum1 == 0) {
                System.out.println("El numero " + inputNum2 + " es multiplo de " + inputNum1);
            } else {
                System.out.println("Los números no son multiplos entre si");
            }
        }
	}
}
