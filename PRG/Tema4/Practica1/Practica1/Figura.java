import java.awt.Color;

public class Figura {
    //atributos de la clase
    private Color ColorFigura;
    private int[] Posicion = new int[2];

    //métodos de la clase
    public void EstableceColor(Color color) {
        ColorFigura = color;
    }

    public Color DimeColor() {
        return ColorFigura;
    }

    public void EstableceCentro(int[] Posicion) {
        this.Posicion[0] = Posicion[0];
        this.Posicion[1] = Posicion[1];
    }

    public int[] DimeCentro() {
        return Posicion;
    }
}
