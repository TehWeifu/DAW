//        1. Realitza un programa que demane per pantalla tres puntuacions d'un alumne i calcule la mitjana.
//            • Si la mitjana de l'alumne no supera els 4 punts l'alumne està suspens i l'algorisme haurà d'imprimir un missatge indicant-lo.
//            • En cas que l'alumne tinga una mitjana superior o igual a 4 punts però inferior a 5, l'alumne estarà aprovat però dubtós.
//            • Si l'alumne supera els 5 punts el missatge a imprimir serà Aprovat.
//        Nota: resol amb l'estructura switch.

import java.util.Scanner;

public class Exercici1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final byte numOfGrades = 3;
        float sum = 0;
        float tmpNum;

        for (int i = 1; i <= numOfGrades; i++) {
            do {
                System.out.print("Introduïsca la " + i + " nota (0 - 10): ");
                tmpNum = input.nextFloat();
            } while (tmpNum < 0.0 || tmpNum > 10.0);
            sum += tmpNum;
        }

        System.out.print("L'alumne esta ");
        switch ((int) (sum / numOfGrades)) {
            case 0:
            case 1:
            case 2:
            case 3:
                System.out.print("suspès");
                break;
            case 4:
                System.out.print("aprovat pero dubtós");
                break;

            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                System.out.print("aprovat");
                break;

        }
        System.out.println();
    }
}
