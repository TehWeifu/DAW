import java.util.Calendar;

public class ProfesorInterino extends Profesor {
    private final Calendar fechaComienzoInterinidad;

    public ProfesorInterino(final String nombre, final String apellidos, final int edad, final String idProfesor, final Calendar fechaComienzoInterinidad) {
        super(nombre, apellidos, edad, idProfesor);
        this.fechaComienzoInterinidad = fechaComienzoInterinidad;
    }

    public Calendar getFechaComienzoInterinidad() {
        return fechaComienzoInterinidad;
    }

    @Override
    public String toString() {
        return String.format("%s%s: %s",
                super.toString(),
                "Fecha comienzo interinidad", fechaComienzoInterinidad.getTime());
    }
}
