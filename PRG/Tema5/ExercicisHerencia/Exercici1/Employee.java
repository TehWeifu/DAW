public class Employee {
    private String fullName;
    private String id_employee;
    private int age;
    private boolean married;
    private double salary;

    public Employee() {
        this(null, null, 0, false, 0.0);
    }

    public Employee(final String fullName, final String id_employee, final int age, final boolean married, final double salary) {
        this.fullName = fullName;
        this.id_employee = id_employee;
        this.age = (age >= 18 && age <= 45 ? age : 0);
        this.married = married;
        this.salary = Math.max(salary, 0.0);
    }

    public String getFullName() {
        return fullName;
    }

    public Employee setFullName(final String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getId_employee() {
        return id_employee;
    }

    public Employee setId_employee(final String id_employee) {
        this.id_employee = id_employee;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Employee setAge(final int age) {
        this.age = (age >= 18 && age <= 45 ? age : 0);
        return this;
    }

    public boolean isMarried() {
        return married;
    }

    public Employee setMarried(final boolean married) {
        this.married = married;
        return this;
    }

    public double getSalary() {
        return salary;
    }

    public Employee setSalary(final double salary) {
        this.salary = Math.max(salary, 0.0);
        return this;
    }

    public String employeeRank() {
        if (age == 0) return "Edat no valida";
        if (age < 22) return "Principiant";
        if (age < 36) return "Intermedi";
        return "Sénior";
    }

    public void salaryRise(final double percent) {
        this.salary += this.salary * percent;
    }

    public void printEmployee() {
        System.out.printf("%s%n%s: %s%n%s: %s%n%s: %d (%s)%n%s: %b%n%s: %.2f",
                "Empleat",
                "Codi", id_employee,
                "Nom Complet", fullName,
                "Edat", age, employeeRank(),
                "Casat", married,
                "Salari", salary);
    }
}
