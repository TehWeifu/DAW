package Ciphers;

// AsymmetricCipher class
// Define both keys that every subclass must use
public abstract class AsymmetricCipher extends Cipher {
    private final String publicKey;
    private final String privateKey;

    public AsymmetricCipher(final String message, final String publicKey, final String privateKey) {
        super(message);
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    @Override
    public String getKey() {
        return String.format("%s: %s%n%s: %s%n",
                "Public Key", getPublicKey(),
                "Private Key", getPrivateKey());
    }

    // Overrides and creates a toString from zero since the original toString is designed for one key
    @Override
    public String toString() {
        return String.format("%s: %s%n%s",
                "Message", getMessage(),
                getKey());
    }
}
