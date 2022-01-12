import java.util.Arrays;

public class ConjuntoDeFiguras {
    Figura[] arrFiguras;

    ConjuntoDeFiguras() {
        arrFiguras = new Figura[10];
    }

    void anade(Figura fig) {
        for (int i = 0; i < arrFiguras.length; i++) {
            if (arrFiguras[i] == null) {
                arrFiguras[i] = fig;
                return;
            }
        }

        int tmpIndex = arrFiguras.length;
        arrFiguras = Arrays.copyOf(arrFiguras, arrFiguras.length + 5);
        arrFiguras[tmpIndex] = fig;
    }

    double areaTotal() {
        double sumOfAreas = 0;

        for (Figura figura : arrFiguras) {
            if (figura instanceof Rectangulo) {
                Rectangulo tmpRect = (Rectangulo) figura;
                sumOfAreas += (tmpRect.dimeLados()[0] * tmpRect.dimeLados()[1]);
            }

            if (figura instanceof Circulo) {
                Circulo tmpCirculo = (Circulo) figura;
                sumOfAreas += (Math.PI * Math.pow(tmpCirculo.dimeRadio(), 2));
            }
        }

        return sumOfAreas;
    }

    void imprimeTodo() {
        for (Figura figura : arrFiguras) {
            if (figura != null) {
                System.out.println(figura);

            }
        }
    }
}