public class Exercici2 {
    private static void printBook(final Llibre llibre, final String name) {
        System.out.println(name);
        System.out.println("Titol: " + llibre.getTitol());
        System.out.println("Autor: " + llibre.getAutor());
        System.out.println("Numero d'exemplars totals: " + llibre.getExemplars());
        System.out.println("Numero d'exemplars prestats: " + llibre.getPrestats());
        System.out.println();
    }

    public static void main(String[] args) {
        Llibre myLlibre = new Llibre();
        printBook(myLlibre, "myLlibre");

        myLlibre.setTitol("Teo va al Zoo");
        myLlibre.setAutor("Leonardo Da Vinci");
        myLlibre.setPrestats(123);
        myLlibre.setExemplars(123);
        printBook(myLlibre, "myLlibre");
    }
}
