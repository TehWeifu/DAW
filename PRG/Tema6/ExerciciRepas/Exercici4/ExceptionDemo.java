class MyException extends Exception {
    private int detail;

    MyException(int a) {
        detail = a;
    }

    public String toString() {
        return "MyException[" + detail + "]";
    }
}

class ExceptionDemo {
    static void compute(int a) throws MyException {
        System.out.println("Ejecuta compute(" + a + ")");
        if (a > 10)
            throw new MyException(a);
        System.out.println("Finalizacion normal");
    }

    public static void main(String[] args) {
        try {
            compute(1);
            compute(20);
        } catch (MyException e) {
            System.out.println("Captura " + e);
        }
    }
}

// El programa muestra por pantalla
// Ejecuta compute(1)
// Finalizacion normal
// Ejecuta compute(20)
// Captura MyException[20]
