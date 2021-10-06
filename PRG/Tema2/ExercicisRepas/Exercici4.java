// 4. Elaborar un programa que convertisca un nombre enter positiu, menor a 257 a sistema binari.

import java.util.Scanner;

public class Exercici4 {
    public static void main(String[] args) {
        // variable declaration
        Scanner input = new Scanner(System.in);
        short inputNum;
        short tmpNum;
        long resBinary = 0;
        byte position = 0;

        // prompts the user asking for a number
        do {
            System.out.print("Introduïsca un numero sencer entre 0 i 257: ");
            inputNum = input.nextShort();
        } while (inputNum < 0 || inputNum > 257);

        // transform the decimal number to binary number by doing the mod 2 operation and adding the result
        // in front of the number
        tmpNum = inputNum;
        while (tmpNum > 0) {
            resBinary = ((tmpNum % 2) * (int)Math.pow(10, position)) + resBinary;

            tmpNum /= 2;
            position++;
        }

        // outputs the result
        System.out.println("El numero " + inputNum + " en binari es " + resBinary);
    }
}
