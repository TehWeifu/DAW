import java.security.SecureRandom;
import java.util.Arrays;

public class Exercici1 {
    // Constant declaration for array size, random number bound and the number generator
    public final static int POS = 50;
    public final static int LIMIT = 100;
    final private static SecureRandom numGen = new SecureRandom();

    // Declaration for the array
    private static int[] lista;

    // Method that returns a random integer between 1 and the bound limit (both inclusive)
    public static int getAleatorio() {
        return (1 + numGen.nextInt(LIMIT));
    }

    // Method that sorts the argument array
    public static void ordena(int[] array) {
        Arrays.sort(array);
    }

    // Method that prints the array "lista" on the screen
    public static void muestra() {
        System.out.println(Arrays.toString(lista));
    }

    public static void main(String[] args) {
        // Initializes "lista" with an empty array with the constant value of "POS"
        lista = new int[POS];

        // Loops over the array, initializing every value with a random number
        for (int i = 0; i < POS; i++) {
            lista[i] = getAleatorio();
        }

        ordena(lista);
        muestra();
    }
}

