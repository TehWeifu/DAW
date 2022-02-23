import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final String FILE_URL = "users.csv";

    private static final List<User> arrOfUsers = new ArrayList<>();

    public static void main(String[] args) {
        loadUsers();
        int menuOption;
        do {
            menuOption = mainMenu();
            switch (menuOption) {
                case 1:
                    addUser();
                    break;
                case 2:
                    loadUrl();
                    break;
            }
        } while (menuOption != 3);
        saveUsers();
    }

    private static void loadUsers() {
        Scanner myFile;
        try {
            myFile = new Scanner(Paths.get(FILE_URL));
        } catch (IOException e) {
            return;
        }

        while (myFile.hasNextLine()) {
            String[] tmpArr = myFile.nextLine().split(",");
            arrOfUsers.add(new User(tmpArr[0], tmpArr[1], LocalDate.parse(tmpArr[2])));
        }

        myFile.close();
    }

    private static void saveUsers() {
        FileWriter myFile;
        try {
            myFile = new FileWriter(FILE_URL);
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo de escritura");
            return;
        }

        for (User user : arrOfUsers) {
            try {
                myFile.write(user.getName() + "," + user.getUrl() + "," + user.getDate() + System.lineSeparator());
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

    private static int mainMenu() {

        System.out.println("╔════════════════ MENU ════════════════╗");
        System.out.println("║ 1. Agregar URL                       ║");
        System.out.println("║ 2. Cargar URL                        ║");
        System.out.println("║ 3. Salir                             ║");
        System.out.println("╚══════════════════════════════════════╝");

        return promptInt("Introduzca una opción: ", 1, 3);
    }

    private static void addUser() {
        final Scanner scanner = new Scanner(System.in);

        String inputName;
        do {
            System.out.print("Introduzca un nick: ");
            inputName = scanner.nextLine().trim();
        } while (!isCSVFriendly(inputName));

        String inputUrl;
        do {
            System.out.print("Introduzca una URL: ");
            inputUrl = scanner.nextLine().trim();
        } while (!isCSVFriendly(inputUrl));

        if (!inputUrl.matches("^https?://")) {
            if (!inputUrl.matches("^www\\.")) {
                inputUrl = "https://www." + inputUrl;
            } else {
                inputUrl = "https://" + inputUrl;
            }
        }

        LocalDate inputDate;
        System.out.println("Introduzca una fecha");
        try {
            inputDate = promptDate(true);
        } catch (DateTimeException e) {
            return;
        }

        arrOfUsers.add(new User(inputName, inputUrl, inputDate));
    }

    private static void loadUrl() {
        final Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca un nick: ");
        String inputName = scanner.nextLine();

        LocalDate inputDate;
        System.out.println("Introduzca la fecha");
        try {
            inputDate = promptDate(true);
        } catch (DateTimeException e) {
            System.out.println("Se ha introducido una fecha no valida");
            return;
        }

        for (User user : arrOfUsers) {
            if (inputName.equals(user.getName()) && inputDate.isEqual(user.getDate())) {
                WebLoader.loadUrl(user.getUrl());
                return;
            }
        }
        System.out.println("No se ha encontrado ninguno registro con dichos parametros");
    }

    private static boolean isCSVFriendly(final String message) {
        return !message.matches(",");
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

    private static LocalDate promptDate() {
        return promptDate(true);
    }
}