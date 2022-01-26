import java.util.*;

public class App {
    public static final Scanner scanner = new Scanner(System.in);
    public static final Random random = new Random();

    private static final Estanteria estanteria = new Estanteria();

    private static int mainMenu() {
        System.out.println("╔════════════ MENU ════════════╗");
        System.out.println("║ 1. Agregar publicación       ║");
        System.out.println("║ 2. Modificar dato revista    ║");
        System.out.println("║ 3. Modificar dato libro      ║");
        System.out.println("║ 4. Modificar estado préstamo ║");
        System.out.println("║ 5. Mostrar una publicación   ║");
        System.out.println("║ 6. Mostrar todo              ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ 7. Generar aleatoriamente    ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ 8. Salir                     ║");
        System.out.println("╚══════════════════════════════╝");

        int inputOption;
        do {
            System.out.print("Introduzca una opción: ");
            inputOption = Integer.parseInt(scanner.nextLine());
        } while (inputOption < 1 || inputOption > 7);

        return inputOption;
    }

    private static void addNewPublication() {
        int menuOption = newPublicationMenu();

        System.out.print("Introduzca el ID: ");
        final int inputID = Integer.parseInt(scanner.nextLine());

        if (estanteria.findPublicacioPorCodi(inputID) != null) {
            System.out.printf("Error. Ya existe una publicación con el ID %d%n", inputID);
            return;
        }

        System.out.print("Introduzca el Titulo: ");
        final String inputTitle = scanner.nextLine();

        System.out.print("Introduzca el Año de publicación: ");
        final int inputYear = Integer.parseInt(scanner.nextLine());

        switch (menuOption) {
            case 1:
                estanteria.addEstanteria(new Llibres(inputID, inputTitle, new Date(inputYear, 0, 0)));
                break;
            case 2:
                int inputBorrowNum;
                do {
                    System.out.print("Introduzca el numero de préstamo (0-1): ");
                    inputBorrowNum = Integer.parseInt(scanner.nextLine());
                } while (inputBorrowNum < 0 || inputBorrowNum > 1);

                estanteria.addEstanteria(new Revistas(inputID, inputTitle, new Date(inputYear, 0, 0), inputBorrowNum));
                break;
        }
    }

    private static int newPublicationMenu() {
        int inputOption;

        System.out.println("╔══════════ SUB-MENU ══════════╗");
        System.out.println("║ 1. Agregar libro             ║");
        System.out.println("║ 2. Agregar revista           ║");
        System.out.println("║ 3. Volver al menú principal  ║");
        System.out.println("╚══════════════════════════════╝");

        do {
            System.out.print("Introduzca una opción: ");
            inputOption = Integer.parseInt(scanner.nextLine());
        } while (inputOption < 1 || inputOption > 3);

        return inputOption;
    }

    private static void modifyPublication(final int type) {
        // type 1 = book
        // type 2 = magazine

        System.out.printf("Introduzca el id %s: ", (type == 1 ? "del libro" : "de la revista"));
        final int inputID = Integer.parseInt(scanner.nextLine());

        if (estanteria.findPublicacioPorCodi(inputID) == null) {
            System.out.printf("Error. No existe ninguna publicación con el ID %d.%n", inputID);
            return;
        }

        if (estanteria.findPublicacioPorCodi(inputID) instanceof Revistas && type == 1) {
            System.out.printf("Error. La publicación con ID %d no es un libro.%n", inputID);
            return;
        }

        if (estanteria.findPublicacioPorCodi(inputID) instanceof Llibres && type == 2) {
            System.out.printf("Error. La publicación con ID %d no es una revista.%n", inputID);
            return;
        }

        int menuOption = modifyAttributeMenu();

        switch (menuOption) {
            case 1:
                System.out.print("Introduzca el nuevo título: ");
                estanteria.findPublicacioPorCodi(inputID).setTitol(scanner.nextLine());
                break;
            case 2:
                System.out.print("Introduzca el nuevo año de publicación: ");
                estanteria.findPublicacioPorCodi(inputID).setAnyPublicacio(new Date(Integer.parseInt(scanner.nextLine()), 0, 0));
                break;
        }
    }

    private static int modifyAttributeMenu() {
        System.out.println("╔════════════ SUB-MENU ════════════╗");
        System.out.println("║ 1. Modificar titulo              ║");
        System.out.println("║ 2. Modificar año de publicación  ║");
        System.out.println("║ 3. Volver al menú principal      ║");
        System.out.println("╚══════════════════════════════════╝");

        int inputOption;
        do {
            System.out.print("Introduzca una opción: ");
            inputOption = Integer.parseInt(scanner.nextLine());
        } while (inputOption < 1 || inputOption > 3);
        return inputOption;
    }

    private static void modifyBorrowStatus() {
        System.out.print("Introduzca el id de la publicación: ");
        final int inputID = Integer.parseInt(scanner.nextLine());

        if (estanteria.findPublicacioPorCodi(inputID) == null) {
            System.out.printf("Error. No existe ninguna publicación con el ID %d.%n", inputID);
            return;
        }

        Publicacio tmpPublication = estanteria.findPublicacioPorCodi(inputID);

        final int menuOption = borrowStatusMenu();

        switch (menuOption) {
            case 1:
                if (tmpPublication.prestat()) {
                    System.out.printf("Error. La publicación con ID %s ya está prestada.%n", inputID);
                } else {
                    tmpPublication.prestar();
                    System.out.printf("Se ha prestado la publicación con ID %d%n", inputID);
                }
                break;
            case 2:
                if (tmpPublication.prestat()) {
                    tmpPublication.retornar();
                    System.out.printf("Se ha devuelto la publicación con ID %d%n", inputID);
                } else {
                    System.out.printf("Error. La publicación con ID %s ya está en la biblioteca.%n", inputID);
                }
                break;
        }
    }

    private static int borrowStatusMenu() {
        System.out.println("╔══════════ SUB-MENU ══════════╗");
        System.out.println("║ 1. Prestar                   ║");
        System.out.println("║ 2. Devolver                  ║");
        System.out.println("║ 3. Volver al menú principal  ║");
        System.out.println("╚══════════════════════════════╝");

        int inputOption;
        do {
            System.out.print("Introduzca una opción: ");
            inputOption = Integer.parseInt(scanner.nextLine());
        } while (inputOption < 1 || inputOption > 3);
        return inputOption;
    }

    private static void printPublication() {
        System.out.print("Introduzca el id de la publicación: ");
        final int inputID = Integer.parseInt(scanner.nextLine());

        if (estanteria.findPublicacioPorCodi(inputID) == null) {
            System.out.printf("Error. No existe ninguna publicación con el ID %s%n", inputID);
        } else {
            System.out.println(estanteria.findPublicacioPorCodi(inputID));
        }
    }

    private static void printAll() {
        System.out.println(estanteria.getEstanteria());
    }

    private static void generatePublications() {
        System.out.print("Introduzca el numero de publicaciones a generar: ");
        final int inputNum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < inputNum; i++) {
            if (random.nextBoolean()) {
                estanteria.addEstanteria(new Llibres(random.nextInt(1_000_000), generateString(), new Date(random.nextInt(2_022), 0, 0)));
            } else {
                estanteria.addEstanteria(new Revistas(random.nextInt(1_000_000), generateString(), new Date(random.nextInt(2_022), 0, 0), random.nextInt(2)));
            }
        }
    }

    private static String generateString() {
        StringBuilder tmpString = new StringBuilder();

        for (int i = 0; i < 5 + random.nextInt(11); i++) {
            tmpString.append((char) ('a' + random.nextInt(26)));
        }

        return tmpString.toString();
    }


    public static void main(String[] args) {
        int menuOption;

        do {
            menuOption = mainMenu();

            switch (menuOption) {
                case 1:
                    addNewPublication();
                    break;
                case 2:
                    modifyPublication(2);
                    break;
                case 3:
                    modifyPublication(1);
                    break;
                case 4:
                    modifyBorrowStatus();
                    break;
                case 5:
                    printPublication();
                    break;
                case 6:
                    printAll();
                    break;
                case 7:
                    generatePublications();
                    break;
            }
            System.out.println();
        } while (menuOption != 8);

    }
}
