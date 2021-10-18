import java.util.Scanner;

public class Exercici3 {
    
    // Method to print a day of the week based on a number
    public static void diaDelaSemana(int num) {
        switch (num) {
            case 1:
                System.out.println("Dilluns");
                break;
            case 2:
                System.out.println("Dimarts");
                break;
            case 3:
                System.out.println("Dimecres");
                break;
            case 4:
                System.out.println("Dijous");
                break;
            case 5:
                System.out.println("Divendres");
                break;
            case 6:
                System.out.println("Dissabte");
                break;
            case 7:
                System.out.println("Diumenge");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNum;

        // Prompts user to input a number and validates it
        do {
            System.out.print("Introduïsca un numero entre 1 i 7: ");
            inputNum = sc.nextInt();
        } while (inputNum < 1 || inputNum > 7);

        diaDelaSemana(inputNum);
    }
}

