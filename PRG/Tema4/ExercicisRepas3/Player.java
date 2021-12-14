import java.util.Objects;

public class Player {
    String name;
    int lives;

    public Player(final String name) {
        this(name, 3);
    }

    public Player(final String name, int lives) {
        this.name = name;
        this.lives = Math.max(lives, 0);
    }

    public String getName() {
        return name;
    }

    public int getLives() {
        return lives;
    }

    public Player setLives(int lives) {
        this.lives = Math.max(lives, 0);
        return this;
    }

    public Player decreaseLive() {
        this.lives--;
        return this;
    }

    public Player increaseLive() {
        this.lives++;
        return this;
    }

    public void printLives() {
        System.out.printf("El jugador %s tiene %d vidas", this.name, this.lives);
    }

    public boolean equals(Player otherPlayer) {
        if (this == otherPlayer) return true;
        return Objects.equals(name, otherPlayer.name);
    }
}
