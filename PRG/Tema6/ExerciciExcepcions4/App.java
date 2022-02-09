public class App {
    public static void main(String[] args) {
        try {
            metodo1(); // llamar a metodo1
        } catch (Exception excepcion) {
            excepcion.printStackTrace();
        }
    }

    public static void metodo1() throws Exception {
        try {
            metodo2();
        } catch (Exception excepcion) {
            throw new Exception("Excepcion lanzada en metodo1", excepcion);
        }
    }

    public static void metodo2() throws Exception {
        try {
            metodo3();
        } catch (Exception excepcion) {
            throw new Exception("Excepcion lanzada en metodo2", excepcion);
        }
    }

    public static void metodo3() throws Exception {
        throw new Exception("Excepcion lanzada en metodo3");
    }
}

// El orden en el que se ejecutan las excepciones es
// 1. En el metodo3() se lanza la primera excepcion
// 2. El metodo2() controla la excepcion y la re-lanza
// 3. El metodo3() controla la excepcion y la re-lanza
// 4. El metodo4() controla la excepcion e imprime el StackTrace
