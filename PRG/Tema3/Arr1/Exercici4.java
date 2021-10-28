public class Exercici4 {
    public static void main(String[] args) {
        
        // Constant declaration for the number of arguments to evaluate
        final byte NUM_ARGS = 4;

        // First checks if there is at least as many arguments as we want to read
        // If so reads arguments 1 by 1, outputting it to the console
        // If not outputs a message saying so.
        if (args.length >= NUM_ARGS) {
            for (int i = 0; i < NUM_ARGS; i++) {
                System.out.println("El argument " + (i + 1) + " es " + args[i]);
            }
        } else {
            System.out.println("No se han introduït al menys 4 arguments.");
        }
    }
}

