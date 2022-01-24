package Ciphers;

import java.util.Random;

// Class that implements the Caesar algorithm, encoding and decoding messages
public class Caesar extends SymmetricCipher {
    private static final Random random = new Random();

    public static final String description = """
            Cifrado por sustitución en el que una letra en el texto original es reemplazada por otra letra que se encuentra
            un número fijo de posiciones más adelante en el alfabeto.
            Para más información → https://en.wikipedia.org/wiki/Caesar_cipher""\";
            """;

    // One-parameter constructor that delegates on the main constructor choosing a random key
    public Caesar(final String message) {
        this(message, random.nextInt(26));
    }

    // Main constructor that initializes the message and the key by validating it
    public Caesar(final String message, final int key) {
        super(message, String.valueOf(key % 26));
    }

    // Method to encode a message based on the key, moving each character by key positions
    // Return the encoded message
    public String encode() {
        StringBuilder res = new StringBuilder();
        final int tmpKey = Integer.parseInt(getKey());

        for (int i = 0; i < getMessage().length(); i++) {
            res.append((char) (getMessage().charAt(i) + tmpKey));
        }

        return res.toString();
    }

    // Method to decode a message based on the key, moving each character by key positions backwards
    // Return the original message
    public String decode() {
        StringBuilder res = new StringBuilder();
        final int tmpKey = Integer.parseInt(getKey());

        for (int i = 0; i < getMessage().length(); i++) {
            res.append((char) (getMessage().charAt(i) - tmpKey));
        }

        return res.toString();
    }

    @Override
    public String toString() {
        return String.format("%s%n%s%n",
                "Cifrado César",
                super.toString());
    }
}
