public class Llibre {
    private String titol;
    private String autor;
    private int exemplars;
    private int prestats;

    // Constructor that receives no arguments and delegates the object initialization to the main constructor
    // passing the default values for the properties
    public Llibre() {
        this(null, null, 0, 0);
    }

    // Main Constructor that receives an argument for each property and initializes it with that value
    // Checks "examplars" and "prestats" is a positive value and calls helper function to check if "prestats" is valid
    public Llibre(final String titol, final String autor, final int exemplars, final int prestats) {
        this.titol = titol;
        this.autor = autor;
        this.exemplars = Math.max(exemplars, 0);
        this.prestats = Math.max(prestats, 0);

        this.prestats = (isPrestatsValid(this.exemplars, this.prestats) ? this.prestats : this.exemplars);
    }

    // Helper function that checks if the total amount is equals or bigger than the borrow amount
    private static boolean isPrestatsValid(final int exemplars, final int prestats) {
        return exemplars >= prestats;
    }

    // Setters and Getters for each property
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
        this.exemplars = Math.max(exemplars, 0);
        this.prestats = (isPrestatsValid(this.exemplars, this.prestats) ? this.prestats : this.exemplars);
    }

    public int getPrestats() {
        return prestats;
    }

    public void setPrestats(final int prestats) {
        this.prestats = Math.max(prestats, 0);
        this.prestats = (isPrestatsValid(this.exemplars, this.prestats) ? this.prestats : this.exemplars);
    }
}
