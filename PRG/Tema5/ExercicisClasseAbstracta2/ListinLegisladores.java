import java.util.ArrayList;
import java.util.List;

public class ListinLegisladores {
    List<Legislador> legisladores;

    public ListinLegisladores() {
        legisladores = new ArrayList<>();
    }

    public void printLegisladores() {
        for (Legislador legislador : legisladores) {
            System.out.println(legislador);
        }
    }

    public void addLegislador(final Legislador element) {
        legisladores.add(element);
    }
}
