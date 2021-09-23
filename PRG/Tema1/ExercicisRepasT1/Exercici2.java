public class Exercici2 {
    public static void main(String[] args) {

        int k = 132; // En binari és 10000100
        int l = 144; // En binari és 10010000

        // Operació AND binària
        // 10000100
        // 10010000
        // 10000000 (en decimal 128)
        int m = k & l;
        System.out.println("El resultat es: " + m);

        // Operació OR binària
        // 10000100
        // 10010000
        // 10010100 (en decimal 148)
        int n = k | l;
        System.out.println("El resultat es: " + n);
    }
}

