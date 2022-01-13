public class Futbolista extends SeleccionFutbol {
    private final int dorsal;
    private final String demarcacion;

    public Futbolista(final int id, final String nombre, final String apellidos, final int edad, final int dorsal, final String demarcacion) {
        super(id, nombre, apellidos, edad);
        this.dorsal = dorsal;
        this.demarcacion = demarcacion;
    }

    public void entrevista() {
        System.out.println("Da una Entrevista");
    }

    @Override
    public void entrenamiento() {
        System.out.println("Realiza un entrenamiento (Clase Futbolista)");
    }

    @Override
    public void partidoFutbol() {
        System.out.println("Juega un Partido (Clase Futbolista)");
    }
}
