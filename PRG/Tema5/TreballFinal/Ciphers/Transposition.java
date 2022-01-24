package Ciphers;

// Class that implements the transposition algorithm, encoding and decoding messages
public class Transposition extends SymmetricCipher {
    public static final String description = """
            Cifrado de clave simétrica en el que unidades de texto plano se cambian de posición siguiendo un esquema bien definido.
            Para más información → https://es.wikipedia.org/wiki/Cifrado_por_transposici%C3%B3n""";


    // Constructor that initializes the object with its argument values
    public Transposition(String message, String key) {
        super(message, key);
    }

    // Method to encode the message and return the encrypted message
    // Uses the transposition algorithm to place every char into the new position
    public String encode() {
        StringBuilder tmpKey = new StringBuilder(getKey());
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < tmpKey.length(); i++) {

            int tmpPos = posFirstLetter(tmpKey.toString());
            tmpKey.setCharAt(tmpPos, '■');

            for (int j = 0; j < getMessage().length() / tmpKey.length() + 1; j++) {
                if (getMessage().length() > j * tmpKey.length() + tmpPos) {
                    res.append(getMessage().charAt(j * tmpKey.length() + tmpPos));
                }
            }
        }
        return res.toString();
    }

    // Method to decode the cipher into the original message
    // Uses the transposition algorithm the place every char into its original value
    public String decode() {
        StringBuilder tmpKey = new StringBuilder(getKey());
        StringBuilder res = new StringBuilder();
        res.append("■".repeat(getMessage().length()));

        int count = 0;

        for (int i = 0; i < tmpKey.length(); i++) {
            int tmpPos = posFirstLetter(tmpKey.toString());
            tmpKey.setCharAt(tmpPos, '■');


            for (int j = 0; j < getMessage().length() / tmpKey.length() + 1; j++) {
                if (getMessage().length() > j * tmpKey.length() + tmpPos) {
                    res.setCharAt(j * tmpKey.length() + tmpPos, getMessage().charAt(count++));
                }
            }
        }
        return res.toString();
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

    @Override
    public String toString() {
        return String.format("%s%n%s%n",
                "Cifrado por Transposición",
                super.toString());
    }
}
