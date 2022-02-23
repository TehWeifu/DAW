public class Company {
    private final Employee[] arrOfEmployees;
    private int currentEmployees;
    private String name;

    public Company(final String name, final int maxCapacity) throws IllegalArgumentException {
        if (maxCapacity < 1) throw new IllegalArgumentException("La empresa tiene que tener al menos un empleado");

        this.name = name;
        this.currentEmployees = 0;
        arrOfEmployees = new Employee[maxCapacity];
    }

    public String getName() {
        return name;
    }

    public Company setName(final String name) {
        this.name = name;
        return this;
    }

    public int getCurrentEmployees() {
        return currentEmployees;
    }

    public void addEmployee(final String name, final int salary) throws companyException {
        if (arrOfEmployees.length == currentEmployees) {
            throw new companyException("La empresa esta a su capacidad maxima");
        }

        for (int i = 0; i < arrOfEmployees.length; i++) {
            if (arrOfEmployees[i] == null) {
                arrOfEmployees[i] = new Employee(name, salary);
                currentEmployees++;
                return;
            }
        }
    }

    public void fireEmployee(final int id) throws companyException {
        final int empIdx = findEmployeeById(id);

        if (empIdx == -1) {
            throw new companyException(String.format("No existe ningún usuario con el id %d%n", id));
        }

        arrOfEmployees[empIdx] = null;
        currentEmployees--;
    }

    public String getName(final int id) throws companyException {
        final int empIdx = findEmployeeById(id);

        if (empIdx == -1) {
            throw new companyException(String.format("No existe ningún usuario con el id %d%n", id));
        }

        return arrOfEmployees[empIdx].getName();
    }


    public int findEmployeeById(final int id) {
        for (int i = 0; i < arrOfEmployees.length; i++) {
            if (arrOfEmployees[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
