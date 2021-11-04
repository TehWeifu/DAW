import java.security.SecureRandom;
import java.util.Arrays;

public class Exercici1 {
    public static final SecureRandom numGen = new SecureRandom();

    public static void fillRnd(int[] arr, int infBound, int supBound) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (infBound + numGen.nextInt(supBound - infBound));
        }
    }

    public static void fillRnd(int[] arr) {
        fillRnd(arr, 0, 101);
    }


    public static void main(String[] args) {
        int[] arr = new int[5 + numGen.nextInt(16)];
        fillRnd(arr);

        int[] inverseArr = new int[arr.length];

        for (int i = 0; i < inverseArr.length; i++) {
            inverseArr[i] = arr[arr.length - 1 - i];
        }

        System.out.println("El array original es");
        System.out.println(Arrays.toString(arr));
        System.out.println();

        System.out.println("El array invertit es");
        System.out.println(Arrays.toString(inverseArr));
        System.out.println();
    }
}

