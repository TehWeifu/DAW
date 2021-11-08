import java.util.Scanner;

public class Exercici4 {
    // Declares constants for array length and a scanner
    private static final byte LENGTH = 15;
    public static final Scanner sc = new Scanner(System.in);

    // Declares two arrays, for titles and their states. Titles are initialized with constant values
    public static final String[] titles = {
            "La perla", "Amuleto", "Azafrán", "Calix", "Celda 211", "City", "Crepúsculo", "Dos ranas", "Ébano",
            "El baile", "El lector", "Luna nueva", "Piedad", "Todo fluye", "Una vez"
    };
    public static final int[] state = new int[LENGTH];

    // Method that prints the main Menu and prompts user to input an option, does validation and returns the option
    public static int mainMenu() {
        int res;
        System.out.println("MENU");
        System.out.println("1. Prestar");
        System.out.println("2. Informar");
        System.out.println("3. Mostrar tot");
        System.out.println("4. Eixir");
        do {
            System.out.print("Introduïsca una opció: ");
            res = sc.nextInt();
        } while (res < 1 || res > 4);
        return res;
    }

    // Method that prints the borrow option menu and prompts user to input an option, does validation and returns the option
    public static int borrowMenu() {
        int res;
        System.out.println();
        System.out.println("MENU prestar");
        System.out.println("0. Sense préstec");
        System.out.println("1. Préstec diari");
        System.out.println("2. Préstec setmanal");
        System.out.println("3. Préstec  mensual");
        System.out.println("4. Eixir");
        do {
            System.out.print("Introduïsca una opció: ");
            res = sc.nextInt();
        } while (res < 0 || res > 4);
        return res;
    }

    // Method that changes the state of a book by searching it for its name
    public static void borrow() {
        System.out.print("Introduïsca el títol de un llibre: ");
        sc.nextLine();
        String inputTitle = sc.nextLine();

        int searchIndex = search(inputTitle);

        if (searchIndex != -1) {
            int menuOption = borrowMenu();
            if (menuOption != 4) {
                state[searchIndex] = menuOption;
            }
        } else {
            System.out.println("Aquest llibre no existeix.");
        }
    }

    // Prints a single entry of a book and its state by searching for its name
    public static void printOne() {
        System.out.print("Introduïsca el títol de un llibre: ");
        sc.nextLine();
        String inputTitle = sc.nextLine();

        int searchIndex = search(inputTitle);

        if (searchIndex != -1) {
            System.out.print("El llibre \"" + inputTitle + "\"");
            switch (state[searchIndex]) {
                case 1:
                    System.out.println(" te un préstec diari");
                    break;
                case 2:
                    System.out.println(" te un préstec setmanal");
                    break;
                case 3:
                    System.out.println(" te un préstec mensual");
                    break;
                case 4:
                    System.out.println(" esta sense prestar");
                    break;
            }
        } else {
            System.out.println("Aquest llibre no existeix.");
        }
    }

    // Prints every book title and its state in a matrix format
    public static void printAll() {
        System.out.printf("%-15s%s%n", "Títol", "Tipus de préstec");
        for (int i = 0; i < titles.length; i++) {
            System.out.printf("%-15s%d%n", titles[i], state[i]);
        }
    }

    // Searches for a book by its title and returns its index. Returns -1 if it can't be found
    public static int search(final String str) {
        for (int i = 0; i < titles.length; i++) {
            if (titles[i].equals(str)) return i;
        }
        return -1;
    }

    // Loops over the menu until the user wants to exit
    public static void main(String[] args) {
        int menuOption;
        do {
            menuOption = mainMenu();

            switch (menuOption) {
                case 1:
                    borrow();
                    break;
                case 2:
                    printOne();
                    break;
                case 3:
                    printAll();
                    break;
            }
            System.out.println();
        } while (menuOption != 4);
    }
}

