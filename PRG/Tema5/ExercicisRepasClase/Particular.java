public class Particular extends Edifici {
    private static int count = 0;
    private int habitatges;

    public Particular(final int numAscensors, final String nom, final int habitatges) {
        super(numAscensors, nom);
        this.habitatges = Math.max(habitatges, 0);

        increaseCount();
    }

    private static void increaseCount() {
        count++;
    }

    public static void decreaseCount() {
        count--;
    }

    public static int getCount() {
        return count;
    }

    public int getHabitatges() {
        return habitatges;
    }

    public void setHabitatges(final int habitatges) {
        this.habitatges = Math.max(habitatges, 0);
    }

    @Override
    public double getTax() {
        return 750.00;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s%n%s: %d",
                "Particular",
                super.toString(),
                "Numero de habitatges", getHabitatges());
    }
}
