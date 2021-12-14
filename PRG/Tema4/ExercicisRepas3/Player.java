// Class "Player" that represents a player with a fixed name and a number of lives that can change
public class Player {
    String name;
    int lives;

    // One parameter constructor that delegates on the main constructor with the argument name and a fixed amount of lives
    public Player(final String name) {
        this(name, 3);
    }

    // Main constructor that initializes every property with the argument value
    // Validates the lives property to be a positive number
    public Player(final String name, int lives) {
        this.name = name;
        this.lives = Math.max(lives, 0);
    }

    // Setters & Getters
    // Setters return a self-reference to enable method chaining
    public String getName() {
        return name;
    }

    public int getLives() {
        return lives;
    }

    // Valides lives to be always a positive number
    public Player setLives(final int lives) {
        this.lives = Math.max(lives, 0);
        return this;
    }

    // Valides lives to be always a positive number
    public Player decreaseLive() {
        if (this.lives > 0) {
            this.lives--;
        }
        return this;
    }

    public Player increaseLive() {
        this.lives++;
        return this;
    }

    // Method to print the current status of a player to the console
    public void printLives() {
        System.out.printf("El jugador %s tiene %d vidas.%n", this.name, this.lives);
    }
}
