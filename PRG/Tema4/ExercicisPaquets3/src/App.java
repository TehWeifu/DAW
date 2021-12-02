import Space.Cube;
import Space.Cylinder;
import Space.Sphere;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {
    // static scanner for I/O operations across the class
    public static final Scanner scanner = new Scanner(System.in);

    // Containers for each type of Figure
    public static final List<Cube> cubes = new ArrayList<>();
    public static final List<Cylinder> cylinders = new ArrayList<>();
    public static final List<Sphere> spheres = new ArrayList<>();

    private static int mainMenu() {
        int inputOption;

        System.out.println("╔═════════════════ MENU ════════════════╗");
        System.out.println("║ 1. Crear cubo                         ║");
        System.out.println("║ 2. Crear esfera                       ║");
        System.out.println("║ 3. Crear cilindro                     ║");
        System.out.println("║ 4. Mostrar areas                      ║");
        System.out.println("║ 5. Mostrar objetos y características  ║");
        System.out.println("║ 6. Generar figuras aleatorias         ║");
        System.out.println("║ 7. Salir                              ║");
        System.out.println("╚═══════════════════════════════════════╝");

        do {
            System.out.print("Introduzca una opción: ");
            inputOption = Integer.parseInt(scanner.nextLine());
        } while (inputOption < 1 || inputOption > 7);
        return inputOption;
    }

    private static void addCube() {
        System.out.print("Introduzca el lado del cubo: ");
        double inputSide = Double.parseDouble(scanner.nextLine());

        cubes.add(new Cube(inputSide));
    }

    private static void addSphere() {
        System.out.print("Introduzca el radio de la esfera: ");
        double inputRadius = Double.parseDouble(scanner.nextLine());

        spheres.add(new Sphere(inputRadius));
    }

    private static void addCylinder() {
        System.out.print("Introduzca el radio del cilindro: ");
        double inputRadius = Double.parseDouble(scanner.nextLine());
        System.out.print("Introduzca la altura del cilindro: ");
        double inputSide = Double.parseDouble(scanner.nextLine());

        cylinders.add(new Cylinder(inputRadius, inputSide));
    }

    private static void printShapeArea() {
        int menuOption;

        do {
            menuOption = shapeMenu();

            switch (menuOption) {
                case 1:
                    printAreaCubes();
                    break;
                case 2:
                    printAreaSpheres();
                    break;
                case 3:
                    printAreaCylinders();
                    break;
            }
            System.out.println();
        } while (menuOption != 4);
    }

    private static int shapeMenu() {
        int inputOption;

        System.out.println("╔════════════ AREAS ════════════╗");
        System.out.println("║ 1. Area cubos                 ║");
        System.out.println("║ 2. Area esferas               ║");
        System.out.println("║ 3. Area cilindros             ║");
        System.out.println("║ 4. Volver al menu principal   ║");
        System.out.println("╚═══════════════════════════════╝");

        do {
            System.out.print("Introduzca una opción: ");
            inputOption = Integer.parseInt(scanner.nextLine());
        } while (inputOption < 1 || inputOption > 4);

        return inputOption;
    }

    private static void printAreaCubes() {
        if (cubes.isEmpty()) {
            System.out.println("No se han creado cubos :(");
        } else {
            for (int i = 0; i < cubes.size(); i++) {
                System.out.printf("El area del cubo %d es %,.2f%n", i + 1, cubes.get(i).getArea());
            }
        }
    }

    private static void printAreaSpheres() {
        if (cubes.isEmpty()) {
            System.out.println("No se han creado esferas :(");
        } else {
            for (int i = 0; i < spheres.size(); i++) {
                System.out.printf("El area de la esfera %d es %,.2f%n", i + 1, spheres.get(i).getArea());
            }
        }
    }

    private static void printAreaCylinders() {
        if (cubes.isEmpty()) {
            System.out.println("No se han creado cilindros :(");
        } else {
            for (int i = 0; i < cylinders.size(); i++) {
                System.out.printf("El area del cilindro %d es %,.2f%n", i + 1, cylinders.get(i).getArea());
            }
        }
    }

    private static void printAll() {
        if (cubes.isEmpty() && spheres.isEmpty() && cylinders.isEmpty()) {
            System.out.println("No se ha creado ninguna figura :(");
            return;
        }

        if (cubes.isEmpty()) {
            System.out.println("No se han creado cubos :(");
        } else {
            for (Cube cube : cubes) {
                System.out.println(cube);
            }
        }
        System.out.println();

        if (spheres.isEmpty()) {
            System.out.println("No se han creado esferas :(");
        } else {
            for (Sphere sphere : spheres) {
                System.out.println(sphere);
            }
        }
        System.out.println();

        if (cylinders.isEmpty()) {
            System.out.println("No se han creado cilindros :(");
        } else {
            for (Cylinder cylinder : cylinders) {
                System.out.println(cylinder);
            }
        }
        System.out.println();
    }

    private static void generateRndFigures() {
        final Random random = new Random();

        for (int i = 0; i < 1 + random.nextInt(10); i++) {
            cubes.add(new Cube(random.nextInt(1_000)));
        }

        for (int i = 0; i < 1 + random.nextInt(10); i++) {
            spheres.add(new Sphere(random.nextInt(1_000)));
        }

        for (int i = 0; i < 1 + random.nextInt(10); i++) {
            cylinders.add(new Cylinder(random.nextInt(1_000), random.nextInt(1_000)));
        }
    }

    public static void main(String[] args) {
        int menuOption;
        do {
            menuOption = mainMenu();
            switch (menuOption) {
                case 1:
                    addCube();
                    break;
                case 2:
                    addSphere();
                    break;
                case 3:
                    addCylinder();
                    break;
                case 4:
                    printShapeArea();
                    break;
                case 5:
                    printAll();
                    break;
                case 6:
                    generateRndFigures();
                    break;
            }
            System.out.println();
        } while (menuOption != 7);
    }
}
