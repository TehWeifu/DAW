public class Salesman {
    private String name;
    private int soldUnits;

    // One-parameter constructor that delegates on the main Constructor
    public Salesman(final String name) {
        this(name, 0);
    }

    // Main Constructor that receives two parameters
    // Validates soldUnits to be a positive value
    public Salesman(final String name, final int soldUnits) {
        this.name = name;
        this.soldUnits = Math.max(soldUnits, 0);
    }

    // Setters & Getters for each property
    // Setters return a self-reference to enable method chaining
    public String getName() {
        return name;
    }

    public Salesman setName(final String name) {
        this.name = name;
        return this;
    }

    public int getSoldUnits() {
        return soldUnits;
    }

    // Validates soldUnits to be a positive value
    public Salesman setSoldUnits(final int soldUnits) {
        this.soldUnits = Math.max(soldUnits, 0);
        return this;
    }
}
