import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        FileWriter writeFile;
        do {
            writeFile = promptWriteFile("Introduzca la ruta del fichero donde copiar: ");
            if (writeFile == null) System.out.println("Error. No se ha podido abrir el archivo de escritura");
        } while (writeFile == null);

        do {
            Scanner readFile;
            try {
                readFile = promptReadFile("Introduzca la ruta de un fichero a leer (-1 para para): ");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }

            if (readFile == null) break;

            boolean errorOcurred = false;
            while (!errorOcurred && readFile.hasNextLine()) {
                try {
                    writeFile.write(readFile.nextLine() + System.lineSeparator());
                } catch (IOException e) {
                    System.out.println("Se ha producido un error copiando del primer archivo. Se va a finalizar el programa");
                    e.printStackTrace();
                    errorOcurred = true;
                }
            }
            readFile.close();
        } while (true);

        try {
            writeFile.close();
        } catch (IOException e) {
            System.out.println("Error. No se ha podido cerrar el fichero de escritura");
            e.printStackTrace();
        }
    }

    private static Scanner promptReadFile(final String msg) throws IOException {
        final Scanner scanner = new Scanner(System.in);
        System.out.print(msg);

        final String tmpFileUrl = scanner.nextLine();

        if (tmpFileUrl.equals("-1")) return null;

        Scanner file;
        try {
            file = new Scanner(Paths.get(tmpFileUrl));
        } catch (IOException e) {
            throw new IOException("Error. No se ha podido abrir el fichero de lectura", e);
        }
        return file;
    }

    private static FileWriter promptWriteFile(final String msg) {
        final Scanner scanner = new Scanner(System.in);
        System.out.print(msg);

        final String tmpFileUrl = scanner.nextLine();

        FileWriter file;
        try {
            file = new FileWriter(tmpFileUrl);
        } catch (IOException e) {
            return null;
        }
        return file;
    }
}
