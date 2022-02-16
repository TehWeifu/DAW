import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int inputYear = promptInt("Introduzca el año: ");
        int inputMonth = promptInt("Introduzca el mes: ", 1, 12);
        int inputDay = promptInt("Introduzca el dia: ", 1, 31);

        LocalDate myDate = LocalDate.of(inputYear, inputMonth, inputDay);
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
        int counter = 0;
        LocalDate tmpDate = LocalDate.from(date);

        while (counter < days) {
            tmpDate = tmpDate.plusDays(1);
            if (!(tmpDate.get(ChronoField.DAY_OF_WEEK) == 6 || tmpDate.get(ChronoField.DAY_OF_WEEK) == 7)) {
                counter++;
            }
        }
        return tmpDate;
    }
}
