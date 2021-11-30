package Course;

// Class that represents a Subject that has a name and a number property
public class Subject {
    final private String name;
    private int grade;

    // Constructor that initializes every object with its parameters values
    // Validates the value to be between 0 and 100
    public Subject(final String name, final int grade) {
        this.name = name;
        this.grade = Math.min(Math.max(grade, 0), 100);
    }

    // Setters and getters for each property
    // Setters return a self-reference to enable chaining
    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    // Validates the value to be between 0 and 100
    public Subject setGrade(int grade) {
        this.grade = Math.min(Math.max(grade, 0), 100);
        return this;
    }

    public String gradeResult() {
        return (grade >= 60 ? "APROBADO" : "SUSPENDIDO");
    }
}
