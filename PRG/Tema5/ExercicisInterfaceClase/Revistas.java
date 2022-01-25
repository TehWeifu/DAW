import java.util.Date;

public class Revistas extends Publicacio implements Prestable {
    private int num;


    public Revistas(final int codi, final String titol, final Date anyPublicacio, final int num) {
        super(codi, titol, anyPublicacio);
        this.num = num;
    }

    @Override
    public void prestar() {
        this.num = 1;
    }

    @Override
    public void retornar() {
        this.num = 0;
    }

    @Override
    public boolean prestat() {
        return this.num == 1;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s%n%s: %b",
                "Revista",
                super.toString(),
                "Prestat", prestat());
    }
}
