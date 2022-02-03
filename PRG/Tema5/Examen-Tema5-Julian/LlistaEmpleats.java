import java.util.LinkedList;
import java.util.List;

public class LlistaEmpleats {
    private final List<Empleat> arrOfEmpleats;

    public LlistaEmpleats() {
        arrOfEmpleats = new LinkedList<>();
    }

    public boolean addEmpleat(final Empleat emp) {
        int employeeIdx = findEmployeByID(emp.getDni());
        if (employeeIdx != -1) {
            return false;
        }
        arrOfEmpleats.add(emp);
        return true;
    }

    public boolean removeEmpleatPerDni(final String dni) {
        int employeeIdx = findEmployeByID(dni);
        if (employeeIdx != -1) {
            arrOfEmpleats.remove(employeeIdx);
            return true;
        }
        return false;
    }

    private int findEmployeByID(final String id) {
        for (int i = 0; i < arrOfEmpleats.size(); i++) {
            if (arrOfEmpleats.get(i).getDni().equals(id)) return i;
        }
        return -1;
    }

    @Override
    public String toString() {
        if (arrOfEmpleats.isEmpty()) return "No hay empleados :(";

        StringBuilder tmpBuilder = new StringBuilder("\nLista de Empleados\n");

        for (Empleat empleat : arrOfEmpleats) {
            tmpBuilder.append(String.format("%s%n%n", empleat));
        }

        return tmpBuilder.toString();
    }
}
