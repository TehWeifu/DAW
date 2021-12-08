package Application.Ciphers;

import java.util.Random;

// Class that implements the Vernam algorithm, encoding and decoding messages
public class Vernam {
    private static final Random random = new Random();

    public static final String description = """
            Cifrado de flujo en el que el texto original se combina, mediante la operación XOR, con la clave simétrica
            Para mas información → https://es.wikipedia.org/wiki/Cifrado_Vernam""";

    private String message;
    private String key;

    private static int count = 0;

    // One parameter constructor that delegates on the main constructor generating a random key
    public Vernam(final String message) {
        this(message, generateRndKey(message.length()));
    }

    // Main constructor that initializes both the message and the key, checking the key is a valid one
    public Vernam(final String message, final String key) {
        this.message = message;
        this.key = (isKeyValid(message, key) ? key : generateRndKey(this.message.length()));

        count++;
    }

    // Setters and getters
    // Setters return a self-reference to enable method chaining
    public String getMessage() {
        return message;
    }

    public Vernam setMessage(final String message) {
        this.message = message;
        return this;
    }

    public String getKey() {
        return key;
    }

    public Vernam setKey(final String key) {
        this.key = key;
        return this;
    }

    // Method to encode the message by perform the XOR operation on every char and adding it 150 to avoid having fkc'd up characters
    public String encode() {
        if (key.length() != message.length()) {
            return null;
        }

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            res.append((char) ((message.charAt(i) ^ key.charAt(i)) + 150));
        }

        return res.toString();
    }

    // Method to encode the message by perform the XOR operation on every char
    // First has to subtract 150 to invert the process of encoding the message
    public String decode() {
        if (key.length() != message.length()) {
            return null;
        }

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            res.append((char) ((message.charAt(i) - 150) ^ key.charAt(i)));
        }

        return res.toString();
    }

    // Helper method to generate a random key
    private static String generateRndKey(final int length) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < length; i++) {
            res.append((char) random.nextInt(255));
        }

        return res.toString();
    }

    // Helper method to check if a key is valid by comparing its length to the message length
    private static boolean isKeyValid(final String message, final String key) {
        return key.length() == message.length();
    }

    public static int getCount() {
        return count;
    }
}
