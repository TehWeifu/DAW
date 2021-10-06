//2. Escriure un programa que demane una contrasenya, de tipus sencer i permeta tres
//   intents. Si l'usuari dóna la contrasenya correcta respon "Enhorabona!", si
//   no, el programa respondrà per als dos intents més “Intenta de nou”. En
//   cas contrari el programa escriu "El sent, contrasenya equivocada" i es tanca immediatament.

import java.util.Scanner;

public class TestJava {
    public static void main(String[] args) {
        // variable declaration
        Scanner input = new Scanner(System.in);

        final long PASS = 123456;
        final byte TRIES = 3;

        long inputPass = 0;

        // Prompts user to input a number, indicating if he has failed the previous attempt.
        // recives a number from the user
        for (int i = 0; ((i < TRIES) && (PASS != inputPass)); i++) {
            if (i != 0) System.out.println("Error, contrasenya incorrecta.");
            System.out.print("Introduïsca la contrasenya (Queden " + (TRIES - i) + " intents): ");
            inputPass = input.nextLong();
            System.out.println();
        }

        // outputs the result checking if the pass is correct
        if (PASS == inputPass) {
            System.out.println("Enhorabona!");
        } else {
            System.out.println("El sent, contrasenya equivocada");
        }
    }
}
