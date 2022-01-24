package Ciphers;

public abstract class Cipher implements Encryptable, Decipherable {
    private String message;

    public Cipher(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Cipher setMessage(final String message) {
        this.message = message;
        return this;
    }

    public abstract String getKey();

    @Override
    public String toString() {
        return String.format("%s: %s%n%s: %s",
                "Message", getMessage(),
                "Key", getKey());
    }
}
