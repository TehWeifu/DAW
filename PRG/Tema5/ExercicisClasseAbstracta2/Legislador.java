public abstract class Legislador extends Persona {
    private String provinciaQueRepresenta;

    public Legislador(final String nombre, final String apellidos, final int edad, final String provinciaQueRepresenta) {
        super(nombre, apellidos, edad);
        this.provinciaQueRepresenta = provinciaQueRepresenta;
    }

    public String getProvinciaQueRepresenta() {
        return provinciaQueRepresenta;
    }

    public Legislador setProvinciaQueRepresenta(final String provinciaQueRepresenta) {
        this.provinciaQueRepresenta = provinciaQueRepresenta;
        return this;
    }

    public abstract String getCamaraEnQueTrabaja();

    @Override
    public String toString() {
        return String.format("%s%n%s: %s%n%s: %s%n",
                super.toString(),
                "Provincia", getProvinciaQueRepresenta(),
                "Trabajo", getCamaraEnQueTrabaja());
    }
}
