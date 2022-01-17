import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    public static final Random random = new Random();

    private static final List<User> users = new ArrayList<>();

    private static int mainMenu() {
        System.out.println("╔════════════════ MENU ════════════════╗");
        System.out.println("║ 1. Crear nuevo usuario               ║");
        System.out.println("║ 2. Banear usuario                    ║");
        System.out.println("║ 3. Cambiar E-mal                     ║");
        System.out.println("║ 4. Crear mensaje                     ║");
        System.out.println("║ 5. Eliminar mensaje                  ║");
        System.out.println("║ 6. Imprimir usuarios                 ║");
        System.out.println("║ 7. Generar usuarios (aleatoriamente) ║");
        System.out.println("║ 8. Salir                             ║");
        System.out.println("╚══════════════════════════════════════╝");

        int inputOption;
        do {
            System.out.print("Introduzca una opción: ");
            inputOption = Integer.parseInt(scanner.nextLine());
        } while (inputOption < 1 || inputOption > 8);
        return inputOption;
    }

    private static void addNewUser() {
        int userType = newUserMenu();

        System.out.print("Introduzca el nick del usuario: ");
        String inputNick = scanner.nextLine();
        System.out.print("Introduzca el email de usuario: ");
        String inputMail = scanner.nextLine();

        if (findUserByMail(inputMail) != -1) {
            System.out.printf("Error. Ya existe un usuario con este mail -> %s%n", inputMail);
            return;
        }

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
        System.out.println("╔═══════════ MENU USUARIOS ════════════╗");
        System.out.println("║ 1. Usuario normal                    ║");
        System.out.println("║ 2. Usuario moderador                 ║");
        System.out.println("║ 3. Usuario administrador             ║");
        System.out.println("║ 4. Salir                             ║");
        System.out.println("╚══════════════════════════════════════╝");

        int inputOption;
        do {
            System.out.print("Introduzca el tipo de usuario: ");
            inputOption = Integer.parseInt(scanner.nextLine());
        } while (inputOption < 1 || inputOption > 4);

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

        System.out.print("Introduce el mail del administrador que ha eliminado al usuario: ");
        String inputMailAdmin = scanner.nextLine();

        int adminIdx = findUserByMail(inputMailAdmin);
        if (adminIdx == -1) {
            System.out.println("Error. No existe ningún administrador con dicho mail");
            return;
        }

        if (users.get(adminIdx) instanceof Admin) {
            ((Admin) users.get(adminIdx)).addBan();

            System.out.printf("El usuario %s ha sido eliminado con éxito.%n", users.get(deleteUserIdx).getNick());
            users.remove(deleteUserIdx);
        } else {
            System.out.println("Error. El usuario %s no es Administrador");
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

            System.out.printf("Introduzca el nuevo email del usuario %s: ", tmpUser.getNick());
            final String inputNewMail = scanner.nextLine();
            if (findUserByMail(inputNewMail) != -1) {
                System.out.printf("Error. Ya existe un usuario con el mail -> %s%n", inputNewMail);
            }
            tmpUser.setMail(inputNewMail);
            System.out.printf("Se ha modificado el E-mail de usuario %s -> %s%n", tmpUser.getNick(), tmpUser.getMail());
        }
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
        System.out.print("Indica el E-mail del usuario que ha escrito el mensaje: ");
        String inputMailUser = scanner.nextLine();

        int userIdx = findUserByMail(inputMailUser);
        if (userIdx == -1) {
            System.out.printf("Error. No existe ningún usuario con el mail -> %s%n", inputMailUser);
            return;
        }

        User tmpUser = users.get(userIdx);
        if (tmpUser.getMessages() == 0) {
            System.out.printf("Error. El usuario %s no tiene mensajes%n", tmpUser.getNick());
            return;
        }

        System.out.print("Indica el E-mail del moderador o Administrador que ha borrado el mensaje: ");
        String inputMailAdmin = scanner.nextLine();

        int adminIdx = findUserByMail(inputMailAdmin);
        if (adminIdx == -1) {
            System.out.printf("No existe ningún usuario con el mail -> %s%n", inputMailAdmin);
            return;
        }

        User tmpAdvUser = users.get(adminIdx);
        if (tmpAdvUser instanceof Mod) {
            ((Mod) tmpAdvUser).addDeletedPost();
            System.out.printf("El Mod %s ha eliminado el mensaje de %s %n",
                    tmpAdvUser.getNick(), tmpUser.decreaseMessage().getNick());
        } else if (tmpAdvUser instanceof Admin) {
            ((Admin) tmpAdvUser).addDeletedPost();
            System.out.printf("El Admin %s ha eliminado el mensaje de %s %n",
                    tmpAdvUser.getNick(), tmpUser.decreaseMessage().getNick());
        } else {
            System.out.printf("Error. El usuario %s no es ni Mod ni Admin", tmpAdvUser.getNick());
        }
    }

    private static void printAll() {
        if (users.size() == 0) {
            System.out.println("No hay usuario registrados :(");
            return;
        }

        System.out.printf("Hay %d usuarios registrados%n", users.size());
        for (User user : users) {
            if (user instanceof Mod) System.out.println("Moderador");
            else if (user instanceof Admin) System.out.println("Administrador");
            else System.out.println("Usuario");

            System.out.println(user);
            System.out.println();
        }
    }

    private static void generateRndUsers() {
        System.out.print("Introduce el numero de usuario a generar: ");
        int inputNumber = Integer.parseInt(scanner.nextLine());

        int randomType;
        for (int i = 0; i < inputNumber; i++) {
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

    private static int findUserByMail(final String userMail) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getMail().equals(userMail)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int menuOption;
        do {
            menuOption = mainMenu();

            switch (menuOption) {
                case 1:
                    addNewUser();
                    break;
                case 2:
                    deleteUser();
                    break;
                case 3:
                    changeMail();
                    break;
                case 4:
                    newMessage();
                    break;
                case 5:
                    deleteMessage();
                    break;
                case 6:
                    printAll();
                    break;
                case 7:
                    generateRndUsers();
                    break;
            }
            System.out.println();
        } while (menuOption != 8);
    }
}
