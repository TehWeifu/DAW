import java.awt.*;
import java.util.Arrays;

public class Practica1 {
    // Method to output on console the contents of a Pajaro variable and its name
    public static void printPajaro(Pajaro pajaro, String name) {
        System.out.println(name);
        System.out.print("Edad: ");
        pajaro.printedad();
        System.out.print("Color: ");
        pajaro.printcolor();
        System.out.println();
    }

    // Method to output on console the contents of a Figura variable and its name
    public static void printFigura(Figura figura, String name) {
        System.out.println(name);
        System.out.println("Color: " + figura.DimeColor());
        System.out.println("Centro: " + Arrays.toString(figura.DimeCentro()));
        System.out.println();
    }

    public static void main(String[] args) {

        // Declares and initializes two Pajaro objects
        // Sets their color and age
        // Then displays it's content by calling the printPajaro method
        Pajaro pajaro1 = new Pajaro();
        Pajaro pajaro2 = new Pajaro();

        pajaro1.setedad(10);
        pajaro1.setcolor('a');

        pajaro2.setedad(-2);
        pajaro2.setcolor('$');

        printPajaro(pajaro1, "pajaro1");
        printPajaro(pajaro2, "pajaro2");


        // Declares and initializes two Figura objects
        // Sets their color and center
        // Then displays it's content by calling the printFigura method
        Figura figura1 = new Figura();
        Figura figura2 = new Figura();

        figura1.EstableceColor(Color.BLACK);
        figura1.EstableceCentro(new int[]{2, 5});

        figura2.EstableceColor(Color.CYAN);
        figura2.EstableceCentro(new int[]{-1, 0});

        printFigura(figura1, "figura1");
        printFigura(figura2, "figura2");
    }
}

