import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Program that allows the user to input several salesman and then obtain the one who sold the most units
public class Exercise1 {
    final private static Scanner scanner = new Scanner(System.in);
    final private static List<Salesman> employeeArr = new ArrayList<>();

    // Method that prints the main menu and prompts the user to input an option
    // Validates the option and then returns it
    private static int mainMenu() {
        int option;
        System.out.println("╔═══════════ MENU ═══════════╗");
        System.out.println("║ 1. Introducir Vendedores   ║");
        System.out.println("║ 2. Mostrar Vendedores      ║");
        System.out.println("║ 3. Mejor vendedor          ║");
        System.out.println("║ 4. Salir                   ║");
        System.out.println("╚════════════════════════════╝");
        do {
            System.out.print("Introduzca una opción: ");
            option = Integer.parseInt(scanner.nextLine());
        } while (option < 1 || option > 4);
        return option;
    }

    // Method that prompts the user to input a name and sold units for each Salesman objects
    // If the user inputs "exit" it will stop and return to the main menu
    private static void inputEmployees() {
        String inputName;
        int inputUnits;
        do {
            System.out.print("Introduzca el nombre ('exit' para volver al menu principal): ");
            inputName = scanner.nextLine();
            if (!inputName.equals("exit")) {
                do {
                    System.out.print("Introduzca el numero de unidades vendidas: ");
                    inputUnits = Integer.parseInt(scanner.nextLine());
                } while (inputUnits < 0);
                employeeArr.add(new Salesman(inputName, inputUnits));
            }
        } while (!inputName.equals("exit"));
    }

    // Method that prints every Salesman that has been inputted by the user
    private static void printEmployees() {
        System.out.printf("%-15s%s%n", "Nombre", "Unidades Vendidas");
        for (Salesman employee : employeeArr) {
            System.out.printf("%-15s%s%n", employee.getName(), employee.getSoldUnits());
        }
    }

    // Method that obtains the salesman object with the highest units sold by looping and comparing every object
    // returns the Salesman object or null if the container is empty
    private static Salesman bestEmployee() {
        Salesman bestEmployee;

        if (employeeArr.isEmpty()) {
            return null;
        } else {
            bestEmployee = employeeArr.get(0);
        }

        for (Salesman employee : employeeArr) {
            if (employee.getSoldUnits() > bestEmployee.getSoldUnits()) {
                bestEmployee = employee;
            }
        }
        return bestEmployee;
    }

    // Main method that loops over the menu until the user chooses to exit
    // Switches on every menu option, calling the corresponding function
    public static void main(String[] args) {
        int menuOption;
        do {
            menuOption = mainMenu();

            switch (menuOption) {
                case 1:
                    inputEmployees();
                    break;
                case 2:
                    printEmployees();
                    break;
                case 3:
                    // Checks the return value of the method call is not null in case the storage was empty
                    Salesman tmpEmployee = bestEmployee();
                    if (tmpEmployee == null) {
                        System.out.println("No hay vendedores :(");
                    } else {
                        System.out.printf("El mejor vendedor es %s, el cual ha vendido un total de %d unidades.%n",
                                tmpEmployee.getName(), tmpEmployee.getSoldUnits());
                    }
                    break;
            }
            System.out.println();
        } while (menuOption != 4);
    }
}
