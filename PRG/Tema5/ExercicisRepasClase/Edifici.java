public abstract class Edifici implements Taxes {
    private static int auto_inc = 0;

    private final int id;
    private int numAscensors;
    private String nom;

    public Edifici(final int numAscensors, final String nom) {
        this.id = auto_inc++;

        this.numAscensors = Math.max(numAscensors, 0);
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public int getNumAscensors() {
        return numAscensors;
    }

    public void setNumAscensors(final int numAscensors) {
        this.numAscensors = Math.max(numAscensors, 0);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(final String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return String.format("%s: %d%n%s: %s%n%s: %d",
                "ID", getId(),
                "Nombre", getNom(),
                "Numero ascensores", getNumAscensors());
    }
}
