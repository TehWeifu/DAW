//        Exercici 5. Usant bucles com única estructura de control i una única sentència d'impressió
//        per al caràcter o, escriu un programa en Java que mostri la següent eixida:
//                ooooo
//                 ooo
//                  o

public  class Exercici5 {
    public static void main(String[] args) {
        // constants declaration
        final byte LENGTH = 5;
        final byte HEIGHT = 3;
        final char OUT_CHAR = 'o';

        // variable declarations for spaces and characters counter
        byte numOfChars = LENGTH;
        byte numOfSpaces = 0;

        // Outer loop to output the rows
        for (int i = 0; i < HEIGHT; i++) {

            // Inner loop to output the spaces before the chars
            for (int j = 0; j < numOfSpaces; j++) {
                System.out.print(' ');
            }

            // Inner loop to output the chars
            for (int j = 0; j < numOfChars; j++) {
                System.out.print(OUT_CHAR);
            }

            // Jumps to the next line
            System.out.println();

            // every line has 2 less characters and 1 more space in front of the characters
            numOfChars -= 2;
            numOfSpaces++;
        }
    }
}
