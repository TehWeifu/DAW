// 2. Demana dos números i digues si un es múltiple del altre.

import java.util.Scanner;

public class Exercici2 {
    public static void main(String[] args) {
        // variables declaration
        Scanner input = new Scanner(System.in);
        int inputNum1;
        int inputNum2;

        // asking user for two numbers
        System.out.print("Introduïsca un número sencer: ");
        inputNum1 = input.nextInt();
        System.out.print("Introduïsca un altre número sencer: ");
        inputNum2 = input.nextInt();

        // checks whether the numbers are multiples. If checks one, else checks the other
        if (inputNum1 % inputNum2 == 0) {
            if (inputNum2 % inputNum1 == 0) { // if both are multiples of each other it means they are the same number
                System.out.println("Son el mateix número");
            } else {
                System.out.println("El número " + inputNum1 + " és múltiple de " + inputNum2);
            }
        } else {
            if (inputNum2 % inputNum1 == 0) {
                System.out.println("El número " + inputNum2 + " és múltiple de " + inputNum1);
            } else {
                System.out.println("Els números no son múltiples entre si");
            }
        }
    }
}
