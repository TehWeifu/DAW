import Ciphers.Cipher;

import java.util.ArrayList;
import java.util.List;

// ListOfCiphers class
// Class designed to store an array of Ciphers and encapsulate its operations
public class ListOfCiphers {
    private final List<Cipher> cipherList;

    public ListOfCiphers() {
        this.cipherList = new ArrayList<>();
    }

    public void addCipher(final Cipher cipher) {
        cipherList.add(cipher);
    }

    public void printAll() {
        for (Cipher cipher : cipherList) {
            System.out.println(cipher);
        }
    }
}
