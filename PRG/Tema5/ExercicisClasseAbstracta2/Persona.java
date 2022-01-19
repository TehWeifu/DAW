public class Persona {
    private String nombre;
    private String apellidos;
    private int edad;

    public Persona(final String nombre, final String apellidos, final int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = Math.max(edad, 0);
    }

    public String getNombre() {
        return nombre;
    }

    public Persona setNombre(final String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Persona setApellidos(final String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public int getEdad() {
        return edad;
    }

    public Persona setEdad(final int edad) {
        this.edad = Math.max(edad, 0);
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s: %s%n%s: %s%n%s: %d",
                "Nombre", getNombre(),
                "Apellidos", getApellidos(),
                "Edad", getEdad());
    }
}
