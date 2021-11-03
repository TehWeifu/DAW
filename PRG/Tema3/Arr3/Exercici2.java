import java.security.SecureRandom;
import java.util.Arrays;

public class Exercici2 {
    public static final SecureRandom numGen = new SecureRandom();

    // Method that returns a random number between 5 and 20 (both inclusive)
    public static int getRandSize() {
        return (5 + numGen.nextInt(16));
    }

    // Method that fills an array with random numbers, between 0 and bound (exclusive)
    public static void randomFill(int[] arr, int bound) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = numGen.nextInt(bound);
        }
    }

    // Method that combines two arrays into one and returns it
    public static int[] combine(int[] arr1, int[] arr2) {
        final int[] res = new int[arr1.length + arr2.length];

        int tmpPos = 0;

        for (int num : arr1) {
            res[tmpPos] = num;
            tmpPos++;
        }

        for (int num : arr2) {
            res[tmpPos] = num;
            tmpPos++;
        }
        return res;
    }
    
    public static void main(String[] args) {
        // Declaration and initialization of both starting arrays, with random sizes and random values
        int[] arr1;
        int[] arr2;

        arr1 = new int[getRandSize()];
        arr2 = new int[getRandSize()];

        randomFill(arr1, 100);
        randomFill(arr2, 100);

        // Combines and sorts both arrays into a resulting one
        int[] combineArrays = combine(arr1, arr2);
        Arrays.sort(combineArrays);

        // Prints both starting arrays and resulting arrays
        System.out.println("Els continguts del primer Array es");
        System.out.println(Arrays.toString(arr1));
        System.out.println();

        System.out.println("Els continguts del segon Array es");
        System.out.println(Arrays.toString(arr2));
        System.out.println();

        System.out.println("Els continguts de les deus Arrays combinades i ordenades es");
        System.out.println(Arrays.toString(combineArrays));
    }
}

