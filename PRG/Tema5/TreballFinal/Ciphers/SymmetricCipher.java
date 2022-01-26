package Ciphers;

// SymmetricCipher class
// Define the key that every subclass must use
public abstract class SymmetricCipher extends Cipher {
    private final String key;

    public SymmetricCipher(final String message, final String key) {
        super(message);
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
