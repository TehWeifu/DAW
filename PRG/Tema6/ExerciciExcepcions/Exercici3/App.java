import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Integer[] arr = new Integer[3];

        do {
            int inputNum;
            int inputPos;

            do {
                try {
                    System.out.print("Introduzca un entero: ");
                    inputNum = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error. Has introducidor un valor no valido");
                }
            } while (true);

            do {
                try {
                    System.out.print("Introduzca la posición del array (0-2): ");
                    inputPos = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error. Has introducidor un valor no valido");
                }
            } while (true);

            try {
                arr[inputPos] = inputNum;
                System.out.printf("Se ha introducido arr[%d] = %d%n", inputPos, inputNum);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.printf("La posición %d no existe en el array %n", inputPos);
            }

            System.out.println();
        } while (!isFull(arr));

        System.out.printf("El array es: %s", Arrays.toString(arr));
    }

    private static boolean isFull(final Integer[] arr) {
        for (Integer i : arr) {
            if (i == null) return false;
        }
        return true;
    }
}
