public class Tangente {
    Double angulo;

    Tangente(double a) {
        angulo = a;
    }

    Double resul() throws MiError {
        if (angulo == Math.PI / 2.0)
            throw new MiError(1);
        if (angulo == 3.0 * Math.PI / 2.0)
            throw new MiError(2);
        return Math.tan(angulo);
    }
}
