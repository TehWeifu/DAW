import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final double[] grades = new double[10];

        System.out.print("Introduzca el nombre: ");
        final String inputName = scanner.nextLine();

        promptGrades(inputName, grades);

        System.out.printf("%nLa nota media de %s es %.2f%n", inputName, averageGrades(grades));
    }

    public static void promptGrades(final String name, final double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println();
            do {
                try {
                    System.out.printf("Introduzca la %d nota de %s: ", i + 1, name);
                    arr[i] = Double.parseDouble(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error. Has introducido un valor no valido");
                }
            } while (true);
        }
    }

    private static double averageGrades(final double[] arr) {
        double total = 0.0;
        for (double num : arr) {
            total += num;
        }
        return total / arr.length;
    }
}