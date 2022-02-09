public class Alumno {
    public Alumno(String nombre, String apellidos) throws Exception {
        if (nombre == null || apellidos == null) throw new Exception("Argumentos no validos");
    }

    public static void main(String[] args) {
        try {
            Alumno alum = new Alumno(null, "hola");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

// Se imprime por pantalla el mensaje
// Exception: Argumentos no validos