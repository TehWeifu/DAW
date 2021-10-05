//        4. Realitza un programa que demane nombres enters, fins que l'usuari indique que no es vol ingressar més números.
//        Indicar la quantitat de parells i la quantitat d'imparells.

import java.util.Scanner;

public class ExerciseXXX {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long parells = 0;
        long imparells = 0;
        long inputNum;

        System.out.print("Introduïsca un numero sencer o pulse la tecla \"e\" per a terminar: ");
        while (input.hasNextLong()) {
            inputNum = input.nextLong();

            if (inputNum % 2 == 0) parells++;
            else imparells++;

            System.out.print("Introduïsca un numero sencer o pulse la tecla \"e\" per a terminar: ");
        }

        System.out.println("Has introduït un total de " + parells + " números parells i un total de " + imparells + " números imparells");
    }
}
