//        Exercici 6. Reestructura el següent fragment de codi per a evitar l’ús de salts
//        incondicionals.
//        (Salts incondicionals: utilizació de la sentencia break).
//                while (i < n) {
//                j=Integer.parseInt(leer.readLine());
//                if (j==-1) break;
//                i++;
//                }

import java.util.Scanner;

public class Exercici6 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int i = 0;
        int n = 5;
        int j = 0;

        while ((i < n) && (j != -1)) {
            j = Integer.parseInt(leer.nextLine());
            i++;
        }
    }
}
