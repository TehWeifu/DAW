public class Vendedor {
    private String name;
    private int soldUnits;

    public Vendedor(final String name) {
        this(name, 0);
    }

    public Vendedor(final String name, final int soldUnits) {
        this.name = name;
        this.soldUnits = soldUnits;
    }

    public String getName() {
        return name;
    }

    public Vendedor setName(String name) {
        this.name = name;
        return this;
    }

    public int getSoldUnits() {
        return soldUnits;
    }

    public Vendedor setSoldUnits(int soldUnits) {
        this.soldUnits = soldUnits;
        return this;
    }
}
