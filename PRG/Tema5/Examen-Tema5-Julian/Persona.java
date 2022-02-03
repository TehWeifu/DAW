public class Persona {
    private final String dni;
    private String nom;
    private String cognoms;

    public Persona(final String dni, final String nom, final String cognoms) {
        this.dni = dni;
        this.nom = nom;
        this.cognoms = cognoms;
    }

    public String getDni() {
        return dni;
    }

    public String getNom() {
        return nom;
    }

    public Persona setNom(final String nom) {
        this.nom = nom;
        return this;
    }

    public String getCognoms() {
        return cognoms;
    }

    public Persona setCognoms(final String cognoms) {
        this.cognoms = cognoms;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s: %s%n%s: %s%n%s: %s",
                "DNI", getDni(),
                "Nom", getNom(),
                "Cognom", getCognoms());
    }
}
