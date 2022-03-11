import java.util.Scanner;

public class App {
    public static int promptAmountOfGrade() {
        final Scanner scanner = new Scanner(System.in);

        int amountOfGrades;
        System.out.print("Introduzca el numero de notas que desea introducir: ");
        try {
            amountOfGrades = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("No se ha introducido un numero valido");
        }

        if (amountOfGrades < 1) {
            throw new IllegalArgumentException("Se debe introducir al menos 1 nota");
        }

        return amountOfGrades;
    }

    public static double promptGrade(final int index) {
        final Scanner scanner = new Scanner(System.in);
        double tmpGrade;
        System.out.printf("Introduzca la %d nota (0-10): ", index);
        try {
            tmpGrade = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("La nota introducida no es un numero");
        }

        if (tmpGrade < 0.0 || tmpGrade > 10.0) {
            throw new notaMalException("La nota introducida no esta entre 0 y 10");
        }

        return tmpGrade;
    }

    public static void main(String[] args) {
        int inputAmountOfGrades;
        do {
            try {
                inputAmountOfGrades = promptAmountOfGrade();
                break;
            } catch (RuntimeException e) {
                System.out.println("Error. " + e.getMessage());
            }
        } while (true);

        double sum = 0.0;
        for (int i = 0; i < inputAmountOfGrades; ) {
            try {
                sum += promptGrade(i + 1);
                i++;
            } catch (RuntimeException e) {
                System.out.println("Error. " + e.getMessage());
            }
        }

        System.out.printf("La media de las notas introducidas es %.2f%n", sum / inputAmountOfGrades);
    }
}
