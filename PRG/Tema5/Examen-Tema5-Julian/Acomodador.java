public class Acomodador extends Empleat {
    public Acomodador(final String dni, final String nom, final String cognoms, final String dataIngres) {
        super(dni, nom, cognoms, dataIngres);
    }

    @Override
    public double getPayment() {
        return 900.00;
    }

    @Override
    public String vorePeliculas() {
        return String.format("El Acomodador %s %s esta viendo una pelicula de terror", getNom(), getCognoms());
    }

    @Override
    public String toString() {
        return String.format("%s%n%s",
                "Acomodador",
                super.toString());
    }
}
