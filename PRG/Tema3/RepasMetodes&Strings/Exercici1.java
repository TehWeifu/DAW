import java.util.Scanner;

public class Exercici1 {
    // Method to calculate the difference in minuts between 2 moments (hours + minutes)
    // Returns a positive number if the first moment is later than the second moment
    // Returns a negative number if the second moment is later than the first moment
    public static int diferenciaMin(int hora1, int minut1, int hora2, int minut2) {
        int res = 0;
        res += (hora1 - hora2) * 60;
        res += (minut1 - minut2);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompts user to input the values for two moments (hours & minutes)
        int inputHour1, inputHour2, inputMin1, inputMin2;
        System.out.print("Introduïsca la primera hora: ");
        inputHour1 = sc.nextInt();
        System.out.print("Introduïsca els primers minuts: ");
        inputMin1 = sc.nextInt();
        System.out.print("Introduïsca la segona hora: ");
        inputHour2 = sc.nextInt();
        System.out.print("Introduïsca els segons minuts: ");
        inputMin2 = sc.nextInt();

        System.out.println("La diferencia entre els dos moments es " + diferenciaMin(inputHour1, inputMin1, inputHour2, inputMin2) + " minuts.");
    }
}

