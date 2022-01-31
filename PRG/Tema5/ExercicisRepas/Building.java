public abstract class Building implements Taxable, Lightable {
    private static int autoInc = 1;

    private final int id;
    private String name;
    private int numElevators;

    public Building(final String name, final int numElevators) {
        this.id = autoInc++;
        this.name = name;
        this.numElevators = Math.max(numElevators, 0);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Building setName(final String name) {
        this.name = name;
        return this;
    }

    public int getNumElevators() {
        return numElevators;
    }

    public Building setNumElevators(final int numElevators) {
        this.numElevators = Math.max(numElevators, 0);
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s: %d%n%s: %s%n%s: %d%n%s: %.2f$",
                "ID", getId(),
                "Nombre", getName(),
                "Numero de ascensores", getNumElevators(),
                "Impuestos", getTax());
    }
}
