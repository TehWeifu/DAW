public class Team {
    private String name;
    private int gamesWon;
    private int pointsFavor;
    private int pointsAgainst;

    // One-parameter constructor that delegates on the main constructor
    public Team(String name) {
        this(name, 0, 0, 0);
    }

    // Main constructor that validates gamesWon, pointsFavor and pointsAgainst to be a positive value
    public Team(String name, int gamesWon, int pointsFavor, int pointsAgainst) {
        this.name = name;
        this.gamesWon = Math.max(gamesWon, 0);
        this.pointsFavor = Math.max(pointsFavor, 0);
        this.pointsAgainst = Math.max(pointsAgainst, 0);
    }

    // Setters & Getters for every property
    // Setters return a self-reference to enable method chaining
    public String getName() {
        return name;
    }

    public Team setName(String name) {
        this.name = name;
        return this;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    // Validates gamesWon to be a positive value
    public Team setGamesWon(int gamesWon) {
        this.gamesWon = Math.max(gamesWon, 0);
        return this;
    }

    public int getPointsFavor() {
        return pointsFavor;
    }

    // Validates pointsFavor to be a positive value
    public Team setPointsFavor(int pointsFavor) {
        this.pointsFavor = Math.max(pointsFavor, 0);
        return this;
    }

    public int getPointsAgainst() {
        return pointsAgainst;
    }

    // Validates pointsAgainst to be a positive value
    public Team setPointsAgainst(int pointsAgainst) {
        this.pointsAgainst = Math.max(pointsAgainst, 0);
        return this;
    }
}
