// 2. Quina es la errada d’aquest programa? Com es podria solucionar?

class Exercici2 {
    public static void main(String [] args) {
        char c='c';
        // La seguent linia dona error perque el literal 'd' no es compara amb res
        // i un char literal no es pot castear implicitament a un boolean
        // es podria solucionar declarant la variable char d = 'd' i cambiant la expressio per d = 'd'
        if (c=='c' || 'd') {
            System.out.println ("Estoy en el if");
        } else {
            System.out.println ("Estoy en el else ");
        }
    }//fin main
}//fin clase

