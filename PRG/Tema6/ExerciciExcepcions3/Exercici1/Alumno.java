public class Alumno {
    public Alumno(String nombre, String apellidos) throws Exception {
        if (nombre == null || apellidos == null)
            throw new Exception("Argumentos no válidos");
    }

    public static void main(String[] args) {
        try {
            Alumno alum = new Alumno(null, "hola");
        } catch (Exception e) {
            System.out.println("Excepcion: " + e.getMessage());
        }
    }
}

// El objeto alum de la classe Alumno no se crea ya que el constructor lanza una excepcion.
// Al lanzar una excepcion la ejecucion del constructor no se completa por lo que el objeto no se inicializa