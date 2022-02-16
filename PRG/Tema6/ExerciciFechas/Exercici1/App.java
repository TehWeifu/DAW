import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LocalDate myDate;
        do {
            int inputYear = promptInt("Introduzca el año: ");
            int inputMonth = promptInt("Introduzca el mes: ", 1, 12);
            int inputDay = promptInt("Introduzca el dia: ", 1, 31);

            try {
                myDate = LocalDate.of(inputYear, inputMonth, inputDay);
                break;
            } catch (DateTimeException e) {
                System.out.println("Error. Se ha introducido una fecha no valida. Intentalo otra vez");
            }
        } while (true);
        String strFullDate = myDate.plusDays(10).format(DateTimeFormatter.ofPattern("EEEE, d MMMM 'de' y", new Locale("ca")));

        System.out.printf("En 10 días será: %s%n", strFullDate);
    }

    private static int promptInt(final String msg, final int min, final int max) {
        boolean isValid;
        int num = Integer.MIN_VALUE;
        do {
            isValid = true;

            System.out.print(msg);

            try {
                num = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                isValid = false;
            }

            if (num < min || num > max) isValid = false;

            if (!isValid) System.out.println("Error. Se ha introducido un valor no valido");

        } while (!isValid);
        return num;
    }

    private static int promptInt(final String msg) {
        return promptInt(msg, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
