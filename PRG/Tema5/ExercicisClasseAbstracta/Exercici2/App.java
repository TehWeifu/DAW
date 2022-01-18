public class App {
    public static void main(String[] arg) {
        ConjuntAnimals miConjuntDeAnimals = new ConjuntAnimals();

        miConjuntDeAnimals.addAnimal(new Perro("simon"));
        miConjuntDeAnimals.addAnimal(new Perro("paco"));
        miConjuntDeAnimals.addAnimal(new Perro("mimi"));

        miConjuntDeAnimals.printTypes();
    }
}
