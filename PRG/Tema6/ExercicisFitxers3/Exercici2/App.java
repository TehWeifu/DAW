import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class App {
    private static final String FILE_URL = "./contacts.txt";

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<List<String>> contactArr = new ArrayList<>();

    private static void loadContacts() {
        Scanner myFile;
        try {
            myFile = new Scanner(Paths.get(FILE_URL));
        } catch (IOException e) {
            return;
        }

        while (myFile.hasNextLine()) {
            String[] tmpArr = myFile.nextLine().split("\\s+");
            contactArr.add(Arrays.asList(tmpArr[0], tmpArr[1]));
        }

        myFile.close();
    }

    private static void saveContacts() {
        Formatter myFile;

        try {
            myFile = new Formatter(FILE_URL);
        } catch (IOException e) {
            System.out.println("Error al intentar guardar los cambios");
            return;
        }

        for (List<String> contact : contactArr) {
            myFile.format("%s %s%n", contact.get(0), contact.get(1));
        }

        myFile.close();
    }

    private static int mainMenu() {
        System.out.println();
        System.out.println("╔════════════ MENU ════════════╗");
        System.out.println("║ 1. Nuevo contacto            ║");
        System.out.println("║ 2. Buscar contacto           ║");
        System.out.println("║ 3. Mostrar contactos         ║");
        System.out.println("║ 4. Salir                     ║");
        System.out.println("╚══════════════════════════════╝");

        int inputOption = 0;
        boolean validInput;
        do {
            validInput = true;

            System.out.print("Introduzca una opción: ");
            try {
                inputOption = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                validInput = false;
            }

            if (inputOption < 1 || inputOption > 4) validInput = false;

            if (!validInput) System.out.println("Error. Se ha introducido una opción no válida");

        } while (!validInput);

        return inputOption;
    }


    private static void addContact() {
        if (contactArr.size() >= 20) {
            System.out.println("La lista de contactos está llena, no se pueden añadir más");
            return;
        }

        System.out.print("Introduce el nombre del nuevo contacto: ");
        final String inputName = scanner.nextLine();

        int contactIdx = findContactByName(inputName);

        if (contactIdx != -1) {
            System.out.println("Error. Ya existe con contacto con dicho nombre.");
            return;
        }

        System.out.print("Introduce el numero de teléfono del contacto: ");
        final String inputTfn = scanner.nextLine();

        contactArr.add(Arrays.asList(inputName, inputTfn));
    }

    private static void searchContact() {
        System.out.print("Introduce el nombre del contacto que deseas buscar: ");
        final String inputName = scanner.nextLine();

        int contactIdx = findContactByName(inputName);

        if (contactIdx != -1) {
            System.out.printf("El numero de teléfono de %s es: %s", contactArr.get(contactIdx).get(0), contactArr.get(contactIdx).get(1));
        } else {
            System.out.printf("No existe el contacto \"%s\" en tu lista de contactos.%n", inputName);
        }

    }

    private static void printContacts() {
        if (contactArr.isEmpty()) {
            System.out.println("No tienes amigos :(");
            return;
        }

        System.out.printf("%-20s%s%n", "Nombre", "Teléfono");
        for (List<String> contact : contactArr) {
            System.out.printf("%-20s%s%n", contact.get(0), contact.get(1));
        }
    }

    private static int findContactByName(final String name) {
        for (int i = 0; i < contactArr.size(); i++) {
            if (contactArr.get(i).get(0).equals(name)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        loadContacts();

        int menuOption;
        do {
            menuOption = mainMenu();
            switch (menuOption) {
                case 1:
                    addContact();
                    break;
                case 2:
                    searchContact();
                    break;
                case 3:
                    printContacts();
                    break;
            }
            System.out.println();
        } while (menuOption != 4);
        saveContacts();
    }
}
