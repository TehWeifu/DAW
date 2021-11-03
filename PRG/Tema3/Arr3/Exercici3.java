import java.security.SecureRandom;
import java.util.Arrays;

public class TestJava {
    public static final SecureRandom numGen = new SecureRandom();

    // Method that fills an arr with random number,
    // between an inferior bound (inclusive) and a superior bound (exclusive)
    public static void randomFill(int[] arr, int infBound, int supBound) {
        int numDiff = supBound - infBound;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = infBound + numGen.nextInt(numDiff);
        }
    }

    public static void main(String[] args) {
        final int SIZE = 100;

        // Initializes an array with the constant "SIZE" value, fills it with random number and sorts it
        int[] arr = new int[SIZE];
        randomFill(arr, 1, 51);
        Arrays.sort(arr);

        // Prints the array after initialization
        System.out.println("El Array ordenat es");
        System.out.println(Arrays.toString(arr));
        System.out.println();

        // Prints numbers not included in the array, by searching for them in the array
        System.out.println("Numeros del 1 al 50 que no estan en el Array");
        for (int i = 1; i <= 50; i++) {
            if (Arrays.binarySearch(arr, i) < 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}

