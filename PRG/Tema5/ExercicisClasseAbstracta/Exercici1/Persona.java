public abstract class Persona {
    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", "Nombre", nombre);
    }
}
