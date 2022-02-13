import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        FileReader myFile;

        do {
            System.out.print("Introduzca la direccion del fichero: ");
            String inputURL = scanner.nextLine();

            try {
                myFile = new FileReader(inputURL);
                break;
            } catch (IOException e) {
                System.out.println("Error. No se puede abrir el archivo");
            }
        } while (true);


        int tmpAscii;
        int charCount = -1;
        int wordCount = 1;
        int lineCount = 1;

        do {
            try {
                tmpAscii = myFile.read();
            } catch (IOException e) {
                System.out.println("Error de lectura. Se ha detenido la lectira del archivo. Excepcion : " + e.getMessage());
                break;
            }

            char tmpChar = (char) tmpAscii;

            charCount++;
            if (Character.isSpaceChar(tmpChar)) wordCount++;
            if (tmpChar == '\n') {
                wordCount++;
                lineCount++;
            }
        } while (tmpAscii != -1);

        try {
            myFile.close();
        } catch (IOException e) {
            System.out.println("Error. No se puede cerrar el archivo. Exeception: " + e.getMessage());
        }

        System.out.println("lineCount = " + lineCount);
        System.out.println("wordCount = " + wordCount);
        System.out.println("charCount = " + charCount);
    }
}