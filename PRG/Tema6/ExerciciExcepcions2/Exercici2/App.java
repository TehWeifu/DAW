import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca el nombre: ");
        final String inputName = scanner.nextLine();

        int inputAge = 0;
        boolean valid;
        do {
            valid = true;
            try {
                System.out.print("Introduzca la edad: ");
                inputAge = Integer.parseInt(scanner.nextLine());
                if (inputAge < 0) valid = false;
            } catch (NumberFormatException e) {
                valid = false;
            }
            if (!valid) System.out.println("Error. Se ha introducido un valor no valido");
        } while (!valid);

        System.out.printf("Usuario %s de Categoría %s, en una década tendrá %d años.%n",
                inputName,
                ((char) ('A' + (inputAge - 1) / 25)),
                inputAge + 10
        );
    }
}