import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListinProfesores {
    public static final Random random = new Random();

    List<Profesor> profesores;

    public ListinProfesores() {
        profesores = new ArrayList<>();
    }

    public void addProfesor(Profesor profesor) {
        profesores.add(profesor);
    }

    public float importeTotalNominaProfesorado() {
        float totalSum = 0.0f;

        for (int i = 0; i < profesores.size(); i++) {
            totalSum += (1_000 + random.nextInt(500));
        }

        return totalSum;
    }

    public void imprimirListin() {
        for (Profesor profesor : profesores) {
            System.out.println(profesor);
        }
    }
}
