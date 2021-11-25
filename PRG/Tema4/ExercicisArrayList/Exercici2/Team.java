public class Team {
    private String name;
    private int gamesWon;
    private int pointsFavor;
    private int pointsAgainst;

    public Team(String name) {
        this(name, 0, 0, 0);
    }

    public Team(String name, int gamesWon, int pointsFavor, int pointsAgainst) {
        this.name = name;
        this.gamesWon = Math.max(gamesWon, 0);
        this.pointsFavor = Math.max(pointsFavor, 0);
        this.pointsAgainst = Math.max(pointsAgainst, 0);
    }

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

    public Team setGamesWon(int gamesWon) {
        this.gamesWon = Math.max(gamesWon, 0);
        return this;
    }

    public int getPointsFavor() {
        return pointsFavor;
    }

    public Team setPointsFavor(int pointsFavor) {
        this.pointsFavor = Math.max(pointsFavor, 0);
        return this;
    }

    public int getPointsAgainst() {
        return pointsAgainst;
    }

    public Team setPointsAgainst(int pointsAgainst) {
        this.pointsAgainst = Math.max(pointsAgainst, 0);
        return this;
    }
}
