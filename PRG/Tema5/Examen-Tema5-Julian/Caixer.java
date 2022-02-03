public class Caixer extends Empleat {
    public Caixer(final String dni, final String nom, final String cognoms, final String dataIngres) {
        super(dni, nom, cognoms, dataIngres);
    }

    @Override
    public double getPayment() {
        return 1_100.00;
    }

    @Override
    public String vorePeliculas() {
        return String.format("El Caixer %s %s esta viendo una pelicula de animacio", getNom(), getCognoms());
    }

    @Override
    public String toString() {
        return String.format("%s%n%s",
                "Caixer",
                super.toString());
    }
}
