import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String FILE_URL = "./temperatures.txt";

    private static int mainMenu() {
        System.out.println();
        System.out.println("╔════════════ MENU ════════════╗");
        System.out.println("║ 1. Registrar  temperaturas   ║");
        System.out.println("║ 2. Mostrar historial         ║");
        System.out.println("║ 3. Salir                     ║");
        System.out.println("╚══════════════════════════════╝");

        int inputOption = 0;
        boolean validInput = true;
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

    private static void printRecords() {
        Scanner myFile = null;
        try {
            myFile = new Scanner(Paths.get(FILE_URL));
        } catch (Exception e) {
            System.out.println("Error. no se ha podido abrir el archivo");
            return;
        }

        if (myFile.hasNextLine()) {
            int maximHigh = Integer.MIN_VALUE;
            int minLow = Integer.MAX_VALUE;
            System.out.printf("%-20s%-25s%s%n", "Fecha", "Temperatura Maxima", "Temperatura minima");
            while (myFile.hasNextLine()) {
                String[] tmpArr = myFile.nextLine().split("\\s+");
                System.out.printf("%-20s%-25s%s%n", tmpArr[0], tmpArr[1] + "ºC", tmpArr[2] + "ºC");

                if (Integer.parseInt(tmpArr[1]) > maximHigh) maximHigh = Integer.parseInt(tmpArr[1]);
                if (Integer.parseInt(tmpArr[2]) < minLow) minLow = Integer.parseInt(tmpArr[2]);
            }

            System.out.println();
            System.out.printf("La temperatura máxima alcanzada ha sido de %dºC%n", maximHigh);
            System.out.printf("La temperatura mínima alcanzada ha sido de %dºC%n", minLow);

        } else {
            System.out.println("No hay temperaturas registradas :(");
        }
        myFile.close();
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

            int inputMax;
            do {
                System.out.print("Introduzca la temperatura máxima: ");
                try {
                    inputMax = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error. El valor introducido no es válido");
                }
            } while (true);

            int inputMin;
            do {
                System.out.print("Introduzca la temperatura mínima: ");
                try {
                    inputMin = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error. El valor introducido no es válido");
                }
            } while (true);

            myFile.format("%s %d %d%n", inputDate, inputMax, inputMin);

            System.out.println();
        } while (true);

        myFile.close();
    }

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
}