public class Bomber {
    private String nom;
    private String cognoms;
    private int edat;
    private boolean casat;
    private boolean especialista;

    private boolean isAgeValid(final int age) {
        return age > 0;
    }

    public Bomber(final String nom, final String cognoms, final int edat, final boolean casat, final boolean especialista) {
        this.nom = nom;
        this.cognoms = cognoms;

        this.edat = (isAgeValid(edat) ? edat : 0);

        this.casat = casat;
        this.especialista = especialista;
    }

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
