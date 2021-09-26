// 3. Intenta dir que resultat donaria el següent codi:

public class Exercici3 {
    public static void main(String[] args) {
        int valor = 0;
        valor = 23;
        valor += 10; // valor == 33

        // "a=32", valor == 32
        System.out.println("El resultado de a=" + --valor);

        // "b=33", valor == 33
        System.out.println("El resultado de b=" + ++valor);

        // "c=33", valor == 34
        System.out.println("El resultado de c=" + valor++);

        // "d=34", valor == 33
        System.out.println("El resultado de d=" + valor--);

        // "e=33", valor == 33
        System.out.println("El resultado de e=" + valor);
    }
}

