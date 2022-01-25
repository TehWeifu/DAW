import java.util.Date;

public class Llibres extends Publicacio implements Prestable {
    private boolean prestat;

    public Llibres(final int codi, final String titol, final Date anyPublicacio) {
        super(codi, titol, anyPublicacio);
        this.prestat = false;
    }

    @Override
    public void prestar() {
        this.prestat = true;
    }

    @Override
    public void retornar() {
        this.prestat = false;
    }

    @Override
    public boolean prestat() {
        return prestat;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s%n%s: %b",
                "Llibre",
                super.toString(),
                "Prestat", prestat());
    }
}
