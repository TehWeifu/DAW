import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class App {
    private static final String FILE_URL = "./ppl.csv";

    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Person> pplArr = new LinkedList<>();

    public static void main(String[] args) {
        loadPeople();

        int menuOption;
        do {
            menuOption = mainMenu();
            switch (menuOption) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    searchContact();
                    break;
                case 3:
                    modifyPerson();
                    break;
                case 4:
                    deletePerson();
                    break;
                case 5:
                    printContacts();
                    break;
                case 6:
                    generateRandomRecords();
                    break;
            }
            System.out.println();
        } while (menuOption != 7);
        savePeople();
    }

    private static void loadPeople() {
        Scanner myFile;
        try {
            myFile = new Scanner(Paths.get(FILE_URL));
        } catch (IOException e) {
            return;
        }

        while (myFile.hasNextLine()) {
            String[] tmpArr = myFile.nextLine().split(",");
            pplArr.add(new Person(tmpArr[0], Integer.parseInt(tmpArr[1]),
                    Double.parseDouble(tmpArr[2]), Double.parseDouble(tmpArr[3])));
        }

        myFile.close();
    }

    private static void savePeople() {
        Formatter myFile;
        try {
            myFile = new Formatter(FILE_URL);
        } catch (IOException e) {
            System.out.println("Error al intentar guardar los cambios");
            return;
        }

        for (Person person : pplArr) {
            myFile.format(Locale.ENGLISH, "%s,%d,%f,%f%n", person.getName(), person.getAge(), person.getWeight(), person.getHeight());
        }
        myFile.close();
    }

    private static int mainMenu() {
        System.out.println();
        System.out.println("╔════════════ MENU ════════════╗");
        System.out.println("║ 1. Crear deportista          ║");
        System.out.println("║ 2. Buscar deportista         ║");
        System.out.println("║ 3. Modificar deportista      ║");
        System.out.println("║ 4. Eliminar deportista       ║");
        System.out.println("║ 5. Mostrar deportistas       ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ 6. Generar aleatoriamente    ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ 7. Salir                     ║");
        System.out.println("╚══════════════════════════════╝");

        return promptMenuOption(7);
    }

    private static int promptMenuOption(final int options) {
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

            if (inputOption < 1 || inputOption > options) validInput = false;

            if (!validInput) System.out.println("Error. Se ha introducido una opción no válida");

        } while (!validInput);

        return inputOption;
    }

    private static void addPerson() {
        System.out.print("Introduce el nombre del nuevo deportista: ");
        final String inputName = scanner.nextLine();

        int contactIdx = findPersonByName(inputName);

        if (contactIdx != -1) {
            System.out.println("Error. Ya existe un deportista con dicho nombre.");
            return;
        }

        int inputAge;
        do {
            System.out.printf("Introduzca la edad de %s: ", inputName);

            try {
                inputAge = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error. La edad no es válida");
            }
        } while (true);

        double inputWeight;
        do {
            System.out.printf("Introduzca el peso de %s: ", inputName);

            try {
                inputWeight = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error. El peso no es válido");
            }
        } while (true);

        double inputHeight;
        do {
            System.out.printf("Introduzca la altura de %s: ", inputName);

            try {
                inputHeight = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error. La altura no es válida");
            }
        } while (true);

        try {
            pplArr.add(new Person(inputName, inputAge, inputWeight, inputHeight));
        } catch (IllegalArgumentException e) {
            System.out.println("Error. No se ha podido introducir el nuevo deportista.");
            System.out.println("Motivo: " + e.getMessage());
        }
    }

    private static void searchContact() {
        System.out.print("Introduce el nombre del deportista que deseas buscar: ");
        final String inputName = scanner.nextLine();

        int contactIdx = findPersonByName(inputName);

        if (contactIdx != -1) {
            System.out.println(pplArr.get(contactIdx));
        } else {
            System.out.printf("No existe el deportista \"%s\" en tu lista de contactos.%n", inputName);
        }
    }

    private static void modifyPerson() {
        System.out.print("Introduce el nombre del deportista que deseas modificar: ");
        final String inputName = scanner.nextLine();

        int contactIdx = findPersonByName(inputName);

        if (contactIdx != -1) {
            int submenuOption;
            do {
                submenuOption = modifyMenu();
                switch (submenuOption) {
                    case 1:
                        promptName(pplArr.get(contactIdx));
                        break;
                    case 2:
                        promptAge(pplArr.get(contactIdx));
                        break;
                    case 3:
                        promptWeight(pplArr.get(contactIdx));
                        break;
                    case 4:
                        promptHeight(pplArr.get(contactIdx));
                        break;
                }
            } while (submenuOption != 5);

        } else {
            System.out.printf("No existe el deportista \"%s\" en tu lista de contactos.%n", inputName);
        }
    }

    private static void promptName(final Person person) {
        System.out.println("Introduzca el nombre: ");
        String inputNewName = scanner.nextLine();

        if (findPersonByName(inputNewName) != -1) {
            System.out.printf("Error ya existe un deportista con el nombre %s.", inputNewName);
        } else {
            person.setName(inputNewName);
            System.out.printf("Se ha establecido el nombre de %s", inputNewName);
        }
    }

    private static void promptAge(final Person person) {
        int inputAge;
        do {
            System.out.printf("Introduzca la edad de %s: ", person.getName());

            try {
                inputAge = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error. La edad no es válida");
            }
        } while (true);

        try {
            person.setAge(inputAge);
        } catch (IllegalArgumentException e) {
            System.out.println("Error. La edad no es valida");
        }
    }

    private static void promptWeight(final Person person) {
        double inputWeight;
        do {
            System.out.printf("Introduzca el peso de %s: ", person.getName());

            try {
                inputWeight = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error. El peso no es válido");
            }
        } while (true);

        try {
            person.setWeight(inputWeight);
        } catch (IllegalArgumentException e) {
            System.out.println("Error. El peso no es válido");
        }
    }

    private static void promptHeight(final Person person) {
        double inputHeight;
        do {
            System.out.printf("Introduzca la altura de %s: ", person.getName());

            try {
                inputHeight = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error. La altura no es válida");
            }
        } while (true);

        try {
            person.setHeight(inputHeight);
        } catch (IllegalArgumentException e) {
            System.out.println("Error. La altura no es válida");
        }
    }

    private static int modifyMenu() {
        System.out.println();
        System.out.println("╔═════════ MENU MODIFICAR ═════════╗");
        System.out.println("║ 1. Modificar nombre              ║");
        System.out.println("║ 2. Modificar edad                ║");
        System.out.println("║ 2. Modificar peso                ║");
        System.out.println("║ 4. Modificar altura              ║");
        System.out.println("║ 5. Volver al menu principal      ║");
        System.out.println("╚══════════════════════════════════╝");

        return promptMenuOption(5);
    }

    private static void deletePerson() {
        System.out.println("Introduzca el nombre: ");
        String inputName = scanner.nextLine();

        int personIndex = findPersonByName(inputName);

        if (personIndex == -1) {
            System.out.printf("Error. No existe un deportista con el nombre %s.", inputName);
        } else {
            pplArr.remove(personIndex);
            System.out.printf("Se ha eliminado el deportista %s satisfactoriamente.%n", inputName);
        }
    }

    private static void printContacts() {
        if (pplArr.isEmpty()) {
            System.out.println("No hay deportistas :(");
            return;
        }

        int ageSum = 0;
        double weightSum = 0;
        double heightSum = 0;
        System.out.printf("%-20s%-10s%-10s%s%n", "Nombre", "Edad", "Peso", "Estatura");
        for (Person person : pplArr) {
            System.out.printf("%-20s%-10d%-10.2f%.2f%n", person.getName(), person.getAge(), person.getWeight(), person.getHeight());
            ageSum += person.getAge();
            weightSum += person.getWeight();
            heightSum += person.getHeight();
        }
        System.out.printf("La edad media de los deportistas es %.2f años%n", ((double) ageSum) / pplArr.size());
        System.out.printf("El peso medio de los deportistas es %.2f kg%n", weightSum / pplArr.size());
        System.out.printf("La altura media de los deportistas es %.2f m%n", heightSum / pplArr.size());
    }

    private static void generateRandomRecords() {
        int inputNum;
        do {
            System.out.print("Introduzca el numero de deportistas a generar: ");
            try {
                inputNum = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error. Se ha introducido un valor no valido");
            }
        } while (true);

        for (int i = 0; i < inputNum; i++) {
            pplArr.add(generateRndPerson());
        }
    }

    private static Person generateRndPerson() {
        return new Person(generateRndName(),
                random.nextInt(100), random.nextInt(200), random.nextInt(100) / 100.00 + 1);
    }

    private static String generateRndName() {
        final StringBuilder tmpBuffer = new StringBuilder();

        for (int i = 0; i < 2; i++) {
            tmpBuffer.append((char) ('A' + random.nextInt(26)));
            for (int j = 0; j < 3 + random.nextInt(8); j++) {
                tmpBuffer.append((char) ('a' + random.nextInt(26)));
            }
            tmpBuffer.append(" ");
        }

        return tmpBuffer.toString().trim();
    }

    private static int findPersonByName(final String name) {
        for (int i = 0; i < pplArr.size(); i++) {
            if (pplArr.get(i).getName().equals(name)) return i;
        }
        return -1;
    }
}
