public class Apartment extends Building {
    private static int count = 0;
    private int houses;

    public Apartment(final String name, final int numElevators, final int houses) {
        super(name, numElevators);
        this.houses = Math.max(houses, 0);

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

    public int getHouses() {
        return houses;
    }

    public Apartment setHouses(final int houses) {
        this.houses = houses;
        return this;
    }

    @Override
    public double getTax() {
        return 750.00;
    }

    @Override
    public int getLights() {
        return 10;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s%n%s: %d",
                "Apartamento",
                super.toString(),
                "Viviendas", getHouses());
    }
}
