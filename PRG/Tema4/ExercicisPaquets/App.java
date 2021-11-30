import Course.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final List<Student> students = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    private static int mainMeu() {
        int inputOption;

        System.out.println("╔════════════ MENU ════════════╗");
        System.out.println("║ 1. Agregar un alumno         ║");
        System.out.println("║ 2. Generar coches            ║");
        System.out.println("║ 3. Eliminar un coche         ║");
        System.out.println("║ 4. Contar coches             ║");
        System.out.println("║ 5. Mostrar coches            ║");
        System.out.println("║ 6. Mostrar coches por marca  ║");
        System.out.println("║ 7. Salir                     ║");
        System.out.println("╚══════════════════════════════╝");

        do {
            System.out.print("Introduzca una opción");
            inputOption = Integer.parseInt(scanner.nextLine());
        } while (inputOption < 1 || inputOption > 7); // TODO: Change this

        return inputOption;
    }

    private static void addStudent() {
        System.out.print("Introduzca el nombre del nuevo alumno: ");
        String inputName = scanner.nextLine();
        System.out.print("Introduzca el nombre del nuevo alumno: ");
        int inputAge = Integer.parseInt(scanner.nextLine());

        students.add(new Student(inputName, inputAge));
    }

    private static void inputAllGrades() {
        for (Student student : students) {
            for (Subject subject : student.getSubjects()) {
                System.out.printf("Introduzca la nota de %s en %s: ", student.getName(), subject.getName());
                int inputGrade = Integer.parseInt(scanner.nextLine());
            }
        }
    }

    private static void printPassedSubject() {
        System.out.print("Introduzca el nombre del alumno: ");
        String inputName = scanner.nextLine();
        System.out.print("Introduzca el nombre de la asignatura: ");
        String inputSubject = scanner.nextLine();

        for (Student student : students) {
            if (inputName.equals(student.getName())) {
                System.out.printf("El alumno %s ha %s %s %n", inputName, student.);
            }
        }

    }

    private static void printAverage() {
        System.out.print("Introduzca el nombre del alumno: ");
        String inputStr = scanner.nextLine();

        for (Student student : students) {
            if (inputStr.equals(student.getName())) {
                System.out.printf("La media de %s es %.2f%n", inputStr, student.averageOfGrades());
            }
        }
    }

    public static void main(String[] args) {

    }

}
