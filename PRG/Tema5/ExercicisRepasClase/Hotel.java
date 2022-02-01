public class Hotel extends Edifici {
    private static int count = 0;

    private int habitacions;

    public Hotel(final int numAscensors, final String nom, final int habitacions) {
        super(numAscensors, nom);
        this.habitacions = Math.max(habitacions, 0);

        incrementCount();
    }

    private static void incrementCount() {
        count++;
    }

    public static void decrementCount() {
        count--;
    }

    public static int getCount() {
        return count;
    }

    public int getHabitacions() {
        return habitacions;
    }

    public void setHabitacions(final int habitacions) {
        this.habitacions = Math.max(habitacions, 0);
    }

    @Override
    public double getTax() {
        return 1_000.00;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s%n%s: %d",
                "Hotel",
                super.toString(),
                "Numero de habitaciones", getHabitacions());
    }
}
