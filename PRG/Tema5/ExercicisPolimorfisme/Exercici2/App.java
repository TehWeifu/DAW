import java.awt.Color;

public class App {
    public static void main(String[] args) {
        double[] lados = {3d, 4d};
        ConjuntoDeFiguras c = new ConjuntoDeFiguras();
        c.anade(new Rectangulo(lados, Color.green));
        c.anade(new Circulo(5, Color.red));
        c.imprimeTodo();
    }
}
