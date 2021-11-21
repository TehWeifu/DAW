public class Exercici2 {

    // Method that receives a "Llibre" object and the variable name to print its contents
    private static void printBook(final Llibre llibre, final String name) {
        System.out.println(name);
        System.out.println("Titol: " + llibre.getTitol());
        System.out.println("Autor: " + llibre.getAutor());
        System.out.println("Numero d'exemplars totals: " + llibre.getExemplars());
        System.out.println("Numero d'exemplars prestats: " + llibre.getPrestats());
        System.out.println();
    }

    public static void main(String[] args) {
        // Creates a "Llibre" object with a non-argument constructor, the prints its current state
        // Changes the state of the object and the prints it again
        Llibre myLlibre = new Llibre();
        printBook(myLlibre, "myLlibre");

        myLlibre.setTitol("Teo va al Zoo");
        myLlibre.setAutor("Leonardo Da Vinci");
        myLlibre.setPrestats(123);
        myLlibre.setExemplars(123);
        printBook(myLlibre, "myLlibre");
    }
}
