class FinallyDemo {
    static void procA() {
        try {
            System.out.println("Dentro de procA");
            throw new RuntimeException("demo");
        } finally {
            System.out.println("Sentencia finally de procA");
        }
    }

    static void procB() {
        try {
            System.out.println("Dentro de procB");
            return;
        } finally {
            System.out.println("Sentencia finally de procB");
        }
    }

    static void procC() {
        try {
            System.out.println("Dentro de procC");
        } finally {
            System.out.println("Sentencia finally de procC");
        }
    }

    public static void main(String[] args) {
        try {
            procA();
        } catch (Exception e) {
            System.out.println("Excepcion capturada");
        }
        procB();
        procC();
    }
}

// El programa muestra por pantalla
// Dentro de procA
// Sentencia finally de procA
// Excepcion capturada
// Dentro de procB
// Sentencia finally de procB
// Dentro de procC
// Sentencia finally de procC
