import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class App {
    private static final int HOURS_PER_SHIFT = 8;
    private static final int SECONDS_PER_SHIFT = HOURS_PER_SHIFT * 3_600;

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final int inputStartHour = promptInt("Introduzca la hora de entrada (0-23): ", 0, 23);
        final int inputStartMinute = promptInt("Introduzca el minuto de entrada (0-59): ", 0, 59);
        final int inputEndHour = promptInt("Introduzca la hora de salida (0-23): ", 0, 23);
        final int inputEndMinute = promptInt("Introduzca el minuto de salida (0-59): ", 0, 59);

        final LocalTime startTime = LocalTime.of(inputStartHour, inputStartMinute);
        final LocalTime endTime = LocalTime.of(inputEndHour, inputEndMinute);

        final Duration shiftDuration = Duration.between(startTime, endTime);

        if (shiftDuration.isNegative()) {
            System.out.println("A no ser que tengas una maquina del tiempo, no puedes salir de trabajar antes de haber entrado");
        } else {
            final long secondsWorked = shiftDuration.getSeconds();

            final long secondsDifference = secondsWorked - SECONDS_PER_SHIFT;

            if (secondsDifference < 0) {
                int hoursRemaining = -(int) secondsDifference / 3600;
                int minutesRemaining = -(int) secondsDifference % 3600 / 60;

                System.out.printf("Te faltan %d horas y %d minutos para terminar la jornada laboral%n", hoursRemaining, minutesRemaining);
            } else {
                int hoursOverworked = (int) secondsDifference / 3600;
                int minutesOverworked = (int) secondsDifference % 3600 / 60;

                System.out.printf("Has completado tu jornada laboral y te han sobrado %d horas y %d minutos%n", hoursOverworked, minutesOverworked);
            }
        }
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
}
