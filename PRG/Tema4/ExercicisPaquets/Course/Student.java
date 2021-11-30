package Course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {
    private String name;
    private int age;
    private final List<Subject> subjects;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;

        subjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }

    public List<Subject> getSubjects() {
        return Collections.unmodifiableList(subjects);
    }

    public void addGrade(final String str, final int num) {
        subjects.add(new Subject(str, num));
    }

    public void changeGrade(final String str, final int num) {
        for (Subject subject : subjects) {
            if (str.equals(subject.getName())) {
                subject.setGrade(num);
            }
        }
    }

    public void printGrade(final String str) {
        for (Subject subject : subjects) {
            if (str.equals(subject.getName())) {
                System.out.printf("El alumno %s tiene un %.2f en %s%n", this.name, subject.getGrade() / 100.0, subject.getName());
            }
        }
    }

    public double averageOfGrades() {
        int sum = 0;
        for (Subject subject : subjects) {
            sum += subject.getGrade();
        }
        return (sum / 100.0 / subjects.size());
    }
}
