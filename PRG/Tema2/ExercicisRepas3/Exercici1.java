//    Exercicis repàs
//    Exercici 1. Donat el següent programa:
//
//        class Exercici {
//            public static void main (String [] args) {
//                double x,y;
//                x=15.0;
//                y=10.0;
//                int var1 =(int) ((x/4)+1);                // var 1 = 4
//                int var2 = (int) (y/4);                   // var 2 = 2
//                while (var1 > 0) {
//                    var1 = var1-1;                        // 3 2  1  0
//                    var2 = var2 * var1;                   // 6 12 12 0
//                    System.out.print(var2 + " ");         // 6 12 12 0
//                }
//            }
//        }
//
//    a) Indicar què imprimirà;
//            - El programa imprimira "6 12 12 0 "

//    b) Escriu un bucle for que done el mateix resultat

public class Exercici1 {
    public static void main(String[] args) {
        double x, y;
        x = 15.0;
        y = 10.0;
        int var1 = (int) ((x / 4) + 1);
        int var2 = (int) (y / 4);

        for (var1--, var2 *= var1; var1 >= 0; var1--, var2 *= var1) {
            System.out.print(var2 + " ");
        }
    }
}


