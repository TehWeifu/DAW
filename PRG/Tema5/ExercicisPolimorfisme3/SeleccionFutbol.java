public class SeleccionFutbol {
    private final int id;
    private final String nombre;
    private final String apellidos;
    private final int edad;

    public SeleccionFutbol(final int id, final String nombre, final String apellidos, final int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void viajar() {
        System.out.println("Viajar (Clase Padre)");
    }

    public void concentrarse() {
        System.out.println("Concentrarse (Clase Padre)");
    }

    public void entrenamiento() {
        System.out.println("Asiste al Entrenamiento (Clase Padre)");
    }

    public void partidoFutbol() {
        System.out.println("Asiste al Partido de Futbol (Clase Padre)");
    }
}
