public class Hotel extends Building {
    private static int count = 0;
    private int rooms;

    public Hotel(final String name, final int numElevators, final int rooms) {
        super(name, numElevators);
        this.rooms = Math.max(rooms, 0);

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

    public int getRooms() {
        return rooms;
    }

    public Hotel setRooms(final int rooms) {
        this.rooms = Math.max(rooms, 0);
        return this;
    }

    @Override
    public double getTax() {
        return 1000.00;
    }

    @Override
    public int getLights() {
        return 4;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s%n%s: %d",
                "Hotel",
                super.toString(),
                "Habitaciones", getRooms());
    }
}
