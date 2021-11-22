public class PruebaLista {
    public static void main(String[] args) {
        Integer[] lista_integer = {1, 2, 3, 4, 5, 6};
        Double[] lista_double = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
        Character[] lista_caracter = {'H', 'O', 'L', 'A'};

        System.out.println("la lista de Integer  contiene:");
        Lista.imprimirLista(lista_integer);
        System.out.println("\nla lista de doble contiene:");
        Lista.imprimirLista(lista_double);
        System.out.println("\nla lista de Caracter contiene:");
        Lista.imprimirLista(lista_caracter);
    }
}
