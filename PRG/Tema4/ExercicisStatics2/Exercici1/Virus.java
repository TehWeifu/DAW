public class Virus {
    final private int num;
    private static int totalCount = 0;

    public Virus(int num) {
        this.num = num;
        totalCount++;
    }

    public int NumeroVirus() {
        return num;
    }

    public static int getVirusCount() {
        return totalCount;
    }
}
