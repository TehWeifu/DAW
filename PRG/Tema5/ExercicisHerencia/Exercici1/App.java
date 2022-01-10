public class App {
    public static void main(String[] args) {
        Programmer p1 = new Programmer("Flavio", "3456", 20, false, 1000, 123, "Visual Basic");
        p1.setFullName("Pepe");
        p1.setSalary(1000);
        p1.salaryRise(0.25);
        p1.printEmployee();
    }
}
