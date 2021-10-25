import java.util.Scanner;

public class Exercici3 {
    // Method that returns the bigger absolute number
    public static double absMax(double num1, double num2) {
        double abs1 = (num1 > 0 ? num1 : -num1);
        double abs2 = (num2 > 0 ? num2 : -num2);

        return (abs1 > abs2 ? num1 : num2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompts user to input two real numbers
        System.out.print("Introduïsca un numero real: ");
        double inputNum1 = sc.nextDouble();
        System.out.print("Introduïsca un altre numero real: ");
        double inputNum2 = sc.nextDouble();

        System.out.print("El numero de major valor absolut es " + absMax(inputNum1, inputNum2));
    }
}

