package Course;

public class Subject {
    private String name;
    private int grade;

    public Subject(final String name, final int grade) {
        this.name = name;
        this.grade = Math.max(grade, 0);
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public Subject setGrade(int grade) {
        this.grade = grade;
        return this;
    }

    public String gradeResult() {
        return (grade >= 60 ? "Aprobado" : "Suspendido");
    }
}
