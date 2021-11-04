import java.util.Arrays;
import java.util.Scanner;

public class TestJava {
    public static double smallest(double[] arr) {
        double min = Double.MAX_EXPONENT;

        for (double tmp : arr) {
            if (tmp < -290) return min;
            if (tmp < min) min = tmp;
        }
        return min;
    }

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        System.out.print("Introduïsca el numero de temperatures que vols introduir: ");
        final int INPUT_LENGTH = sc.nextInt();
        double[] tmpArr = new double[INPUT_LENGTH];
        Arrays.fill(tmpArr, -300);

        char menuOption = 'S';

        for (int i = 0; (i < tmpArr.length && menuOption == 'S'); i++) {

            double tmpInput;
            do {
                System.out.print("Introduïsca una temperatura: ");
                tmpInput = sc.nextDouble();
            } while (tmpInput < -273.15);

            tmpArr[i] = tmpInput;

            System.out.print("Vols introduir mes temperatures? (S/N): ");
            sc.nextLine();
            menuOption = sc.nextLine().charAt(0);
        }

        System.out.print("La temperatura mes baixa introduïda es " + smallest(tmpArr));
    }
}

