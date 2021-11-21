public class Bomber {

    // properties of the class
    private String nom;
    private String cognoms;
    private int edat;
    private boolean casat;
    private boolean especialista;

    // helper function to determine if the age is a valid number (greater than 0)
    private boolean isAgeValid(final int age) {
        return age >= 0;
    }

    // constructor that accepts 5 arguments to initialize each property with a value
    public Bomber(final String nom, final String cognoms, final int edat, final boolean casat, final boolean especialista) {
        this.nom = nom;
        this.cognoms = cognoms;

        this.edat = (isAgeValid(edat) ? edat : 0);

        this.casat = casat;
        this.especialista = especialista;
    }

    // Setters and getters for each property
    // Setters return a pointer to this to enable chaining
    public String getNom() {
        return nom;
    }

    public Bomber setNom(final String nom) {
        this.nom = nom;
        return this;
    }

    public String getCognoms() {
        return cognoms;
    }

    public Bomber setCognoms(final String cognoms) {
        this.cognoms = cognoms;
        return this;
    }

    public int getEdat() {
        return edat;
    }

    // calls the helper function to determine if it is a valid number before assign it
    public Bomber setEdat(final int edat) {
        this.edat = (isAgeValid(edat) ? edat : 0);
        return this;
    }

    public boolean isCasat() {
        return casat;
    }

    public Bomber setCasat(final boolean casat) {
        this.casat = casat;
        return this;
    }

    public boolean isEspecialista() {
        return especialista;
    }

    public Bomber setEspecialista(final boolean especialista) {
        this.especialista = especialista;
        return this;
    }
}
