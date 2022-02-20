import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca el divisor: ");
        final String inputDivisor = scanner.nextLine();
        System.out.print("Introduzca el dividendo: ");
        final String inputDividend = scanner.nextLine();

        String result = "";
        boolean valid = false;
        try {
            result = myDivide(inputDivisor, inputDividend);
            valid = true;
        } catch (RuntimeException e) {
            System.out.printf("Error. %s%n", e.getMessage());
        }

        if (valid) {
            System.out.printf("El resultado de dividir %s / %s es %s", inputDivisor, inputDividend, result);
        }
    }

    private static String myDivide(final String divisor, final String dividend) {
        int numDivisor;
        int numDividen;

        try {
            numDivisor = Integer.parseInt(divisor);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El divisor no es valido");
        }

        try {
            numDividen = Integer.parseInt(dividend);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El dividendo no es valido");
        }

        if (numDividen == 0) {
            throw new ArithmeticException("El dividendo no puede ser 0");
        }

        return String.valueOf((double) numDivisor / numDividen);
    }
}