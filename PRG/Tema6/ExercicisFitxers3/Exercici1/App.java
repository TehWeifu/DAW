import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Locale;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String FILE_URL = "./temperatures.csv";

    public static void main(String[] args) {
        int menuOption;
        do {
            menuOption = mainMenu();
            switch (menuOption) {
                case 1:
                    addRecords();
                    break;
                case 2:
                    printRecords();
                    break;
            }
            System.out.println();
        } while (menuOption != 3);
    }

    private static int mainMenu() {
        System.out.println();
        System.out.println("╔════════════ MENU ════════════╗");
        System.out.println("║ 1. Registrar  temperaturas   ║");
        System.out.println("║ 2. Mostrar historial         ║");
        System.out.println("║ 3. Salir                     ║");
        System.out.println("╚══════════════════════════════╝");

        int inputOption = 0;
        boolean validInput;
        do {
            validInput = true;

            System.out.print("Introduzca una opción: ");
            try {
                inputOption = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                validInput = false;
            }

            if (inputOption < 1 || inputOption > 3) validInput = false;

            if (!validInput) System.out.println("Error. Se ha introducido una opción no válida");

        } while (!validInput);

        return inputOption;
    }

    private static void addRecords() {
        Formatter myFile;
        try {
            myFile = new Formatter(new FileWriter(FILE_URL, true));
        } catch (IOException e) {
            System.out.println("Error. No se ha podido abrir o crear el archivo");
            return;
        }

        do {
            System.out.print("Introduzca la fecha (-1 para salir): ");
            String inputDate = scanner.nextLine();

            if (inputDate.equals("-1")) break;

            double inputMax;
            do {
                System.out.print("Introduzca la temperatura máxima: ");
                try {
                    inputMax = Double.parseDouble(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error. El valor introducido no es válido");
                }
            } while (true);

            double inputMin;
            do {
                System.out.print("Introduzca la temperatura mínima: ");
                try {
                    inputMin = Double.parseDouble(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error. El valor introducido no es válido");
                }
            } while (true);

            myFile.format(Locale.ENGLISH, "%s,%.2f,%.2f%n", inputDate, inputMax, inputMin);

            System.out.println();
        } while (true);

        myFile.close();
    }

    private static void printRecords() {
        Scanner myFile;
        try {
            myFile = new Scanner(Paths.get(FILE_URL));
        } catch (IOException e) {
            System.out.println("Error. no se ha podido abrir el archivo.");
            return;
        }

        if (myFile.hasNextLine()) {
            double maximHigh = Double.MIN_VALUE;
            double minLow = Double.MAX_VALUE;
            System.out.printf("%-20s%-25s%s%n", "Fecha", "Temperatura Maxima", "Temperatura minima");
            while (myFile.hasNextLine()) {
                String[] tmpArr = myFile.nextLine().split(",");
                System.out.printf("%-20s%-25s%s%n", tmpArr[0], tmpArr[1] + "ºC", tmpArr[2] + "ºC");

                if (Double.parseDouble(tmpArr[1]) > maximHigh) maximHigh = Double.parseDouble(tmpArr[1]);
                if (Double.parseDouble(tmpArr[2]) < minLow) minLow = Double.parseDouble(tmpArr[2]);
            }

            System.out.println();
            System.out.printf("La temperatura máxima alcanzada ha sido de %.2fºC%n", maximHigh);
            System.out.printf("La temperatura mínima alcanzada ha sido de %.2fºC%n", minLow);

        } else {
            System.out.println("No hay temperaturas registradas :(");
        }
        myFile.close();
    }
}
