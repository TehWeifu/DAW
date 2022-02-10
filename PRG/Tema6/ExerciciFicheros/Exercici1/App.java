import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {

        do {
            System.out.print("Introduzca la ruta del fichero: ");
            String inputUrl = scanner.nextLine();

            try {
                FileWriter myFile = new FileWriter(inputUrl);

                for (int i = 0; i < 10; i++) {
                    myFile.append(generateRndLine());
                }

                myFile.close();
                break;
            } catch (IOException e) {
                System.out.println("Error. No se ha podido abrir el fichero.");
            }
        } while (true);
        System.out.println("Se ha creado el fichero satisfactoriamente");
    }

    private static String generateRndString() {
        StringBuilder tmpStr = new StringBuilder();

        for (int i = 0; i < 5 + random.nextInt(11); i++) {
            tmpStr.append((char) ('a' + random.nextInt(26)));
        }

        return tmpStr.toString();
    }

    private static String generateRndLine() {
        StringBuilder tmpLine = new StringBuilder();

        for (int i = 0; i < 2 + random.nextInt(11); i++) {
            tmpLine.append(generateRndString()).append(" ");
        }
        tmpLine.append(System.lineSeparator());

        return tmpLine.toString();
    }
}