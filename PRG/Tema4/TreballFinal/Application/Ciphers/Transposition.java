package Application.Ciphers;

// Class that implements the transposition algorithm, encoding and decoding messages
public class Transposition {
    public static final String description = """
            Cifrado de clave simétrica en el que unidades de texto plano se cambian de posición siguiendo un esquema bien definido.
            Para más información → https://es.wikipedia.org/wiki/Cifrado_por_transposici%C3%B3n""";

    private String message;
    private String key;

    private static int count = 0;

    // Constructor that initializes the object with its argument values
    public Transposition(String message, String key) {
        this.message = message;
        this.key = key;

        count++;
    }

    // Setters and getters
    // Setters return a self-reference to enable method chaining
    public String getMessage() {
        return message;
    }

    public Transposition setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getKey() {
        return key;
    }

    public Transposition setKey(String key) {
        this.key = key;
        return this;
    }


    // Method to encode the message and return the encrypted message
    // Uses the transposition algorithm to place every char into the new position
    public String encode() {
        StringBuilder tmpKey = new StringBuilder(key);
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < tmpKey.length(); i++) {

            int tmpPos = posFirstLetter(tmpKey.toString());
            tmpKey.setCharAt(tmpPos, '■');

            for (int j = 0; j < message.length() / tmpKey.length() + 1; j++) {
                if (message.length() > j * tmpKey.length() + tmpPos) {
                    res.append(message.charAt(j * tmpKey.length() + tmpPos));
                }
            }
        }
        return res.toString();
    }

    // Method to decode the cipher into the original message
    // Uses the transposition algorithm the place every char into its original value
    public String decode() {
        StringBuilder tmpKey = new StringBuilder(key);
        StringBuilder res = new StringBuilder();
        res.append("■".repeat(message.length()));

        int count = 0;

        for (int i = 0; i < tmpKey.length(); i++) {
            int tmpPos = posFirstLetter(tmpKey.toString());
            tmpKey.setCharAt(tmpPos, '■');


            for (int j = 0; j < message.length() / tmpKey.length() + 1; j++) {
                if (message.length() > j * tmpKey.length() + tmpPos) {
                    res.setCharAt(j * tmpKey.length() + tmpPos, message.charAt(count++));
                }
            }
        }
        return res.toString();
    }

    public static int getCount() {
        return count;
    }

    // Helper function to determine which letter of a string is first in alphabetical order
    private static int posFirstLetter(final String str) {
        if (!str.isEmpty()) {
            char firstLetter = str.charAt(0);
            int firstPos = 0;

            for (int i = 1; i < str.length(); i++) {
                if (firstLetter > str.charAt(i)) {
                    firstLetter = str.charAt(i);
                    firstPos = i;
                }
            }
            return firstPos;
        } else return -1;
    }
}
