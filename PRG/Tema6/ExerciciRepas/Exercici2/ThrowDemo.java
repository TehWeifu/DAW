class ThrowDemo {
    public static void demoproc() {
        try {
            throw new NullPointerException("demo");
        } catch (NullPointerException e) {
            System.out.println("Captura dentro de demoproc.");
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            demoproc();
        } catch (NullPointerException e) {
            System.out.println("Nueva captura: " + e);
        }
    }
}

// El programa muestra por pantalla
// Captura dentro de demoproc
// Nueva captura: java.lang.NullPointerException: demo
