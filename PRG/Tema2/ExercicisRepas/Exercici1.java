// 1. Escriu un programa que donat un número de l'1 al 10 el retorne en anglés.

import java.util.Scanner;

public class Exercici1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte inputNum;

        do {
            System.out.print("Introduïsca un numero entre 1 y 10: ");
            inputNum = input.nextByte();
        } while (inputNum < 1 || inputNum > 10);

        System.out.print("El numero " + inputNum + " en anglés és ");
        switch (inputNum) {
            case 1 -> System.out.println("one");
            case 2 -> System.out.println("two");
            case 3 -> System.out.println("three");
            case 4 -> System.out.println("four");
            case 5 -> System.out.println("five");
            case 6 -> System.out.println("six");
            case 7 -> System.out.println("seven");
            case 8 -> System.out.println("eight");
            case 9 -> System.out.println("nine");
            case 10 -> System.out.println("ten");
        }
    }
}