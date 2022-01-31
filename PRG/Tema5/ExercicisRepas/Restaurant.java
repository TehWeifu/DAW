public class Restaurant extends Building {
    private static int count;
    private int tables;

    public Restaurant(final String name, final int numElevators, final int tables) {
        super(name, numElevators);
        this.tables = Math.max(tables, 0);

        increaseCount();
    }

    public static int getCount() {
        return count;
    }

    private static void increaseCount() {
        count++;
    }

    public static void decreaseCount() {
        count--;
    }

    public int getTables() {
        return tables;
    }

    public Restaurant setTables(final int tables) {
        this.tables = Math.max(tables, 0);
        return this;
    }

    @Override
    public double getTax() {
        return 500.00;
    }

    @Override
    public int getLights() {
        return 2;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s%n%s: %d",
                "Restaurante",
                super.toString(),
                "Mesas", getTables());
    }

}
