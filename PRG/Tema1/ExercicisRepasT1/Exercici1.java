// 1.Indica que mostra el següent codi i explica línia a línia el codi.
public class TestJava {
    public static void main(String[] args) {

        // 33 en binari és 100001, j << 2 dona 10000100 que en decimal és 132
        int j = 33;
        int k = j << 2;
        System.out.println("El resultat és: " + k);

        // 33 en binari és 100001, x >> 2 dona 001000 que en decimal és 8
        int x = 33;
        int y = x >> 2;
        System.out.println("El resultat és: " + y);

        // 33 en binari és 100001, x >>> 2 dona 001000 que en decimal és 8
        int z = x >>> 2;
        System.out.println("El resultat és: " + z);
    }
}

