// Exercici 2: Realitza les següents figures: (Utilitza bucles while).

public class Exercici2 {
    public static void main(String[] args) {

        // Una línia composta per asteriscs (*) de 10 de llarg. Cada impressió sols portarà un caràcter.
        // **********
        byte i1 = 0;
        final byte SIZE1 = 10;

        while (i1 < SIZE1) {
            System.out.print('*');
            i1++;
        }
        System.out.println();
        System.out.println();


        // Una línia composta per uns (1) i zeros (0) intercalats de 20 de llarg. Cada impressió sols portarà un caràcter.
        // 10101010101010101010
        byte i2 = 1;
        final byte SIZE2 = 20;

        while (i2 <= SIZE2) {
            System.out.print(i2 % 2);
            i2++;
        }
        System.out.println();
        System.out.println();


        // Una línia composta per seqüències de quatre uns (1) i un zero (0) successius de 25 de llarg.
        // 1111011110111101111011110
        byte i3 = 1;
        final byte SIZE3 = 25;

        while (i3 <= SIZE3) {
            System.out.print(Math.min(1, (i3 % 5)));
            i3++;
        }
        System.out.println();
        System.out.println();


        // un quadre compost per signes més (+) de 5 files i 10 columnes
        // ++++++++++
        // ++++++++++
        // ++++++++++
        // ++++++++++
        // ++++++++++
        byte i4 = 0;
        byte j4 = 0;
        final byte ROWS4 = 5;
        final byte COLUMNS4 = 10;

        while (i4 < ROWS4) {
            j4 = 0;

            while (j4 < COLUMNS4) {
                System.out.print('+');
                j4++;
            }

            System.out.println();
            i4++;
        }
        System.out.println();


        // un quadre compost per signes igual (=) alternats amb signes menys (-) de 6 files i 10 columnes
        // =-=-=-=-=-
        // =-=-=-=-=-
        // =-=-=-=-=-
        // =-=-=-=-=-
        // =-=-=-=-=-
        // =-=-=-=-=-
        byte i5 = 0;
        byte j5 = 0;
        final byte ROWS5 = 6;
        final byte COLUMNS5 = 10;

        while (i5 < ROWS5) {
            j5 = 0;

            while (j5 < COLUMNS5) {
                System.out.print(j5 % 2 == 0 ? '=' : '-');
                j5++;
            }

            System.out.println();
            i5++;
        }
        System.out.println();


        // un triangle isòsceles de 10 de altura, compost per lletres 'o'
        // o
        // oo
        // ooo
        // oooo
        // ooooo
        // oooooo
        // ooooooo
        // oooooooo
        // ooooooooo
        // oooooooooo
        byte i6 = 0;
        byte j6 = 0;
        final byte HEIGHT6 = 10;

        while (i6 < HEIGHT6) {
            j6 = 0;

            while (j6 <= i6) {
                System.out.print('o');
                j6++;
            }

            System.out.println();
            i6++;
        }
        System.out.println();


        // el mateix triangle, però invertit i composto por lletres 'o'
        // oooooooooo
        // ooooooooo
        // oooooooo
        // ooooooo
        // oooooo
        // ooooo
        // oooo
        // ooo
        // oo
        // o
        byte i7 = 0;
        byte j7 = 0;
        final byte HEIGHT7 = 10;

        while (i7 < HEIGHT7) {
            j7 = (byte) (HEIGHT7 - i7);

            while (j7 > 0) {
                System.out.print('o');
                j7--;
            }

            System.out.println();
            i7++;
        }
        System.out.println();


        // un rectangle buit compost per coixinets '#' de costats 10x5
        // ##########
        // #        #
        // #        #
        // #        #
        // ##########
        byte i8 = 1;
        byte j8 = 1;
        final byte ROWS8 = 5;
        final byte COLUMNS8 = 10;

        while (i8 <= ROWS8) {
            j8 = 1;

            while (j8 <= COLUMNS8) {
                System.out.print(i8 == 1 || i8 == ROWS8  || j8 == 1 || j8 == COLUMNS8  ? '#' : ' ');
                j8++;
            }

            System.out.println();
            i8++;
        }
    }
}
