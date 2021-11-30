import Course.*;

import java.util.*;

public class App {
    private static final List<Student> students = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static int mainMeu() {
        int inputOption;

        System.out.println("╔════════════ MENU ════════════╗");
        System.out.println("║ 1. Agregar un alumno         ║");
        System.out.println("║ 2. Establecer todas la notas ║");
        System.out.println("║ 3. Imprimir los alumnos      ║");
        System.out.println("║ 4. Asignaturas cursadas      ║");
        System.out.println("║ 5. Mostrar nota              ║");
        System.out.println("║ 6. Asignatura aprobada       ║");
        System.out.println("║ 7. Media del alumno          ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ 8. Agregar asignatura        ║");
        System.out.println("║ 9. Cambiar nota              ║");
        System.out.println("║ 10. Generar alumnos          ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ 11. Salir                    ║");
        System.out.println("╚══════════════════════════════╝");

        do {
            System.out.print("Introduzca una opción: ");
            inputOption = Integer.parseInt(scanner.nextLine());
        } while (inputOption < 1 || inputOption > 11);

        return inputOption;
    }

    private static void addStudent() {
        System.out.print("Introduzca el nombre del nuevo alumno: ");
        String inputName = scanner.nextLine();
        System.out.print("Introduzca la edad del nuevo alumno: ");
        int inputAge = Integer.parseInt(scanner.nextLine());

        System.out.print("¿Desea introducir asignaturas? (y/n): ");
        String inputOption = scanner.nextLine();

        if (inputOption.equalsIgnoreCase("y")) {
            List<Subject> tmpSubjects = new ArrayList<>();
            do {
                System.out.print("Introduzca el nombre de la asignatura (\"exit\" para salir): ");
                inputOption = scanner.nextLine();

                if (!inputOption.equalsIgnoreCase("exit")) {
                    System.out.printf("Introduzca la nota de %s: ", inputOption);
                    int inputGrade = Integer.parseInt(scanner.nextLine());

                    tmpSubjects.add(new Subject(inputOption, inputGrade));
                }
            } while (!inputOption.equalsIgnoreCase("exit"));

            students.add(new Student(inputName, inputAge, tmpSubjects));
        } else {
            students.add(new Student(inputName, inputAge));
        }
    }

    private static void inputAllGrades() {

        for (Student student : students) {
            for (Subject subject : student.getSubjects()) {
                System.out.printf("Introduzca la nota de %s en %s: ", student.getName(), subject.getName());
                int inputGrade = Integer.parseInt(scanner.nextLine());

                student.changeGrade(subject.getName(), inputGrade);
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
                List<Subject> studentSubjects = student.getSubjects();
                for (Subject subject : studentSubjects) {
                    if (subject.getName().equals(inputSubject)) {
                        System.out.printf("El alumno %s ha %s %s%n", inputName, subject.gradeResult(), subject.getName());

                    }
                }
            }
        }

    }

    private static void printAllStudents() {
        for (Student student : students) {
            System.out.print(String.format("╔%-20s╗%n", "").replaceAll(" ", "═"));
            System.out.printf("║Alumno: %-12s║%n", student.getName());
            System.out.printf("║Edad: %-14d║%n", student.getAge());

            if (student.getSubjects().isEmpty()) {
                System.out.print(String.format("╚%-20s╝%n", "").replaceAll(" ", "═"));
            } else {

                System.out.print(String.format("╠%-20s╣%n", "").replaceAll(" ", "─"));
                for (Subject subject : student.getSubjects()) {
                    System.out.printf("│- %-18s│%n", String.format("%s: %d", subject.getName(), subject.getGrade()));
                }
                System.out.print(String.format("└%-20s┘%n", "").replaceAll(" ", "─"));
            }
        }
    }

    private static void printGrade() {
        System.out.print("Introduzca el nombre del alumno: ");
        String inputName = scanner.nextLine();
        System.out.print("Introduzca el nombre de la asignatura: ");
        String inputSubject = scanner.nextLine();

        for (Student student : students) {
            if (student.getName().equals(inputName)) {
                student.printGrade(inputSubject);
            }
        }
    }

    private static void printSubjects() {
        System.out.print("Introduzca el nombre del alumno: ");
        String inputName = scanner.nextLine();

        for (Student student : students) {
            if (student.getName().equals(inputName)) {

                System.out.printf("El alumno %s esta cursando ", student.getName());
                for (int i = 0; i < student.getSubjects().size() - 1; i++) {
                    System.out.print(student.getSubjects().get(i).getName() + ", ");
                }
                System.out.print(student.getSubjects().get(student.getSubjects().size() - 1).getName());
            }
        }

    }

    private static void printAverage() {
        System.out.print("Introduzca el nombre del alumno: ");
        String inputStr = scanner.nextLine();

        for (Student student : students) {
            if (inputStr.equals(student.getName())) {
                System.out.printf("La media de %s es %d%n", inputStr, student.averageOfGrades());
            }
        }
    }

    private static void addGrade() {
        System.out.print("Introduzca el nombre del alumno: ");
        String inputName = scanner.nextLine();

        for (Student student : students) {
            if (inputName.equals(student.getName())) {
                System.out.print("Introduzca el nombre de la asignatura: ");
                String inputSubject = scanner.nextLine();
                System.out.printf("Introduzca la nota de %s en %s: ", inputName, inputSubject);
                int inputGrade = Integer.parseInt(scanner.nextLine());

                student.addGrade(inputSubject, inputGrade);
            }
        }
    }

    private static void changeGrade() {
        System.out.print("Introduzca el nombre del alumno: ");
        String inputName = scanner.nextLine();

        for (Student student : students) {
            if (inputName.equals(student.getName())) {
                System.out.print("Introduzca el nombre de la asignatura: ");
                String inputSubject = scanner.nextLine();
                System.out.printf("Introduzca la nota de %s en %s: ", inputName, inputSubject);
                int inputGrade = Integer.parseInt(scanner.nextLine());

                student.changeGrade(inputSubject, inputGrade);
            }
        }
    }

    private static void generateRndStudents() {
        final String[] SUBJECTS_NAMES = {"PRG", "MARCAS", "ED", "BD", "SIST", "INGLÉS", "FOL"};

        System.out.print("Introduzca el numero de estudiantes: ");
        int inputNum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < inputNum; i++) {
            Student tmpStudent = new Student(generateRndName(), random.nextInt(101));
            for (int j = 0; j < 2 + random.nextInt(4); j++) {
                tmpStudent.addGrade(SUBJECTS_NAMES[random.nextInt(SUBJECTS_NAMES.length)], random.nextInt(101));
            }
            students.add(tmpStudent);
        }
    }

    private static String generateRndName() {
        String res = "";

        for (int i = 0; i < 5 + random.nextInt(6); i++) {
            res += (char) ('a' + random.nextInt(26));
        }

        return res;
    }


    public static void main(String[] args) {
        int menuOption;
        do {
            menuOption = mainMeu();

            switch (menuOption) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    inputAllGrades();
                    break;
                case 3:
                    printAllStudents();
                    break;
                case 4:
                    printSubjects();
                    break;
                case 5:
                    printGrade();
                    break;
                case 6:
                    printPassedSubject();
                    break;
                case 7:
                    printAverage();
                    break;
                case 8:
                    addGrade();
                    break;
                case 9:
                    changeGrade();
                    break;
                case 10:
                    generateRndStudents();
                    break;
            }
            System.out.println();
        } while (menuOption != 11);
    }
}
