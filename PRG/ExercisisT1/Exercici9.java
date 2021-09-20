public class Exercici9 {
    public static void main(String[] args) {
        // El comentari no estava bé tancat, he afegit el símbol ('*') que faltava
        /* Esto es un comentario */
        int b;

        // "Int" no es cap tipus de data, la declaració correcta es fa amb "int"
        int resultado;

        // la variable "Resultado" no existeix, cal tindre en compte les majúscules i posar "resultado"
        // el símbol (':') no és vàlid en el nom d'una variable ni per a fer una operació d'assignació
        resultado = 0;

        // Cal ficar les dues cometes envoltant els strings literals
        System.out.println("Suma de dos numeros");

        // La variable "A" mai va ser declarada, cal declara-la abans d'utilitzar-la
        int A = 2;

        // La variable "B" no existeix, cal tindre en compte les majúscules i utilitzar la variable declarada "b"
        b = 1;

        // la variable "Resultado" no existeix, cal tindre en compte les majúscules i posar "resultado"
        resultado = b + A;

        // Per a mostar el valor d'una variable, no s'ha de posar envoltada per cometes
        // Hi ha qeu llevar les cometes i concatenar l'expressió amb el string literal
        System.out.println("Resultado = " + resultado);
    }
}

