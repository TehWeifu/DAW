public class Senador extends Legislador {
    public Senador(final String nombre, final String apellidos, final int edad, final String provinciaQueRepresenta) {
        super(nombre, apellidos, edad, provinciaQueRepresenta);
    }

    @Override
    public String getCamaraEnQueTrabaja() {
        return "Senador";
    }
}
