import java.security.SecureRandom;
import java.util.Scanner;

public class Exercici1 {

    // Constants for random number generators and scanner
    private static final SecureRandom numGen = new SecureRandom();
    private static final Scanner sc = new Scanner(System.in);

    // Random amount of employees
    private static final int RND_LENGTH = 5 + (numGen.nextInt(16));

    // Auto-incrementable variable to keep track of employees ID
    private static int autoIncId = 1;

    // Arrays for employee data
    private static final int[] employeeNum = new int[RND_LENGTH];
    private static final int[] employeeSex = new int[RND_LENGTH];
    private static final int[] employeeStatus = new int[RND_LENGTH];
    private static final double[] employeeSalary = new double[RND_LENGTH];

    // Fills an array with an auto-incrementable value, the number will never be duplicated
    public static void fillInc(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = autoIncId++;
        }
    }

    // Fills an array with random numbers between
    public static void fillRnd(int[] arr, int infBound, int supBound) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 + numGen.nextInt(supBound - infBound);
        }
    }

    // Fills an array with a random number between 500 and 3000
    public static void fillSalary(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 500 + (numGen.nextInt(250000) / 100.0);
        }
    }

    // Prints the main menu, prompts user to input an option and returns it
    public static int mainMenu() {
        int option;
        System.out.println("Menu: ");
        System.out.println("1. Percentatge d'homes");
        System.out.println("2. Percentatge de dones");
        System.out.println("3. Percentatge d'homes que treballen i sou mitjà");
        System.out.println("4. Percentatge de dones que treballen i sou mitjà");
        System.out.println("5. Eixir");
        do {
            System.out.print("Introduïsca una opció: ");
            option = sc.nextInt();
        } while (option < 1 || option > 5);
        return option;
    }

    // Averages the occurrences of a sex. Returns a number between 0 and 1 
    public static double averageSex(final int sex) {
        int count = 0;
        for (int num : employeeSex) {
            if (num == sex) count++;
        }
        return (((double) count) / employeeSex.length);
    }

    // Prints the occurrences of a sex which status is working (1)
    // Calculates the average of salaries of such occurrences
    public static void averageAndSalary(final int sex) {
        int count = 0;
        double sumSalary = 0;

        for (int i = 0; i < employeeSex.length; i++) {
            if (employeeSex[i] == sex && employeeStatus[i] == 1) {
                count++;
                sumSalary += employeeSalary[i];
            }
        }

        System.out.printf("El percentatge %s que treballen es %.2f%%%n", (sex == 1 ? "d'homes" : "de dones"),
                ((double) count / employeeSex.length) * 100);
        System.out.printf("El sou mitja es %.2f$%n", sumSalary / count);
    }


    public static void main(String[] args) {
        
        // Initilizes the employee Arrays
        fillInc(employeeNum);
        fillRnd(employeeSex, 1, 3);
        fillRnd(employeeStatus, 1, 3);
        fillSalary(employeeSalary);

        System.out.println("Taula de treballadors");
        System.out.printf("%-5s%-10s%-15s%s%n", "Id", "Sexe", "Treballant", "Sou");
        for (int i = 0; i < employeeStatus.length; i++) {
            System.out.printf("%-5d%-10s%-15s%.2f$%n", employeeNum[i], (employeeSex[i] == 1 ? "Home" : "Dona"),
                    (employeeStatus[i] == 1 ? "Si" : "No"), employeeSalary[i]);
        }
        System.out.println();

        int menuOption;
        do {
            menuOption = mainMenu();
            switch (menuOption) {
                case 1:
                    System.out.printf("El percentatge d'homes es %.2f%%%n", averageSex(1) * 100);
                    break;
                case 2:
                    System.out.printf("El percentatge de dones es %.2f%%%n", averageSex(2) * 100);
                    break;
                case 3:
                    averageAndSalary(1);
                    break;
                case 4:
                    averageAndSalary(2);
                    break;
            }
            System.out.println();
        } while (menuOption != 5);
    }
}

