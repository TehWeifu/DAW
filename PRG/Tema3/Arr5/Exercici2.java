import java.util.Scanner;

public class Exercici2 {
    private static final Scanner sc = new Scanner(System.in);

    // Constant declaration for the array and its rows and columns
    private static final int NUM_ROOMS = 3;
    private static final int NUM_PCS = 10;
    private static final boolean[][] library = new boolean[NUM_ROOMS][NUM_PCS];

    // Prints the menu and prompts user to input a menu and validates it. Returns a menu option
    private static int mainMenu() {
        int inputOption;
        System.out.println("Menu");
        System.out.println("1. Assignar");
        System.out.println("2. Cancel·lar");
        System.out.println("3. Equips per sala");
        System.out.println("4. Eixir");
        do {
            System.out.print("Introduïsca una opció: ");
            inputOption = sc.nextInt();
        } while (inputOption < 1 || inputOption > 4);
        return inputOption;
    }

    // Method to change the status of a PC to its parameter value
    // Prompts user to input the room number and PC number and validates both values
    private static void assign(boolean state) {
        int inputRoom;
        int inputPc;

        do {
            System.out.print("Introduïsca la sala (1-3): ");
            inputRoom = sc.nextInt();
        } while (inputRoom < 1 || inputRoom > 3);

        do {
            System.out.print("Introduïsca el PC (1-10): ");
            inputPc = sc.nextInt();
        } while (inputPc < 1 || inputPc > 10);

        library[inputRoom - 1][inputPc - 1] = state;
    }

    // Prints the current state of the whole library
    private static void printLibrary() {
        System.out.println("PCs Biblioteca (0 == lliure | X == assignat)");

        System.out.printf("%10s", " ");

        for (int i = 0; i < 10; i++) {
            System.out.printf("%-5s", ("PC" + (i + 1)));
        }
        System.out.println("Total");

        for (int i = 0; i < library.length; i++) {
            System.out.printf("%-10s", ("Sala " + (i + 1)));

            int count = 0;
            for (int j = 0; j < library[i].length; j++) {
                if (library[i][j]) count++;
                System.out.printf("%-5s", (library[i][j] ? "X" : "O"));
            }
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        int menuOption;
        do {
            menuOption = mainMenu();
            switch (menuOption) {
                case 1:
                    assign(true);
                    break;
                case 2:
                    assign(false);
                    break;
                case 3:
                    printLibrary();
                    break;
            }
            System.out.println();
        } while (menuOption != 4);
    }
}
