// Exercici 7. Realitza un programa utilitzant bucles que mostre la següent figura per
// pantalla.
//             ┌───────┐
//             │   *   │
//             │  * *  │
//             │ *   * │
//             │*     *│
//             │ *   * │
//             │  * *  │
//             │   *   │
//             └───────┘

public class  Exercici7 {
    public static void main(String[] args) {
        // constant declaration
        final char OUT_CHAR = '*';
        final byte SIZE = 7;

        // variable declaration to output spaces
        byte spacesBefore = SIZE / 2;
        byte spacesBetween = -1;

        // outer loop to output each row of the figure
        for (int i = 0; i < SIZE; i++) {

            // inner loop to output spaces before the first character
            for (int j = 0; j < spacesBefore; j++) {
                System.out.print(' ');
            }

            // Output of the first (or only) character
            System.out.print(OUT_CHAR);

            // inner loop to output the spaces between the first and last character. Then outputs the last character
            // if we are at the top or bottom it will be skipped since there is only one character
            if (spacesBetween > 0) {
                for (int j = 0; j < spacesBetween; j++) {
                    System.out.print(' ');
                }
                System.out.print(OUT_CHAR);
            }

            // Prints line jump to continue with the next row
            System.out.println();

            // variable increment/decrement depending if we hit the "apex"
            if (i < SIZE / 2) {
                spacesBefore--;
                spacesBetween += 2;
            } else {
                spacesBefore++;
                spacesBetween -= 2;
            }
        }
    }
}
