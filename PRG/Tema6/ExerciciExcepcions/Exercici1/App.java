import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        boolean exit = true;
        do {
            try {
                System.out.print("Introduzca un numero: ");
                int num = scanner.nextInt();

                System.out.printf("Has introducido el numero %d%n", num);
                exit = false;
            } catch (InputMismatchException e) {
                System.out.println("Has introducido un valor no válido.");
            }
            scanner.nextLine();
        } while (exit);

    }
}
