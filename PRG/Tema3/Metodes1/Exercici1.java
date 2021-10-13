import java.util.Scanner;

public class Exercici1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nro, pos, res;

        System.out.print("Introduïsca un numero sencer: ");
        nro = sc.nextInt();

        System.out.print("Introduïsca una posició: ");
        pos = sc.nextInt();

        if (esPar(nro)) {
            System.out.println("El numero " + nro + " es parell.");
        } else {
            System.out.println("El numero " + nro + " es imparell.");
        }

        res = obtenerImpar(pos);
        System.out.println("El " + pos + "º numero imparell es " + res + ".");
    }

    public static boolean esPar(int num) {
        if (num % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int obtenerImpar(int po) {
        int impar;

        impar = (po * 2) - 1;

        return impar;
    }
}

