package Ciphers;

import java.math.BigInteger;
import java.util.Random;

// Class that implements the RSA algorithm, encoding and decoding messages and calculating the private and public keys
public class Rsa extends AsymmetricCipher {
    // List of primes and number generator to pick random primes to generate the numbers
    private static final int[] primes = {19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
    private static final Random random = new Random();

    public static final String description = """
            Sistema criptográfico de clave pública desarrollado en 1979, que utiliza factorización de números enteros.
            Es el primer y más utilizado algoritmo de este tipo y es válido tanto para cifrar como para firmar digitalmente.
            Para más información → https://es.wikipedia.org/wiki/RSA""";

    // Properties: the messages to work with and the variables needed to calculate the keys
    private final long p;
    private final long q;
    private final long n;
    private final long z;
    private final long k;
    private final long j;

    private Rsa(final String message, final long p, final long q, final long n, final long z, final long k, final long j) {
        super(message, String.format("%d, %d", k, n), String.format("%d, %d", j, n));

        this.p = p;
        this.q = q;
        this.n = n;
        this.z = z;
        this.k = k;
        this.j = j;
    }


    public static Rsa create(final String message) {
        final int tmpP = primes[random.nextInt(primes.length)];
        int tmpQ;
        do {
            tmpQ = primes[random.nextInt(primes.length)];
        } while (tmpP == tmpQ);
        return Rsa.create(message, tmpP, tmpQ);
    }

    public static Rsa create(final String message, final long tmpP, final long tmpQ) {
        final long tmpN = tmpP * tmpQ;
        final long tmpZ = (tmpP - 1) * (tmpQ - 1);
        final long tmpK = obtainValueK(tmpZ);
        final long tmpJ = obtainValueJ(tmpK, tmpZ);

        return new Rsa(message, tmpP, tmpQ, tmpN, tmpZ, tmpK, tmpJ);
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

        for (int i = 0; i < getMessage().length(); i++) {
            tmpChar = BigInteger.valueOf(getMessage().charAt(i));
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

        for (int i = 0; i < getMessage().length(); i++) {
            tmpChar = BigInteger.valueOf(getMessage().charAt(i)).subtract(BigInteger.valueOf(150));
            tmpChar = tmpChar.pow((int) j);
            tmpChar = tmpChar.mod(tmpN);

            tmpRes.append((char) tmpChar.intValueExact());
        }
        return tmpRes.toString();
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

    @Override
    public String toString() {
        return String.format("%s%n%s%n",
                "Cifrado RSA",
                super.toString());
    }
}

