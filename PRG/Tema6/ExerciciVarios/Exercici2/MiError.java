public class MiError extends Exception {
    int i;

    MiError(int i) {
        this.i = i;
    }

    String R() {
        if (i == 1) {
            return "No existe tangente de 90 grados";
        }
        if (i == 2) {
            return "No existe tangente de 270 grados";
        }
        return "error indefinido";
    }
}
