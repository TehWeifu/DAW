import java.util.Random;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static Street street;

    private static int mainMenu() {
        System.out.println("╔════════════ MENU ════════════╗");
        System.out.println("║ 1. Agregar edificio          ║");
        System.out.println("║ 2. Reemplazar edificio       ║");
        System.out.println("║ 3. Mostrar todo              ║");
        System.out.println("║ 4. Iluminar calle            ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ 5. Generar aleatoriamente    ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ 6. Salir                     ║");
        System.out.println("╚══════════════════════════════╝");

        int inputOption;
        do {
            System.out.print("Introduzca una opción: ");
            inputOption = Integer.parseInt(scanner.nextLine());
        } while (inputOption < 1 || inputOption > 6);
        return inputOption;
    }

    private static Building promptNewBuilding() {
        final int menuOption = buildingMenu();

        if (menuOption == 4) return null;

        System.out.print("Introduzca el nombre: ");
        final String inputName = scanner.nextLine();

        System.out.print("Introduzca el numero de ascensores: ");
        final int inputElevators = Integer.parseInt(scanner.nextLine());

        switch (menuOption) {
            case 1:
                System.out.print("Introduzca el numero de habitaciones: ");
                final int inputRooms = Integer.parseInt(scanner.nextLine());
                return new Hotel(inputName, inputElevators, inputRooms);
            case 2:
                System.out.print("Introduzca el numero de mesas: ");
                final int inputTables = Integer.parseInt(scanner.nextLine());
                return new Restaurant(inputName, inputElevators, inputTables);
            case 3:
                System.out.print("Introduzca el numero de alojamientos: ");
                final int inputHousing = Integer.parseInt(scanner.nextLine());
                return new Apartment(inputName, inputElevators, inputHousing);
        }
        return null;
    }

    private static void addBuilding() {
        if (street.isFull()) {
            System.out.println("Error. No caben mas edificios en la calle");
            return;
        }

        Building tmpBuilding = promptNewBuilding();
        while (tmpBuilding != null) {
            street.addBuilding(tmpBuilding);
            tmpBuilding = promptNewBuilding();
        }
    }

    private static int buildingMenu() {
        System.out.println("╔════════ MENU EDIFICIOS ════════╗");
        System.out.println("║ 1. Hotel                       ║");
        System.out.println("║ 2. Restaurante                 ║");
        System.out.println("║ 3. Apartamento                 ║");
        System.out.println("╠════════════════════════════════╣");
        System.out.println("║ 4. Volver al menu principal    ║");
        System.out.println("╚════════════════════════════════╝");

        int inputOption;
        do {
            System.out.print("Introduzca una opción: ");
            inputOption = Integer.parseInt(scanner.nextLine());
        } while (inputOption < 1 || inputOption > 4);
        return inputOption;
    }

    private static void modifyBuilding() {
        System.out.print("Introduzca el ID del edificio que desea modificar: ");
        final int inputID = Integer.parseInt(scanner.nextLine());

        final int tmpIdx = street.findBuildingByID(inputID);

        if (tmpIdx == -1) {
            System.out.println("Error. No existe ningún edificio con tal ID.");
        } else {
            Building tmpBuilding = promptNewBuilding();
            if (tmpBuilding != null) {
                street.remplaceBuilding(tmpBuilding, tmpIdx);
            }
        }
    }

    private static void printAll() {
        System.out.printf("Hay un total de %d edificios.%n", Hotel.getCount() + Apartment.getCount() + Restaurant.getCount());
        System.out.printf("   - %d Hoteles%n", Hotel.getCount());
        System.out.printf("   - %d Restaurantes%n", Restaurant.getCount());
        System.out.printf("   - %d Apartamentos%n%n", Apartment.getCount());
        System.out.println(street);
    }

    private static void printLights() {
        System.out.println(street.getStreetLights());
    }

    private static void generateRandomBuildings() {
        while (!street.isFull()) {
            final int randomType = random.nextInt(3);
            switch (randomType) {
                case 0:
                    street.addBuilding(new Hotel(generateRandomStr(), random.nextInt(100), random.nextInt(100)));
                    break;
                case 1:
                    street.addBuilding(new Restaurant(generateRandomStr(), random.nextInt(100), random.nextInt(100)));
                    break;
                case 2:
                    street.addBuilding(new Apartment(generateRandomStr(), random.nextInt(100), random.nextInt(100)));
                    break;
            }
        }
    }

    private static String generateRandomStr() {
        StringBuilder tmpBuilder = new StringBuilder();

        for (int i = 0; i < 5 + random.nextInt(11); i++) {
            tmpBuilder.append((char) ('a' + random.nextInt(26)));
        }

        return tmpBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.print("Introduzca el numero de edificios a crear: ");
        street = new Street(Integer.parseInt(scanner.nextLine()));

        int menuOption;
        do {
            menuOption = mainMenu();

            switch (menuOption) {
                case 1:
                    addBuilding();
                    break;
                case 2:
                    modifyBuilding();
                    break;
                case 3:
                    printAll();
                    break;
                case 4:
                    printLights();
                    break;
                case 5:
                    generateRandomBuildings();
                    break;
            }
        } while (menuOption != 6);
    }
}
