import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2 {
    // Class declaration for Scanner object
    public static final Scanner sc = new Scanner(System.in);

    // Method that fills an array with user input values and returns a new array with same length
    public static int[] llenar(final int[] arr, final int length) {

        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.print("Introduce el valor en la " + (i + 1) + " posicion: ");
            res[i] = sc.nextInt();
        }

        return res;
    }

    // Method that prints on screen the contents of an array
    // Loops through the arary and prints every element followed by a space
    public static void mostrar(final int[] arr, final int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Method that sorts an array
    // Creates a copy of the original array, sorts it using method Arrays.sort sort and returns it
    public static int[] ordenar(final int[] arr) {
        int[] res;
        res = Arrays.copyOf(arr, arr.length);

        Arrays.sort(res);
        return res;
    }

    // Method that recives two arrays and adds each position in a new array 
    // Then prints the contents on the new array by calling method "mostrar"
    public static void sumar(final int[] arr1, final int[] arr2) {
        int[] arrSum = new int[arr1.length];

        for (int i = 0; i < arrSum.length; i++) {
            arrSum[i] = arr1[i] + arr2[i];
        }

        System.out.println("La suma de los arrays posición a posición es");
        mostrar(arrSum, arrSum.length);
        System.out.println();
    }

    public static void main(String[] args) {

        // Prompts user to input a length for the arrays, validates the length
        // Creates both arrays with the input Value
        int inputLength;
        do {
            System.out.print("Introduce la longitud de los arrays: ");
            inputLength = sc.nextInt();
        } while (inputLength < 1);

        int[] arr1 = new int[inputLength];
        int[] arr2 = new int[inputLength];


        // Fills both arrays by calling method "llenar" and stores the result on the same variable
        System.out.println();
        System.out.println("Introduciendo los valores del primer array");
        arr1 = llenar(arr1, arr1.length);

        System.out.println();
        System.out.println("Introduciendo los valores del segundo array");
        arr2 = llenar(arr2, arr2.length);


        // Sorts both arrays by calling method "ordenar" and stores the result in the same variable
        arr1 = ordenar(arr1);
        arr2 = ordenar(arr2);


        // Prints the content of both arrays, calling method "mostrar"
        System.out.println();
        System.out.println("El primer array con los valores ordenados es");
        mostrar(arr1, arr1.length);
        System.out.println();

        System.out.println();
        System.out.println("El segundo array con los valores ordenados es");
        mostrar(arr2, arr2.length);
        System.out.println();


        // Calls method "sumar" to add the values of both strings and print their result
        System.out.println();
        sumar(arr1, arr2);
    }
}

