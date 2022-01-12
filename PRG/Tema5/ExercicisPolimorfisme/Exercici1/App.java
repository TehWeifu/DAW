public class App {
    public static void main(String[] args) {
        adoptaAnimal(new Armadillo());
        Object o = new Armadillo();
        Armadillo a1 = new Animal(); // Esta línea da error, ya que Animal NO ES un Armadillo. Es al revés
        Armadillo a2 = new Muflon(); // Esta línea da error, ya que Muflon NO ES un Armadillo. Son hermanos
    }

    private static void adoptaAnimal(Animal a) {
    }
}
