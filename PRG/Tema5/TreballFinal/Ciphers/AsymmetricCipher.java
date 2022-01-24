package Ciphers;

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

    @Override
    public String toString() {
        return String.format("%s: %s%n%s",
                "Message", getMessage(),
                getKey());
    }
}
