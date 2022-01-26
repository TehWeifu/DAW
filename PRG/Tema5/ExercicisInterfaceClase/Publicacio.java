import java.util.Date;

public abstract class Publicacio implements Prestable {
    private int codi;
    private String titol;
    private Date anyPublicacio;

    public Publicacio(final int codi, final String titol, final Date anyPublicacio) {
        this.codi = codi;
        this.titol = titol;
        this.anyPublicacio = anyPublicacio;
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(final int codi) {
        this.codi = codi;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(final String titol) {
        this.titol = titol;
    }

    public Date getAnyPublicacio() {
        return anyPublicacio;
    }

    public void setAnyPublicacio(final Date anyPublicacio) {
        this.anyPublicacio = anyPublicacio;
    }

    @Override
    public String toString() {
        return String.format("%s: %d%n%s: %s%n%s: %s",
                "Codi", getCodi(),
                "Titol", getTitol(),
                "Any Publicacio", getAnyPublicacio().getYear());
    }
}
