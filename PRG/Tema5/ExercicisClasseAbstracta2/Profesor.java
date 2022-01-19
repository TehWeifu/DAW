public abstract class Profesor extends Persona {
    private String idProfesor;

    public Profesor(final String nombre, final String apellidos, final int edad, final String idProfesor) {
        super(nombre, apellidos, edad);
        this.idProfesor = idProfesor;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public Profesor setIdProfesor(final String idProfesor) {
        this.idProfesor = idProfesor;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s: %s%n%s%n",
                "ID", idProfesor,
                super.toString());
    }
}
