import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    private static final String FILE_URL = "./emails.txt";
    private static FileWriter myFile = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (openFile()) {
            do {
                System.out.print("Introduzca un email (-1 para salir): ");
                String inputMail = scanner.nextLine();

                if (inputMail.equals("-1")) break;
                if (!isMailValid(inputMail)) {
                    System.out.println("El email no es valido");
                    continue;
                }

                try {
                    myFile.write(inputMail + System.lineSeparator());
                } catch (IOException e) {
                    System.out.println("Error al escribir en el fichero. Se va a terminar el programa");
                    e.printStackTrace();
                    break;
                }
            } while (true);

            closeFile();
        }
    }

    private static boolean openFile() {
        try {
            myFile = new FileWriter(FILE_URL, true);
        } catch (IOException e) {
            System.out.println("Error. El fichero no se ha podido abrir o crear. Se va a terminar el programa");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static void closeFile() {
        try {
            myFile.close();
        } catch (IOException e) {
            System.out.println("No se ha podido cerrar el fichero correctamente");
            e.printStackTrace();
        }
    }

    private static boolean isMailValid(final String mail) {
        return mail.matches("^[\\w-_.]+@[\\w-_]*(\\.\\w{2,4}){1,23}$");
    }
}
