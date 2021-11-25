import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercici1 {
    final private static Scanner scanner = new Scanner(System.in);
    final private static List<Vendedor> employeeArr = new ArrayList<>();

    private static int mainMenu() {
        int option;
        System.out.println("#############MENU############");
        System.out.println("# 1. Introducir Vendedores  #");
        System.out.println("# 2. Mostrar Vendedores     #");
        System.out.println("# 3. Mejor vendedor         #");
        System.out.println("# 4. Salir                  #");
        System.out.println("#############################");
        do {
            System.out.print("Introduzca una opcion: ");
            option = Integer.parseInt(scanner.nextLine());
        } while (option < 1 || option > 4);
        return option;
    }

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
                employeeArr.add(new Vendedor(inputName, inputUnits));
            }
        } while (!inputName.equals("exit"));
    }

    private static void printEmployees() {
        System.out.printf("%-20s%-10s%n", "Nombre", "Unidades Vendidas");
        for (Vendedor employee : employeeArr) {
            System.out.printf("%-20s%-10s%n", employee.getName(), employee.getSoldUnits());
        }
    }

    private static Vendedor bestEmployee() {
        Vendedor bestEmployee;

        if (employeeArr.isEmpty()) {
            return null;
        } else {
            bestEmployee = employeeArr.get(0);
        }

        for (Vendedor employee : employeeArr) {
            if (employee.getSoldUnits() > bestEmployee.getSoldUnits()) {
                bestEmployee = employee;
            }
        }
        return bestEmployee;
    }

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
                    Vendedor tmpEmployee = bestEmployee();
                    System.out.printf("El mejor vendedor es %s, el cual ha vendido un total de %d unidades.%n",
                            tmpEmployee.getName(), tmpEmployee.getSoldUnits());
                    break;
            }
            System.out.println();
        } while (menuOption != 4);
    }
}
