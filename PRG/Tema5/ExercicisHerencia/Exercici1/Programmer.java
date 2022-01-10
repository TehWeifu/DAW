public class Programmer extends Employee {
    private int codeLinesPerHour;
    private String mainLanguage;

    public Programmer() {
        this(null, null, 0, false, 0.0, 0, null);
    }

    public Programmer(final String fullName, final String id_employee, final int age, final boolean married, final double salary, final int codeLinesPerHour, final String mainLanguage) {
        super(fullName, id_employee, age, married, salary);
        this.codeLinesPerHour = Math.max(codeLinesPerHour, 0);
        this.mainLanguage = mainLanguage;
    }
}
