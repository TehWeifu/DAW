import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
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

        String strFullDate = addWorkingDays(myDate, 30).format(DateTimeFormatter.ofPattern("EEEE, d 'de' MMMM 'de' yyyy", new Locale("ca")));

        System.out.printf("En 30 días laborables será: %s%n", strFullDate);
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

    private static LocalDate addWorkingDays(final LocalDate date, final int days) {
        final int SATURDAY = 6;
        final int SUNDAY = 7;

        LocalDate tmpDate = LocalDate.from(date);

        for (int i = 0; i < days; i++) {
            do {
                tmpDate = tmpDate.plusDays(1);
            } while ((tmpDate.get(ChronoField.DAY_OF_WEEK) == SATURDAY || tmpDate.get(ChronoField.DAY_OF_WEEK) == SUNDAY));
        }

        return tmpDate;
    }
}
