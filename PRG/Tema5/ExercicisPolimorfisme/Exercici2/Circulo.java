import java.awt.Color;

public class Circulo extends Figura {

    private double radio;

    Circulo(double radio) {
        estableceRadio(radio);
    }

    Circulo(double radio, Color color) {
        super(color);
        estableceRadio(radio);
    }

    Circulo(double radio, Color color, int[] posicion) {
        super(color, posicion);
        estableceRadio(radio);
    }

    public void estableceRadio(double Radio) {
        this.radio = Radio;
    }

    public double dimeRadio() {
        return radio;
    }

    @Override
    public double perimetro() {
        return 2.0d * Math.PI * radio;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s: %.2f%n%s: %.2f",
                super.toString(),
                "Radio", dimeRadio(),
                "Area Total", (Math.PI * Math.pow(dimeRadio(), 2)));
    }
}