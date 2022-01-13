public class Masajista extends SeleccionFutbol {
    private final String titulacion;
    private final int aniosExperiencia;

    public Masajista(final int id, final String nombre, final String apellidos, final int edad, final String titulacion, final int aniosExperiencia) {
        super(id, nombre, apellidos, edad);
        this.titulacion = titulacion;
        this.aniosExperiencia = aniosExperiencia;
    }

    public void darMasaje() {
        System.out.println("Da un Masaje");
    }

    @Override
    public void entrenamiento() {
        System.out.println("Da asistencia en el entrenamiento (Clase Masajista)");
    }
}
