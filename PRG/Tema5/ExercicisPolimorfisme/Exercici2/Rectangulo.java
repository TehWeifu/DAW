import java.awt.Color;

public class Rectangulo extends Figura {

    private double[] lados = new double[2];

    Rectangulo(double[] lados) {
        estableceLados(lados);
    }

    Rectangulo(double[] lados, Color color) {
        super(color);
        estableceLados(lados);
    }

    Rectangulo(double[] lados, Color color, int[] posicion) {
        super(color, posicion);
        estableceLados(lados);
    }

    public void estableceLados(double[] lados) {
        this.lados[0] = lados[0];
        this.lados[1] = lados[1];
    }

    public double[] dimeLados() {
        return lados;
    }

    @Override
    public double perimetro() {
        return 2d * lados[0] + 2d * lados[1];
    }

    @Override
    public String toString() {
        return String.format("%s%n%s: %.2f%n%s: %.2f%n%s: %.2f",
                super.toString(),
                "Base", dimeLados()[0],
                "Altura", dimeLados()[1],
                "Area Total", dimeLados()[1] * dimeLados()[0]);
    }
}
