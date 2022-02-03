public abstract class Empleat extends Persona implements Payable, Pelicula {
    private String dataIngres;

    public Empleat(final String dni, final String nom, final String cognoms, final String dataIngres) {
        super(dni, nom, cognoms);
        this.dataIngres = dataIngres;
    }

    public String getDataIngres() {
        return dataIngres;
    }

    public Empleat setDataIngres(final String dataIngres) {
        this.dataIngres = dataIngres;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s: %s%n%s: %.2f€%n%s",
                super.toString(),
                "Data Ingres", getDataIngres(),
                "Sou", getPayment(),
                vorePeliculas());
    }
}
