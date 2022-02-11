import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    private static int mainMenu() {
        System.out.println("1. Algo");
        System.out.println("2. Imprimir");
        System.out.println("3. Salir");

        int inputOption;
        do {
            System.out.print("Introduzca una opcion");
            inputOption = Integer.parseInt(scanner.nextLine());
        } while (inputOption < 1 || inputOption > 3);

        return inputOption;
    }

    private static void printFields() {
        Scanner myFile = null;
        try {
            myFile = new Scanner("./temperatures.txt");
        } catch (Exception e) {
            System.out.println("Error. no se ha podido abrir el archivo");
            return;
        }

        System.out.printf("%-20s%-20s%s", "Fecha", "Temperatura Maxima", "Temperatura minima");
        while (myFile.hasNextLine()) {
            String[] tmpArr = myFile.nextLine().split("\\s+");
            // TODO: change this
            System.out.printf("%-20s%-20s%s", "Fecha", "Temperatura Maxima", "Temperatura minima");
        }
    }

    public static void main(String[] args) {
        int menuOption;
        do {
            menuOption = mainMenu();
            switch (menuOption) {
                case 1:
                    break;
                case 2:
                    printFields();
                    break;
            }
        } while (menuOption != 3);
    }
}