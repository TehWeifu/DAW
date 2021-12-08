package Application.Ciphers;

import java.util.Random;

// Class that implements the Caesar algorithm, encoding and decoding messages
public class Caesar {
    private static final Random random = new Random();

    public static final String description = """
            Cifrado por sustitución en el que una letra en el texto original es reemplazada por otra letra que se encuentra
            un número fijo de posiciones más adelante en el alfabeto.
            Para más información → https://en.wikipedia.org/wiki/Caesar_cipher""\";
            """;

    private String message;
    private int key;

    private static int count = 0;

    // One-parameter constructor that delegates on the main constructor choosing a random key
    public Caesar(final String message) {
        this(message, random.nextInt(26));
    }

    // Main constructor that initializes the message and the key by validating it
    public Caesar(final String message, final int key) {
        this.message = message;
        this.key = key % 26;

        count++;
    }

    // Setters and getters
    // Setters return a self-reference to enable method chaining
    public String getMessage() {
        return message;
    }

    public Caesar setMessage(final String message) {
        this.message = message;
        return this;
    }

    public int getKey() {
        return key;
    }

    public Caesar setKey(final int key) {
        this.key = key % 26;
        return this;
    }

    // Method to encode a message based on the key, moving each character by key positions
    // Return the encoded message
    public String encode() {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            res.append((char) (message.charAt(i) + this.key));
        }

        return res.toString();
    }

    // Method to decode a message based on the key, moving each character by key positions backwards
    // Return the original message
    public String decode() {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            res.append((char) (message.charAt(i) - this.key));
        }

        return res.toString();
    }

    public static int getCount() {
        return count;
    }
}
