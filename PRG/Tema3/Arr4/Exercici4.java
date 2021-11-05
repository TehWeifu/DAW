import java.util.Scanner;

public class Exercici4 {
    private static final byte LENGTH = 15;

    public static final Scanner sc = new Scanner(System.in);
    public static final String[] titles = {
            "La perla", "Amuleto", "Azafrán", "Calix", "Celda 211", "City", "Crepúsculo", "Dos ranas", "Ébano",
            "El baile", "El lector", "Luna nueva", "Piedad", "Todo fluye", "Una vez"
    };
    public static final int[] state = new int[LENGTH];

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

    public static void printAll() {
        System.out.printf("%-15s%s%n", "Títol", "Tipus de préstec");
        for (int i = 0; i < titles.length; i++) {
            System.out.printf("%-15s%d%n", titles[i], state[i]);
        }
    }

    public static int search(String str) {
        for (int i = 0; i < titles.length; i++) {
            if (titles[i].equals(str)) return i;
        }
        return -1;
    }

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
