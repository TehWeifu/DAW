public class Entrenador extends SeleccionFutbol {
    private final int idFederacion;

    public Entrenador(final int id, final String nombre, final String apellidos, final int edad, final int idFederacion) {
        super(id, nombre, apellidos, edad);
        this.idFederacion = idFederacion;
    }

    public void planificarEntrenamiento() {
        System.out.println("Planificar un Entrenamiento");
    }

    @Override
    public void entrenamiento() {
        System.out.println("Dirige un entrenamiento (Clase Entrenador)");
    }

    @Override
    public void partidoFutbol() {
        System.out.println("Dirige un Partido (Clase Entrenador)");
    }

}
