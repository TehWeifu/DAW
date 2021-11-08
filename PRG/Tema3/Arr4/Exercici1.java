import java.security.SecureRandom;
import java.util.Arrays;

public class Exercici1 {
    public static final SecureRandom numGen = new SecureRandom();

    // Method that fills an array with numbers between the inferior limit (included) and superior limit (excluded)
    public static void fillRnd(int[] arr, int infBound, int supBound) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (infBound + numGen.nextInt(supBound - infBound));
        }
    }

    // Overloaded method to fill the array with numbers between 0 and 100, both included
    public static void fillRnd(int[] arr) {
        fillRnd(arr, 0, 101);
    }


    public static void main(String[] args) {
        
        // Declares and initializes an array with random length between 5 and 20 and fill it with random numbers
        int[] arr = new int[5 + numGen.nextInt(16)];
        fillRnd(arr);
        

        // Declares an array with the same length as the original array
        // Then loops over the array assigning the opposite values
        int[] inverseArr = new int[arr.length];

        for (int i = 0; i < inverseArr.length; i++) {
            inverseArr[i] = arr[arr.length - 1 - i];
        }
        

        // Prints the original array and the reversed array by using the toString method
        System.out.println("El array original es");
        System.out.println(Arrays.toString(arr));
        System.out.println();

        System.out.println("El array invertit es");
        System.out.println(Arrays.toString(inverseArr));
        System.out.println();
    }
}

