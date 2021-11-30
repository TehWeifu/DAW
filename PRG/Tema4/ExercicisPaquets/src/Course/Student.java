package Course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Class that represent a student which has a name, age and a list of subjects
public class Student {
    private String name;
    private int age;
    private List<Subject> subjects;

    // Two-parameters constructor that delegates on main constructor with an empty list of subjects
    public Student(String name, int age) {
        this(name, age, new ArrayList<>());
    }

    // Main-constructor that initializes every property with its parameters
    public Student(String name, int age, List<Subject> subjects) {
        this.name = name;
        this.age = age;
        this.subjects = new ArrayList<>(subjects);
    }

    // Setters and getters for each property
    // Setters return a self-reference to enable chaining
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

    // Returns an unmodifiable list to avoid breaking encapsulation by returning a pointer
    public List<Subject> getSubjects() {
        return Collections.unmodifiableList(subjects);
    }

    public Student setSubjects(List<Subject> subjects) {
        this.subjects = new ArrayList<>(subjects);
        return this;
    }

    public void addGrade(final String str, final int num) {
        for (Subject subject : subjects) {
            if (subject.getName().equals(str)) {
                return;
            }
        }
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
                System.out.printf("El alumno %s tiene un %d en %s%n", this.name, subject.getGrade(), subject.getName());
            }
        }
    }

    public int averageOfGrades() {
        int sum = 0;
        for (Subject subject : subjects) {
            sum += subject.getGrade();
        }
        return sum / subjects.size();
    }
}
