public class Llibre {
    private String titol;
    private String autor;
    private int exemplars;
    private int prestats;

    public Llibre() {
        this(null, null, 0, 0);
    }

    public Llibre(final String titol, final String autor, final int exemplars, final int prestats) {
        this.titol = titol;
        this.autor = autor;
        this.exemplars = exemplars;
        this.prestats = prestats;
        if (!isPrestatsValid(this.exemplars, this.prestats)) this.prestats = this.exemplars;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(final String titol) {
        this.titol = titol;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(final String autor) {
        this.autor = autor;
    }

    public int getExemplars() {
        return exemplars;
    }

    public void setExemplars(final int exemplars) {
        this.exemplars = exemplars;

        setPrestats(this.prestats);
    }

    public int getPrestats() {
        return prestats;
    }

    public void setPrestats(final int prestats) {
        if (!isPrestatsValid(this.exemplars, this.prestats)) this.prestats = this.exemplars;
    }

    private static boolean isPrestatsValid(final int exemplars, final int num) {
        return exemplars > num;
    }
}
