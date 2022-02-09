import java.io.IOException;

public class App {
    public static char leer() throws IOException {
        return (char) System.in.read();
    }

    public static void main(String[] args) {
        try {
            char car = leer();
            System.out.println("Caracter: " + car);
        } catch (IOException e) {
            System.out.println("Error de entrada de datos");
        }
    }
}

// se lee el primer byte introducido y se muestra por pantalla el carácter al que representa
