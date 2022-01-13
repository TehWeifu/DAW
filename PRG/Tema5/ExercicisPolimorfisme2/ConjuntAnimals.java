import java.util.ArrayList;
import java.util.List;

public class ConjuntAnimals {
    private final List<Animal> arrAnimals;

    public ConjuntAnimals() {
        arrAnimals = new ArrayList<>();
    }

    public void addAnimal(final Animal animal) {
        arrAnimals.add(animal);
    }

    public void printTypes() {
        for (Animal animal : arrAnimals) {
            animal.tipoAnimal();
        }
    }
}
