// 5. Deixa indroduir els valors dels costats d'un triangle. Detecta i mostra un missatge
//    corresponent al seu tipus (EQUILÀTER, ISÒSCELES, O ESCALÉ)

import java.util.Scanner;

public class TestJava {
    public static void main(String[] args) {
    	// variable declaration
        Scanner input = new Scanner(System.in);
        double side1;
        double side2;
        double side3;

	// Prompts user asking for 3 sides and recives the input
        System.out.print("Introduïsca el primer costat: ");
        side1 = input.nextDouble();
        System.out.print("Introduïsca el segon costat: ");
        side2 = input.nextDouble();
        System.out.print("Introduïsca el primer costat: ");
        side3 = input.nextDouble();

	// Compares each side to determine the type of the triangle and outputs it
        System.out.print("El triangle amb costats " + side1 + ", " + side2 + " i " + side3 + " es ");
        if (side1 == side2 && side1 == side3) {
            System.out.println("equilàter");
        } else if (side1 == side2 || side1 == side3 || side2 == side3) {
            System.out.println("Isosceles");
        } else {
            System.out.println("Escale");
        }
    }
}
