import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    public static final Random random = new Random();

    private static final List<User> users = new ArrayList<>();

    private static int mainMenu() {
        System.out.println("╔════════════ MENU ════════════╗");
        System.out.println("║ 1. Crear nuevo usuario          ║");
        System.out.println("║ 1. Imprimir usuarios          ║");
        System.out.println("║ 1. Generar usuarios (aleatoriamente)          ║");
        System.out.println("║ 7. Salir                     ║");
        System.out.println("╚══════════════════════════════╝");

        int inputOption;
        do {
            System.out.print("Introduzca una opción: ");
            inputOption = Integer.parseInt(scanner.nextLine());
        } while (inputOption < 1 || inputOption > 0); // TODO: change this
        return inputOption;
    }

    private static void printAll() {
        for (User user : users) {
            if (user instanceof Mod) System.out.println("Moderador");
            else if (user instanceof Admin) System.out.println("Administrador");
            else System.out.println("Usuario");

            System.out.println(user);
            System.out.println();
        }
    }

    private static void addNewUser() {
        int userType = newUserMenu();

        System.out.println("Introduzca el nick del usuario: ");
        String inputNick = scanner.nextLine();
        System.out.println("Introduzca el email de usuario: ");
        String inputMail = scanner.nextLine();

        switch (userType) {
            case 1:
                users.add(new User(inputMail, inputNick));
                break;
            case 2:
                users.add(new Mod(inputMail, inputNick));
                break;
            case 3:
                users.add(new Admin(inputMail, inputNick));
        }
    }

    private static int newUserMenu() {
        System.out.println("1. Usuario normal");
        System.out.println("2. Usuario moderador");
        System.out.println("3. Usuario administrador");

        int inputOption;
        do {
            System.out.print("Introduzca el tipo de usuario: ");
            inputOption = Integer.parseInt(scanner.nextLine());
        } while (inputOption < 1 || inputOption > 3);

        return inputOption;
    }

    private static void deleteUser() {
        System.out.print("Introduzca el mail del usuario a eliminar: ");
        String inputMailtoDelete = scanner.nextLine();

        int deleteUserIdx = findUserByMail(inputMailtoDelete);
        if (deleteUserIdx == -1) {
            System.out.println("Error. No existe ningún usuario con dicho mail");
            return;
        }

        System.out.println("Introduce el mail del administrador que ha eliminado al usuario");
        String inputMailAdmin = scanner.nextLine();

        int adminIdx = findUserByMail(inputMailAdmin);
        if (adminIdx== -1) {
            System.out.println("Error. No existe ningún administrador con dicho mail");
            return;
        }
        // Comprobar que el usuario administrador es realmente administrador
        // Downcastear el admin para aumentar la cuenta de baneos
        // Borrar al usuario del array

        users.

        (Admin) users.get(adminIdx)
    }

    private static void generateRndUsers(final int number) {
        int randomType;
        for (int i = 0; i < number; i++) {
            randomType = random.nextInt(10);
            if (randomType < 7) {
                users.add(new User(random.nextInt(100), generateRndMail(), generateRndNick()));
            } else if (randomType < 9) {
                users.add(new Mod(random.nextInt(500), generateRndMail(), generateRndNick(), random.nextInt(100)));
            } else {
                users.add(new Admin(random.nextInt(2_000), generateRndMail(), generateRndNick(), random.nextInt(200), random.nextInt(50)));
            }
        }
    }

    private static String generateRndNick() {
        StringBuilder tmpStr = new StringBuilder();

        for (int i = 0; i < 5 + random.nextInt(16); i++) {
            if (random.nextBoolean()) {
                tmpStr.append((char) ('a' + random.nextInt(26)));
            } else {
                tmpStr.append((char) ('A' + random.nextInt(26)));
            }
        }

        return tmpStr.toString();
    }

    private static String generateRndMail() {
        StringBuilder tmpStr = new StringBuilder();

        for (int i = 0; i < 10 + random.nextInt(21); i++) {
            if (random.nextBoolean()) {
                tmpStr.append((char) ('a' + random.nextInt(26)));
            } else {
                tmpStr.append((char) ('A' + random.nextInt(26)));
            }
        }

        if (random.nextBoolean()) {
            tmpStr.append("@gmail.com");
        } else {
            tmpStr.append("@hotmail.com");
        }

        return tmpStr.toString();
    }

    private static void newMessage() {
        System.out.print("Indica el E-mail del usuario que ha creado el mensaje: ");
        String inputMail = scanner.nextLine();

        int userIdx = findUserByMail(inputMail);
        if (userIdx == -1) {
            System.out.printf("Error no existe ningún usuario con el mail -> %s%n", inputMail);
        } else {
            User tmpUser = users.get(userIdx);
            tmpUser.addMessage();
            System.out.printf("Se ha añadido un mensaje del usuario %s (%s mensajes)%n",
                    tmpUser.getNick(), tmpUser.getMessages());
        }
    }

    private static void deleteMessage() {
        System.out.print("Indica el E-mail del usuario que ha borrado el mensaje: ");
        String inputMail = scanner.nextLine();

        int userIdx = findUserByMail(inputMail);
        if (userIdx == -1) {
            System.out.printf("Error. No existe ningún usuario con el mail -> %s%n", inputMail);
        } else {
            User tmpUser = users.get(userIdx);
            if (tmpUser.getMessages() > 0) {
                tmpUser.decreaseMessage();
                System.out.printf("Se ha borrado un mensaje del usuario %s (%s mensajes)%n",
                        tmpUser.getNick(), tmpUser.getMessages());
            } else {
                System.out.printf("Error. El usuario %s no tiene mensajes.%n", tmpUser.getNick());
            }
        }
    }

    private static void changeMail() {
        System.out.print("Indica el E-mail del usuario que desees modificar: ");
        String inputMail = scanner.nextLine();

        int userIdx = findUserByMail(inputMail);
        if (userIdx == -1) {
            System.out.printf("Error. No existe ningún usuario con el mail -> %s%n", inputMail);
        } else {
            User tmpUser = users.get(userIdx);

            System.out.println("Introduzca");
            tmpUser.setMail(scanner.nextLine());

            System.out.printf("Se ha modificado el E-mail de usuario %s -> %s%n", tmpUser.getNick(), tmpUser.getMail());
        }
    }

    private static int findUserByMail(final String userMail) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getMail().equals(userMail)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        generateRndUsers(20);
        printAll();
    }
}
