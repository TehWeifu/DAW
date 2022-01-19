public class Diputado extends Legislador {
    public Diputado(final String nombre, final String apellidos, final int edad, final String provinciaQueRepresenta) {
        super(nombre, apellidos, edad, provinciaQueRepresenta);
    }

    @Override
    public String getCamaraEnQueTrabaja() {
        return "Congreso de los diputados";
    }
}
