import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        int menuOption;
        do {
            menuOption = mainMenu();
            switch (menuOption) {
                case 1:
                    ageWeeks();
                    break;
                case 2:
                    seasonYear();
                    break;
                case 3:
                    countSundays();
                    break;
            }
            System.out.println();
        } while (menuOption != 4);
    }

    private static int mainMenu() {
        System.out.println("╔════════════════ MENU ════════════════╗");
        System.out.println("║ 1. Mostrar fecha en semanas          ║");
        System.out.println("║ 2. Mostrar estación de fecha         ║");
        System.out.println("║ 3. Domingos entre dos fechas         ║");
        System.out.println("║ 4. Salir                             ║");
        System.out.println("╚══════════════════════════════════════╝");

        return promptInt("Introduzca una opción: ", 1, 4);
    }

    private static void ageWeeks() {
        LocalDate myDate;
        try {
            myDate = promptDate(true);
        } catch (DateTimeException e) {
            System.out.println("Error. " + e.getMessage());
            return;
        }

        LocalDate dateNow = LocalDate.now();

        long numOfWeeks = ChronoUnit.WEEKS.between(myDate, dateNow);
        System.out.printf("Tienes %d semanas de edad%n", numOfWeeks);
    }

    private static void seasonYear() {
        LocalDate myDate;

        try {
            myDate = promptDate(false);
        } catch (DateTimeException e) {
            System.out.println("Error. " + e.getMessage());
            return;
        }

        String season = "";
        switch (myDate.getMonth()) {
            case JANUARY:
            case FEBRUARY:
                season = "Invierno";
                break;
            case MARCH:
                season = myDate.getDayOfMonth() < 21 ? "Invierno" : "Primavera";
                break;
            case APRIL:
            case MAY:
                season = "Primavera";
                break;
            case JUNE:
                season = myDate.getDayOfMonth() < 21 ? "Primavera" : "Verano";
                break;
            case JULY:
            case AUGUST:
                season = "Verano";
                break;
            case SEPTEMBER:
                season = myDate.getDayOfMonth() < 21 ? "Verano" : "Otoño";
                break;
            case OCTOBER:
            case NOVEMBER:
                season = "Otoño";
                break;
            case DECEMBER:
                season = myDate.getDayOfMonth() < 21 ? "Otoño" : "Invierno";
                break;
        }
        System.out.printf("La fecha %d/%d esta en %s%n", myDate.getDayOfMonth(), myDate.getMonthValue(), season);
    }

    private static void countSundays() {
        System.out.println("Primera fecha");
        LocalDate startDate;
        try {
            startDate = promptDate(true);
        } catch (DateTimeException e) {
            System.out.println("Error. " + e.getMessage());
            return;
        }

        System.out.println("Segunda fecha");
        LocalDate endDate;
        try {
            endDate = promptDate(true);
        } catch (DateTimeException e) {
            System.out.println("Error. " + e.getMessage());
            return;
        }

        if (startDate != null && endDate != null) {

            // if startDate is after endDate swaps them to avoid infine loop
            if (Period.between(startDate, endDate).isNegative()) {
                LocalDate[] tmpArr = new LocalDate[]{startDate, endDate};
                startDate = tmpArr[1];
                endDate = tmpArr[0];
            }

            LocalDate iterDate;
            int sundayCount = 0;
            for (iterDate = LocalDate.from(startDate);
                 !iterDate.isEqual(endDate);
                 iterDate = iterDate.plusDays(1)) {
                if (iterDate.get(ChronoField.DAY_OF_WEEK) == 7) sundayCount++;
            }
            System.out.printf("Han pasado %d domingos entre %s y %s%n", sundayCount, startDate, endDate);
        }
    }

    private static int promptInt(final String message, final int minVal, final int maxVal) {
        Scanner scanner = new Scanner(System.in);

        int inputVal = Integer.MIN_VALUE;
        boolean isValid;

        do {
            isValid = true;

            System.out.print(message);
            try {
                inputVal = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                isValid = false;
            }

            if (isValid && inputVal < minVal || inputVal > maxVal) isValid = false;
            if (!isValid) System.out.println("Error se ha introducido un valor no valido");

        } while (!isValid);
        return inputVal;
    }

    private static int promptInt(final String message) {
        return promptInt(message, Integer.MIN_VALUE + 1, Integer.MAX_VALUE);
    }

    private static LocalDate promptDate(boolean needYear) throws DateTimeException {
        final int inputDay = promptInt("Introduzca el dia: ", 1, 31);
        final int inputMonth = promptInt("Introduzca el mes: ", 1, 12);
        int inputYear = needYear ? promptInt("Introduzca el año: ") : 0;

        LocalDate myDate;

        try {
            myDate = LocalDate.of(inputYear, inputMonth, inputDay);
        } catch (DateTimeException e) {
            throw new DateTimeException("Fecha no valida", e);
        }

        return myDate;
    }
}
