// 4. Elaborar un programa que convertisca un nombre enter positiu, menor a 257 a sistema binari.

import java.util.Scanner;

public class TestJava {
    public static void main(String[] args) {
        // variable declaration
        Scanner input = new Scanner(System.in);
        byte inputNum;
        byte tmpNum;
        long resBinary = 0;
        byte position = 0;

        // prompts the user for a number
        do {
            System.out.print("Introduïsca un numero sencer entre 0 i 257: ");
            inputNum = input.nextByte();
        } while (inputNum < 0);

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