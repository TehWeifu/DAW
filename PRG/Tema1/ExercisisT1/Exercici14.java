public class Exercici14 {
    public static void main(String[] args) {
        // Declaració i inicialització de variables
        int a = 5;
        int b = 8;
        
        // Mostra per pantalla els valor abans de ser canviats
        System.out.println("El valor de la variable \"a\" abans de ser canviat es: " + a);
        System.out.println("El valor de la variable \"b\" abans de ser canviat es: " + b);

        // Intercanvia els valors de a i b
        a += b;
        b = a - b;
        a -= b;

        // Mostra per pantalla els valor després de ser canviats
        System.out.println("El valor de la variable \"a\" després de ser canviat es: " + a);
        System.out.println("El valor de la variable \"b\" després de ser canviat es: " + b);
    }
}

