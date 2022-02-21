import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static final String FILE_URL = "./cars.csv";

    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Car> arrOfCars = new ArrayList<>();

    public static void main(String[] args) {
        loadCars();
        int menuOption;
        do {
            menuOption = mainMenu();
            switch (menuOption) {
                case 1:
                    addCar();
                    break;
                case 2:
                    printCar();
                    break;
                case 3:
                    removeCar();
                    break;
            }
            System.out.println();
        } while (menuOption != 4);
        saveCars();
    }

    private static int mainMenu() {
        System.out.println("╔════════════════ MENU ════════════════╗");
        System.out.println("║ 1. Agregar coche a reparación        ║");
        System.out.println("║ 2. Mostrar fecha de reparación       ║");
        System.out.println("║ 3. Borrar coche reparado             ║");
        System.out.println("║ 4. Salir                             ║");
        System.out.println("╚══════════════════════════════════════╝");

        return promptInt("Introduzca una opción: ", 1, 4);
    }

    private static void loadCars() {
        Scanner myFile;
        try {
            myFile = new Scanner(Paths.get(FILE_URL));
        } catch (IOException e) {
            return;
        }

        while (myFile.hasNextLine()) {
            String[] tmpArr = myFile.nextLine().split(",");
            arrOfCars.add(new Car(tmpArr[0], LocalDate.parse(tmpArr[1])));
        }

        myFile.close();
    }

    private static void saveCars() {
        FileWriter myFile;
        try {
            myFile = new FileWriter(FILE_URL);
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo de escritura");
            return;
        }

        for (Car car : arrOfCars) {
            try {
                myFile.write(car.getNumPlate() + "," + car.getEntryDate() + System.lineSeparator());
            } catch (IOException e) {
                System.out.println("Se ha producido un error en la escritura del fichero");
                return;
            }
        }

        try {
            myFile.close();
        } catch (IOException e) {
            System.out.println("Se ha producido un error al cerrar el fichero");
        }
    }

    private static void addCar() {
        System.out.print("Introduzca una matricula: ");
        String inputPlate = scanner.nextLine();
        System.out.println("Fecha de entrada");
        LocalDate entryDate = promptDate(false);

        if (findCarByPlate(inputPlate) == null) {
            arrOfCars.add(new Car(inputPlate, entryDate));
        } else {
            System.out.println("Ya existe un coche con esta matricula");
        }
    }

    private static void printCar() {
        System.out.print("Introduzca una matricula: ");
        String inputPlate = scanner.nextLine();

        Car tmpCar = findCarByPlate(inputPlate);
        if (tmpCar == null) {
            System.out.printf("No existe ningún coche con la matricula %s%n", inputPlate);
        } else {
            System.out.println(tmpCar);
        }
    }

    private static void removeCar() {
        System.out.print("Introduzca una matricula: ");
        String inputPlate = scanner.nextLine();

        Car tmpCar = findCarByPlate(inputPlate);
        if (tmpCar == null) {
            System.out.printf("No existe ningún coche con la matricula %s%n", inputPlate);
        } else {
            arrOfCars.remove(tmpCar);
        }
    }

    private static Car findCarByPlate(final String plate) {
        for (Car car : arrOfCars) {
            if (plate.equalsIgnoreCase(car.getNumPlate())) return car;
        }
        return null;
    }

    private static int promptInt(final String message, final int minVal, final int maxVal) {
        Scanner scanner = new Scanner(System.in);

        int inputVal = Integer.MIN_VALUE;
        boolean isValid;

        do {
            isValid = true;

            System.out.print(message);
            try {
                inputVal = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                isValid = false;
            }

            if (isValid && inputVal < minVal || inputVal > maxVal) isValid = false;
            if (!isValid) System.out.println("Error se ha introducido un valor no valido");

        } while (!isValid);
        return inputVal;
    }

    private static int promptInt(final String message) {
        return promptInt(message, Integer.MIN_VALUE + 1, Integer.MAX_VALUE);
    }

    private static LocalDate promptDate(boolean needYear) throws DateTimeException {
        final int inputDay = promptInt("Introduzca el dia: ", 1, 31);
        final int inputMonth = promptInt("Introduzca el mes: ", 1, 12);
        int inputYear = needYear ? promptInt("Introduzca el año: ") : 0;

        LocalDate myDate;

        try {
            myDate = LocalDate.of(inputYear, inputMonth, inputDay);
        } catch (DateTimeException e) {
            throw new DateTimeException("Fecha no valida", e);
        }

        return myDate;
    }
}
