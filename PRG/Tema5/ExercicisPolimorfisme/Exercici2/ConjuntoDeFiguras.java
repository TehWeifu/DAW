import java.util.Arrays;

// Definition of class ConjuntoDeFiguras
// Stores an arrays of Figuras objects and manipulates it
public class ConjuntoDeFiguras {
    private Figura[] arrFiguras;

    // Constructor that receives no parameters and initializes the array with a fixed size of 10
    public ConjuntoDeFiguras() {
        arrFiguras = new Figura[10];
    }

    // Method to add a new Firgura object to the array
    // Loops through the array checking if there is an empty reference to assign
    // If no reference is available, creates a new array with the values of the current array and bigger size
    public void anade(Figura fig) {
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

    // Method to sum all the areas of the figures
    // Loops through every element and checks to which class references the object
    // Then downcast that reference to its appropriate class and calculates the area by calling its method
    public double areaTotal() {
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


    // Method to print every Figura object stored
    // Loops through every element calling to its toString method by using polymorphism
    public void imprimeTodo() {
        for (Figura figura : arrFiguras) {
            if (figura != null) {
                System.out.println(figura);
            }
        }
    }
}
