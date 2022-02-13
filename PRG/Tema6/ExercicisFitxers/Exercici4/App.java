import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        FileReader myReadFile;
        FileWriter myWriteFile;

        do {
            System.out.print("Introduzca el nombre del fichero de origen: ");
            String inputURL = scanner.nextLine();

            try {
                myReadFile = new FileReader(inputURL);
                break;
            } catch (IOException e) {
                System.out.println("Error. No se puede abrir el archivo de origen");
            }
        } while (true);

        do {
            System.out.print("Introduzca el nombre del fichero de destino: ");
            String inputURL = scanner.nextLine();

            try {
                myWriteFile = new FileWriter(inputURL);
                break;
            } catch (IOException e) {
                System.out.println("Error. No se puede abrir el archivo de destino");
            }
        } while (true);

        int tmpAscii;
        do {
            try {
                tmpAscii = myReadFile.read();
                if (tmpAscii == -1) break;
                myWriteFile.write(tmpAscii);
            } catch (IOException e) {
                System.out.println("Error. No se ha podido copiar un caracter. Se va a terminar el programa");
                break;
            }
        } while (true);
        System.out.println("Se ha copiado el archivo satisfactoriamente");

        try {
            myReadFile.close();
            myWriteFile.close();
        } catch (IOException e) {
            System.out.println("Error al cerrar los archivos");
        }
    }
}