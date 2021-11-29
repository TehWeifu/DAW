import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise1 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Car> cars = new ArrayList<>();

    // Method that prints the main menu and prompts user to introduce an option
    // Does basic validation on the input and returns it
    private static int mainMeu() {
        int inputOption;

        System.out.println("╔════════════ MENU ════════════╗");
        System.out.println("║ 1. Agregar un coche          ║");
        System.out.println("║ 2. Eliminar un coche         ║");
        System.out.println("║ 3. Contar coches             ║");
        System.out.println("║ 4. Mostrar coches            ║");
        System.out.println("║ 5. Mostrar coches por marca  ║");
        System.out.println("║ 6. Salir                     ║");
        System.out.println("╚══════════════════════════════╝");

        do {
            System.out.print("Elija una opción: ");
            inputOption = Integer.parseInt(scanner.nextLine());
        } while (inputOption < 1 || inputOption > 6);

        return inputOption;
    }

    // Method to add a car to the collection of cars
    // Checks the plate number to be valid and the plate number is not already in the collection
    private static void addCar() {
        String inputPlateNum;
        String inputBrand;
        String inputModel;
        double inputKms;

        System.out.print("Introduzca la matrícula: ");
        inputPlateNum = scanner.nextLine();

        if (Car.isPlateNumValid(inputPlateNum)) {
            if (findPlateNum(inputPlateNum) == -1) {
                System.out.print("Introduzca la marca: ");
                inputBrand = scanner.nextLine();
                System.out.print("Introduzca el modelo: ");
                inputModel = scanner.nextLine();
                System.out.print("Introduzca el numero de kilómetros: ");
                inputKms = Double.parseDouble(scanner.nextLine());
                cars.add(new Car(inputPlateNum, inputBrand, inputModel, inputKms));
            } else {
                System.out.println("Error. La matrícula ya existe.");
            }
        } else {
            System.out.println("Error. La matrícula no es válida.");
        }
    }

    // Method to remove a car from the collection of cars
    // Checks the plate number to be valid and the plate number is in the collection
    private static void removeCar() {
        String inputPlateNum;
        int carPos;

        System.out.print("Introduzca la matrícula: ");
        inputPlateNum = scanner.nextLine();

        if (Car.isPlateNumValid(inputPlateNum)) {
            carPos = findPlateNum(inputPlateNum);
            if (carPos != -1) {
                cars.remove(carPos);
                System.out.println("Se ha eliminado el coche.");
                Car.decreaseCarCount();
            } else {
                System.out.println("Error. La matrícula no existe.");
            }
        } else {
            System.out.println("Error. La matrícula no es válida.");
        }
    }

    // Method that prints the number of car elements existing in the collection
    private static void countCars() {
        System.out.printf("Hay un total de %d coches registrados.%n", Car.getCarCount());
    }

    // Overloaded method that delegates on the main method to print every car
    private static void printCars() {
        printCars(null);
    }

    // Main version of the overloaded method
    // Prints cars if they match the brand parameter or everything if the parameter is null
    private static void printCars(final String brand) {
        System.out.printf("%-12s%-10s%-10s%s%n", "Matricula", "Marca", "Modelo", "Kms");
        for (Car car : cars) {
            if (brand == null || brand.equals(car.getBrand())) {
                System.out.printf("%-12s%-10s%-10s%.2f%n", car.getPlateNum(), car.getBrand(), car.getModel(), car.getKms());
            }
        }
    }

    // Helper function to check if a plate number already exist
    // If it exists returns the position of the corresponding car in the collection
    // If it does exist return -1
    private static int findPlateNum(final String plateNum) {
        String tmpStr = plateNum.replaceAll(" ", "").toUpperCase();
        for (int i = 0; i < cars.size(); i++) {
            if (tmpStr.equals(cars.get(i).getPlateNum())) return i;
        }
        return -1;
    }

    // Main method that loops over the menu until the user chooses to exit
    public static void main(String[] args) {
        int menuOption;

        do {
            menuOption = mainMeu();

            switch (menuOption) {
                case 1:
                    addCar();
                    break;
                case 2:
                    removeCar();
                    break;
                case 3:
                    countCars();
                    break;
                case 4:
                    printCars();
                    break;
                case 5:
                    System.out.print("Introduzca una marca: ");
                    printCars(scanner.nextLine());
                    break;
            }
            System.out.println();
        } while (menuOption != 6);
    }
}
