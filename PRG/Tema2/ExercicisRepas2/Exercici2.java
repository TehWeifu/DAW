// 2. Realitza un programa que demane per pantalla 5 números i calcule el major i el menor d'ells.

import java.util.Scanner;

public class Exercici2 {
    public static void main(String[] args) {
        final byte NUMS_TO_INPUT = 5;
        Scanner input = new Scanner(System.in);

        double maxNum = Double.MIN_VALUE;
        double minNum = Integer.MAX_VALUE;

        for (int i = 1; i <= NUMS_TO_INPUT; i++) {

            System.out.print("Introduïsca el " + i + " numero: ");
            double tmpNum = input.nextDouble();

            maxNum = Math.max(maxNum, tmpNum);
            minNum = Math.min(minNum, tmpNum);
        }

        System.out.println("El numero major es " + maxNum);
        System.out.println("El numero menor es " + minNum);
    }
}
