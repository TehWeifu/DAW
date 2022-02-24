import java.util.Scanner;

public class App {
    private static Company myCompany;

    public static void main(String[] args) {
        promptCompany();

        int menuOption;
        do {
            menuOption = mainMenu();
            switch (menuOption) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    fireEmployee();
                    break;
                case 3:
                    searchEmployee();
                    break;
                case 4:
                    printEmployees();
                    break;
            }
            System.out.println();
        } while (menuOption != 5);
    }

    private static void promptCompany() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca el nombre de la empresa: ");
        String inputName = scanner.nextLine();

        int inputCapacity = promptInt("Introduzca el numero de empleados maximo: ", 1, Integer.MAX_VALUE);

        myCompany = new Company(inputName, inputCapacity);
    }

    private static int mainMenu() {
        System.out.println("╔════════════════ MENU ════════════════╗");
        System.out.println("║ 1. Contratar empleado                ║");
        System.out.println("║ 2. Despedir empleado                 ║");
        System.out.println("║ 3. Buscar empleado                   ║");
        System.out.println("║ 4. Mostrar empleado                  ║");
        System.out.println("║ 5. Salir                             ║");
        System.out.println("╚══════════════════════════════════════╝");

        return promptInt("Introduzca una opción: ", 1, 4);
    }

    private static void addEmployee() {
        if (myCompany.isFull()) {
            System.out.println("La empresa esta a su maxima capacidad. Despide a alguien antes BloodTrail");
            return;
        }
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca el nombre del empleado: ");
        String inputName = scanner.nextLine();

        double inputSalary = promptNum("Introduzca el salario: ", 0, Double.MAX_VALUE);

        myCompany.addEmployee(inputName, inputSalary);
    }

    private static void fireEmployee() {
        int inputId = promptInt("Introduzca el id del empleado: ");

        try {
            myCompany.fireEmployee(inputId);
        } catch (companyException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void searchEmployee() {
        int inputId = promptInt("Introduzca el id del empleado: ");

        String employeeName;
        try {
            employeeName = myCompany.getName(inputId);
        } catch (companyException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.printf("El empleado con id %d se llama %s%n", inputId, employeeName);
    }

    private static void printEmployees() {
        System.out.println(myCompany);
    }

    private static double promptNum(final String message, final double minVal, final double maxVal) {
        Scanner scanner = new Scanner(System.in);

        double inputVal = Double.MIN_VALUE;
        boolean isValid;

        do {
            isValid = true;

            System.out.print(message);
            try {
                inputVal = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                isValid = false;
            }

            if (isValid && inputVal < minVal || inputVal > maxVal) isValid = false;
            if (!isValid) System.out.println("Error se ha introducido un valor no valido");

        } while (!isValid);
        return inputVal;
    }

    private static int promptInt(final String message, final int minVal, final int maxVal) {
        return (int) promptNum(message, minVal, maxVal);
    }

    private static int promptInt(final String message) {
        return promptInt(message, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}

