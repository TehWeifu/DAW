import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        double inputAngle;
        do {
            System.out.print("Introduzca los grados del angulo: ");
            try {
                inputAngle = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error se ha introducido un valor no valido");
            }
        } while (true);

        final Tangente myTangente = new Tangente(inputAngle);
        try {
            System.out.printf("La tangente de un angulo de %.2f grados es %.2f%n", inputAngle, myTangente.resul());
        } catch (MiError e) {
            e.R();
        }
    }
}
