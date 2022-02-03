import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    private static final LlistaEmpleats employeeList = new LlistaEmpleats();

    private static int mainMenu() {
        System.out.println();
        System.out.println("Menu Principal");
        System.out.println("1. Afegir empleat");
        System.out.println("2. Borrar empleat");
        System.out.println("3. Mostrar empleats");
        System.out.println("4. Eixir");

        int inputOption;
        do {
            System.out.print("Introduzca una opcion: ");
            inputOption = Integer.parseInt(scanner.nextLine());
        } while (inputOption < 1 || inputOption > 4);
        return inputOption;
    }

    private static void addEmployee() {
        int menuOption = employeeMenu();

        if (menuOption == 3) {
            return;
        }

        System.out.print("Introduzca un dni: ");
        final String inputDni = scanner.nextLine();

        System.out.print("Introduzca el nombre: ");
        final String inputName = scanner.nextLine();

        System.out.print("Introduzca los apellidos: ");
        final String inputCognoms = scanner.nextLine();

        System.out.print("Introduzca la fecha de ingreso: ");
        final String inputDate = scanner.nextLine();

        boolean added;
        if (menuOption == 1) {
            added = employeeList.addEmpleat(new Caixer(inputDni, inputName, inputCognoms, inputDate));
        } else {
            added = employeeList.addEmpleat(new Acomodador(inputDni, inputName, inputCognoms, inputDate));
        }

        if (added) {
            System.out.println("Se ha agregado el nuevo usuario satisfactoriamente");
        } else {
            System.out.printf("Error. Ya existe un empleado con el dni %s%n", inputDni);
        }
    }

    private static int employeeMenu() {
        System.out.println();
        System.out.println("Submenus empleados");
        System.out.println("1. Caixer");
        System.out.println("2. Acomodador");
        System.out.println("3. Volver al menu principal");

        int inputOption;
        do {
            System.out.print("Introduzca una opcion: ");
            inputOption = Integer.parseInt(scanner.nextLine());
        } while (inputOption < 1 || inputOption > 3);
        return inputOption;
    }

    private static void removeEmployee() {
        System.out.print("Introduzca el dni del empleado a borrar: ");
        final String inputDni = scanner.nextLine();

        if (employeeList.removeEmpleatPerDni(inputDni)) {
            System.out.println("Se ha eliminado el empleado satisfactoriamente");
        } else {
            System.out.printf("Error. no existe ningun empleado con el dni %s%n", inputDni);
        }
    }

    private static void printAllEmployees() {
        System.out.println(employeeList);
    }

    public static void main(String[] args) {
        int menuOption;
        do {
            menuOption = mainMenu();

            switch (menuOption) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    removeEmployee();
                    break;
                case 3:
                    printAllEmployees();
                    break;
            }
        } while (menuOption != 4);
    }
}
