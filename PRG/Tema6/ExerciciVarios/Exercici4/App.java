import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner readFile1;
        Scanner readFile2;
        FileWriter writeFile;

        do {
            readFile1 = promptReadFile("Introduzca la ruta del primer fichero a leer: ");
            if (readFile1 == null) System.out.println("Error. No se ha podido abrir el primero fichero de lectura");
        } while (readFile1 == null);

        do {
            readFile2 = promptReadFile("Introduzca la ruta del segundo fichero a leer: ");
            if (readFile2 == null) System.out.println("Error. No se ha podido abrir el primero fichero de lectura");
        } while (readFile2 == null);

        do {
            writeFile = promptWriteFile("Introduzca la ruta del fichero donde copiar: ");
            if (writeFile == null) System.out.println("Error. No se ha podido abrir el archivo de escritura");
        } while (writeFile == null);


        boolean errorOcurred = false;
        while (!errorOcurred && readFile1.hasNextLine()) {
            try {
                writeFile.write(readFile1.nextLine() + System.lineSeparator());
            } catch (IOException e) {
                System.out.println("Se ha producido un error copiando del primer archivo. Se va a finalizar el programa");
                e.printStackTrace();
                errorOcurred = true;
            }
        }
        while (!errorOcurred && readFile2.hasNextLine()) {
            try {
                writeFile.write(readFile2.nextLine() + System.lineSeparator());
            } catch (IOException e) {
                System.out.println("Se ha producido un error copiando del primer archivo. Se va a finalizar el programa");
                e.printStackTrace();
                errorOcurred = true;
            }
        }

        readFile1.close();
        readFile2.close();
        try {
            writeFile.close();
        } catch (IOException e) {
            System.out.println("Error. No se ha podido cerrar el fichero de escritura");
            e.printStackTrace();
        }
    }

    private static Scanner promptReadFile(final String msg) {
        final Scanner scanner = new Scanner(System.in);
        System.out.print(msg);

        final String tmpFileUrl = scanner.nextLine();

        Scanner file;
        try {
            file = new Scanner(Paths.get(tmpFileUrl));
        } catch (IOException e) {
            return null;
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
