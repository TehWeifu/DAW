public class Employee {
    private static int auto_inc = 1;

    private final int id;
    private String name;
    private double salary;

    public Employee(final String name, final double salary) throws IllegalArgumentException {
        if (salary < 0) throw new IllegalArgumentException("Un empleado no puede tener un sueldo negativo");

        this.name = name;
        this.salary = salary;

        this.id = auto_inc++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employee setName(final String name) {
        this.name = name;
        return this;
    }

    public double getSalary() {
        return salary;
    }

    public Employee setSalary(final double salary) throws IllegalArgumentException {
        if (salary < 0) throw new IllegalArgumentException("Un empleado no puede tener un sueldo negativo");

        this.salary = salary;
        return this;
    }
}
