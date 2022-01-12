import java.awt.Color;

public class Figura {

    private Color colorFigura;
    private int[] posicion = new int[2];

    public Figura() {
        estableceColor(Color.black);
        posicion[0] = 0;
        posicion[1] = 0;
    }

    public Figura(Color color) {
        estableceColor(color);
    }

    public Figura(Color color, int[] posicion) {
        estableceColor(color);
        estableceCentro(posicion);
    }

    public void estableceColor(Color color) {
        colorFigura = color;
    }

    public Color dimeColor() {
        return colorFigura;
    }

    public void estableceCentro(int[] posicion) {
        this.posicion[0] = posicion[0];
        this.posicion[1] = posicion[1];
    }

    public int[] dimeCentro() {
        return posicion;
    }

    public double perimetro() {
        return 0d;
    }

    @Override
    public String toString() {
        return String.format("%s: %s",
                "Color", dimeColor());
    }
}