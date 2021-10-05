// Exercici1. Donada la següent seqüencia de sentencies if-else transforma-les
// a una seqüencia equivalent utilitzant una única sentència switch:
// if (opcion==’u’)
//	x=x+1;
// else
// 	if (opcion==’d’)
//		x=x+2;
// 	else
// 		if (opcion==’t’)
// 			x=x+3;
// 		else
// 			x=x+4;

import java.util.Scanner;

public class Exercici1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char option;
        int x;

        System.out.print("Introduïsca una lletra: ");
        option = input.next().charAt(0);
        System.out.print("Introduïsca un valor inicial: ");
        x = input.nextInt();

        switch (option) {
            case 'u':
                x--;
            case 'd':
                x--;
            case 't':
                x--;
            default:
                x += 4;
                break;
        }

        System.out.println("El valor de la variable \"x\" després del switch es " + x);
    }
}
