import java.security.SecureRandom;

public class Exercici2 {

    // Method that adds 2 arrays and returns the resulting array
    public static int[][] addArrays(final int[][] arr1, final int[][] arr2) {
        // TODO: Check for same length on both arrays. Throw error if not
        int[][] resArr = new int[3][3];

        // Loops over the resulting array, adding the numbers in the same positions on both input arrays
        for (int i = 0; i < resArr.length; i++) {
            for (int j = 0; j < resArr[i].length; j++) {
                resArr[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return resArr;
    }

    // Method that fills an array with random numbers up to the bound
    // Returns an array with same dimensions as the original array
    public static int[][] initializeRandomArr(final int[][] arr, final int bound) {
        final SecureRandom numGen = new SecureRandom();
        final int[][] res = new int[arr.length][];

        for (int i = 0; i < res.length; i++) {
            res[i] = new int[arr[i].length];
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = numGen.nextInt(bound);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        
        // Declares and initializes with random values the 2 arrays to be added
        int[][] arr1 = new int[3][3];
        arr1 = initializeRandomArr(arr1, 10);
        int[][] arr2 = new int[3][3];
        arr2 = initializeRandomArr(arr2, 10);

        // Declares and initializes the resulting array with the sum of both arrays
        final var resArr = addArrays(arr1, arr2);

        // Outputs the 2 original arrays side by side
        System.out.println("La suma de estas dos arrays");
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.print(arr1[i][j] + "\t");
            }

            System.out.print("\t\t");

            for (int j = 0; j < arr2[i].length; j++) {
                System.out.print(arr2[i][j] + "\t");
            }
            System.out.println();
        }
        
        // Ouputs the resulting array
        System.out.println();
        System.out.println("Es igual a este array");
        for (int[] row : resArr) {
            for (int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
}

