public class Restaurant extends Edifici {
    private static int count = 0;

    private int taules;

    public Restaurant(final int numAscensors, final String nom, final int taules) {
        super(numAscensors, nom);

        this.taules = Math.max(taules, 0);

        increaseCount();
    }

    private static void increaseCount() {
        count++;
    }

    private static void decreaseCount() {
        count--;
    }

    private static int getCount() {
        return count;
    }

    public int getTaules() {
        return taules;
    }

    public void setTaules(final int taules) {
        this.taules = Math.max(taules, 0);
    }

    @Override
    public double getTax() {
        return 500.00;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s%n%s: %d",
                "Restaurant",
                super.toString(),
                "Numero de taules", getTaules());
    }
}
