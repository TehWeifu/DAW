import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        FileWriter myFile = null;

        try {
            myFile = new FileWriter("./dades.txt", true);
        } catch (IOException e) {
            System.out.println("No se ha podido crear o abrir el fichero :(");
        }

        if (myFile != null) {
            String inputStr;
            do {
                System.out.print("Introduzca el texto que desea guardar (\"FI\" para salir): ");
                inputStr = scanner.nextLine();
                if (inputStr.equals("FI")) break;

                try {
                    myFile.write(inputStr + System.lineSeparator());
                } catch (IOException e) {
                    System.out.println("Error al introducir el texto");
                }
            } while (true);

            try {
                myFile.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo");
            }
        }
    }
}
