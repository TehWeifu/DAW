package Application.Ciphers;

import java.math.BigInteger;
import java.util.Random;

// Class that implements the RSA algorithm, encoding and decoding messages and calculating the private and public keys
public class Rsa {
    // List of primes and number generator to pick random primes to generate the numbers
    private static final int[] primes = {19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
    private static final Random random = new Random();

    public static final String description = """
            Sistema criptográfico de clave pública desarrollado en 1979, que utiliza factorización de números enteros.
            Es el primer y más utilizado algoritmo de este tipo y es válido tanto para cifrar como para firmar digitalmente.
            Para más información → https://es.wikipedia.org/wiki/RSA""";

    // Properties: the messages to work with and the variables needed to calculate the keys
    private String message;

    private final long p;
    private long q;
    private final long n;
    private final long z;
    private final long k;
    private final long j;

    // Counts the number of objects created
    private static int count = 0;

    // Constructor used to encrypt messages, generates random keys
    public Rsa(String message) {
        this.message = message;

        p = primes[random.nextInt(primes.length)];
        do {
            q = primes[random.nextInt(primes.length)];
        } while (p == q);
        n = p * q;
        z = (p - 1) * (q - 1);
        k = obtainValueK(z);
        j = obtainValueJ(k, z);

        count++;
    }

    // Constructor used to decrypt messages, receives starting values to calcule the keys
    public Rsa(String message, long p, long q) {
        this.message = message;
        this.p = p;
        this.q = q;

        n = p * q;
        z = (p - 1) * (q - 1);
        k = obtainValueK(z);
        j = obtainValueJ(k, z);

        count++;
    }

    // Setters and getters
    // Setters return a self-reference to enable method chaining
    public String getMessage() {
        return message;
    }

    public Rsa setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getPublicKey() {
        return String.format("%d, %d", this.k, this.n);
    }

    public String getPrivateKey() {
        return String.format("%d, %d", this.j, this.n);
    }

    public long getP() {
        return p;
    }

    public long getQ() {
        return q;
    }

    // Method to encode the message and return it
    // Loop thorough every character in the message using the RSA formula to obtain the encrypted character
    public String encode() {
        StringBuilder tmpRes = new StringBuilder();

        final BigInteger tmpN = BigInteger.valueOf(n);
        BigInteger tmpChar;

        for (int i = 0; i < message.length(); i++) {
            tmpChar = BigInteger.valueOf(message.charAt(i));
            tmpChar = tmpChar.pow((int) k);
            tmpChar = tmpChar.mod(tmpN);

            tmpRes.append((char) (150 + tmpChar.intValueExact()));
        }
        return tmpRes.toString();
    }

    // Method to decode the message and return it
    // Loop thorough every character in the cipher using the RSA formula to obtain the original character
    public String decode() {
        StringBuilder tmpRes = new StringBuilder();

        BigInteger tmpChar;
        final BigInteger tmpN = BigInteger.valueOf(n);

        for (int i = 0; i < message.length(); i++) {
            tmpChar = BigInteger.valueOf(message.charAt(i)).subtract(BigInteger.valueOf(150));
            tmpChar = tmpChar.pow((int) j);
            tmpChar = tmpChar.mod(tmpN);

            tmpRes.append((char) tmpChar.intValueExact());
        }
        return tmpRes.toString();
    }

    public static int getCount() {
        return count;
    }

    // Helper function to calcula "K". A co-prime not divisible by "z"
    private static long obtainValueK(final long z) {
        for (int i = 2; true; i++) {
            if (isPrime(i)) {
                if (z % i != 0) return i;
            }
        }
    }

    // Helper function to calculate "J". Number that multiplied with "k", result in mod 1 after dividing it by "z"
    private static long obtainValueJ(final long k, final long z) {
        for (int i = 0; true; i++) {
            if ((k * i) % z == 1) return i;
        }
    }

    // Helper method to know if a number is prime by diving the number up until its square and checking the mod
    private static boolean isPrime(final long num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

