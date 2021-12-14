import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Class "Game" that represent a game where players compete against each other in turns
public class Game {
    // Random and Scanner objects to be used along the class
    public static final Scanner scanner = new Scanner(System.in);
    public static final Random random = new Random();

    // Collection to contain the current players still alive in the game
    public static final List<Player> players = new ArrayList<>();

    // Method that prints the start menu and returns the user input
    // Does basic validation on the user input making sure it chooses a valid option
    public static int startMenu() {
        System.out.println("╔═══════════════════════ INICIO ═══════════════════════╗");
        System.out.println("║ 1. Introducir jugadores                              ║");
        System.out.println("║ 2. Generar jugadores aleatoriamente                  ║");
        System.out.printf("║ NOTA: crear al menos 2 jugadores (actualmente: %d)    ║%n", players.size()); // prints current amount of players
        System.out.println("╚══════════════════════════════════════════════════════╝");

        int inputOption;
        do {
            System.out.print("Introduzca una opción: ");
            inputOption = Integer.parseInt(scanner.nextLine());
        } while (inputOption < 1 || inputOption > 2);
        return inputOption;
    }

    // Method that allows the user to input new players by console and adds them to the collection
    // Prompts the user to input a name (or a sentinel value)
    // Checks the name to not be the sentinel value or not be already in the collection
    // Prompts the user to input a number of lives and validates it to be greater than 0
    public static void addPlayers() {
        String inputName;

        do {
            System.out.print("Introduzca el nombre del jugador (-1 para empezar el juego): ");
            inputName = scanner.nextLine();

            if (!inputName.equals("-1")) {
                if (findPlayer(inputName) == -1) {
                    int inputLives;
                    do {
                        System.out.print("Introduzca el numero de vidas (1 o mas): ");
                        inputLives = Integer.parseInt(scanner.nextLine());
                    } while (inputLives < 1);

                    players.add(new Player(inputName, inputLives));
                } else {
                    System.out.printf("Error. ya existe un jugador con el nombre %s%n", inputName);
                }
            }
        } while (!inputName.equals("-1"));
    }

    // Method that generates as many random players as the user wants to
    // Prompts the user to input a number of players then loops as my times
    // Fore each loop, generates a random name, checks is not already taken
    public static void generateRndPlayers() {
        System.out.print("Introduzca el numero de jugadores a generar: ");
        int inputPlayers = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < inputPlayers; i++) {
            String tmpName = generateRndName();
            if (findPlayer(tmpName) == -1) {
                players.add(new Player(generateRndName()));
            } else {
                i--; // In case the name already exists decrease the i variable to make the loop "not count"
            }
        }
    }

    // Helper method that generates and returns a random String
    // The string consisting in between 5 and 15 letters, the first being upper the rest lower
    public static String generateRndName() {
        StringBuilder res = new StringBuilder();

        res.append((char) ('A' + random.nextInt(26)));
        for (int i = 0; i < 4 + random.nextInt(11); i++) {
            res.append((char) ('a' + random.nextInt(26)));
        }

        return res.toString();
    }

    // Method that prints the game menu and returns the user input
    // Does basic validation on the user input making sure it chooses a valid option
    public static int gameMenu() {
        System.out.println("╔═══════════════ PARTIDA ═══════════════╗");
        System.out.println("║ 1. Retar jugadores                    ║");
        System.out.println("║ 2. Retar jugadores aleatoriamente     ║");
        System.out.println("║ 3. Jugador(es) en cabeza              ║");
        System.out.println("║ 4. Numero de jugadores restantes      ║");
        System.out.println("║ 5. Buscar Jugador                     ║");
        System.out.println("║ 6. Retar hasta finalizar (1 con vida) ║");
        System.out.println("║ 7. Finalizar juego                    ║");
        System.out.println("╚═══════════════════════════════════════╝");

        int inputOption;
        do {
            System.out.print("Introduzca una opción: ");
            inputOption = Integer.parseInt(scanner.nextLine());
        } while (inputOption < 1 || inputOption > 7);
        return inputOption;
    }

    // Method that prompts the user which players he wants to face and to choose a result
    // Validates each name to be in the collection
    // Calls a different overloaded version of the challenge method depending on the user selection
    public static void challengePrompt() {
        String inputName1;
        String inputName2;

        do {
            System.out.print("Introduzca el nombre del primer jugador: ");
            inputName1 = scanner.nextLine();
        } while (findPlayer(inputName1) == -1);

        do {
            System.out.print("Introduzca el nombre del segundo jugador: ");
            inputName2 = scanner.nextLine();
        } while (findPlayer(inputName2) == -1);

        int inputResult;
        do {
            System.out.print("Introduzca el numero del jugador ganador (0 para aleatorio): ");
            inputResult = Integer.parseInt(scanner.nextLine());
        } while (inputResult < 0 || inputResult > 2);

        if (inputResult == 0) {
            challenge(getPlayerByName(inputName1), getPlayerByName(inputName2));
        } else {
            challenge(getPlayerByName(inputName1), getPlayerByName(inputName2), inputResult);
        }
    }

    // Overloaded method that delegates on the main method with random players and random result
    // Makes sure the players are not the same by checking the selected references
    public static void challenge() {
        Player tmpPlayer1 = players.get(random.nextInt(players.size()));
        Player tmpPlayer2;
        do {
            tmpPlayer2 = players.get(random.nextInt(players.size()));
        } while (tmpPlayer1 == tmpPlayer2);
        challenge(tmpPlayer1, tmpPlayer2, 1 + random.nextInt(2));
    }

    // Overloaded method that delegates on the main method with a random result
    public static void challenge(final Player player1, final Player player2) {
        challenge(player1, player2, 1 + random.nextInt(2));
    }

    // Main version of the overloaded method that makes a challenge between two players and
    // updates their states depending on the result and checking if the loser still has lives
    public static void challenge(final Player player1, final Player player2, final int winnerInt) {
        // Declares and initializes a winner and loser player objects assuming player1 won
        Player winner = player1;
        Player loser = player2;

        // If player 2 won the values get changed
        if (winnerInt == 2) {
            winner = player2;
            loser = player1;
        }

        // Prints on the console the result of the challenge
        // Updates the lives of each player and prints them on the console by method chaining
        System.out.printf("%s(%d vidas) ha ganado a %s(%d vidas)%n",
                winner.getName(), winner.increaseLive().getLives(),
                loser.getName(), loser.decreaseLive().getLives());

        if (loser.getLives() < 1) {
            System.out.printf("El jugador %s ha sido eliminado%n", loser.getName());
            players.remove(loser);
        }
    }

    // Method that prints on the console which are the leading players
    public static void printWinningPlayer() {
        // Collection to store the players with the most lives
        List<Player> winningPlayers = new ArrayList<>();

        // Loops through the player collection checking if a player object has more lives than the current ones
        // If so or the collection is empty, it resets it and adds the player
        for (Player player : players) {
            if (winningPlayers.isEmpty() || player.getLives() > winningPlayers.get(0).getLives()) {
                winningPlayers.clear();
                winningPlayers.add(player);
            } else if (player.getLives() == winningPlayers.get(0).getLives()) {
                winningPlayers.add(player);
            }
        }

        // Prints the results depending if there is just one player on the lead or more
        if (winningPlayers.size() == 1) {
            System.out.printf("El nombre del jugador con mayor puntuación es %s (%d vidas)%n",
                    winningPlayers.get(0).getName(), winningPlayers.get(0).getLives());
        } else {
            System.out.printf("Hay un total del %d jugadores empatados a puntos en el liderato (%d vidas)%n",
                    winningPlayers.size(), winningPlayers.get(0).getLives());
            for (Player winningPlayer : winningPlayers) {
                System.out.printf("%s ", winningPlayer.getName());
            }
            System.out.println();
        }
    }

    // Method that prints the remaining number of players by checking the collection
    public static void printNumRemaining() {
        System.out.printf("Quedan un total de %d jugadores vivos%n", players.size());

    }

    // Prints the state of a player after prompting the user to input the name of a player
    // Checks the name is on the collection
    public static void printPlayer() {
        System.out.print("Introduzca el nombre de un jugador: ");
        String inputName = scanner.nextLine();

        int playerPos = findPlayer(inputName);
        if (playerPos == -1) {
            System.out.printf("No existe el jugador %s%n", inputName);
        } else {
            players.get(playerPos).printLives();
        }
    }

    // Method tha plays random challenges until there is only one player remaining
    public static void playUntilEnd() {
        do {
            challenge();
        } while (players.size() > 1);
    }

    // Helper method that search for a player by its name
    // Returns the position of the player in the collection or -1
    private static int findPlayer(final String name) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(name)) return i;
        }
        return -1;
    }

    // Helper method that returns a player object on the array by its name
    // If it doesn't exist return null
    private static Player getPlayerByName(final String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) return player;
        }
        return null;
    }

    // Main method that creates a new game to be played
    public static void main(String[] args) {
        // First shows the start menu and loops it until there are at least 2 players
        int startMenuOption;
        do {
            startMenuOption = startMenu();

            switch (startMenuOption) {
                case 1:
                    addPlayers();
                    break;
                case 2:
                    generateRndPlayers();
                    break;
            }
        } while (players.size() < 2);

        // Then shows the game menu and loops through it until the user chooses to exist
        // or there is only 1 player remaining
        int gameMenuOption;
        do {
            gameMenuOption = gameMenu();

            switch (gameMenuOption) {
                case 1:
                    challengePrompt();
                    break;
                case 2:
                    challenge();
                    break;
                case 3:
                    printWinningPlayer();
                    break;
                case 4:
                    printNumRemaining();
                    break;
                case 5:
                    printPlayer();
                    break;
                case 6:
                    playUntilEnd();
                    break;
            }
            System.out.println();
        } while (gameMenuOption != 6 && players.size() > 1);
        System.out.println("Juego finalizado.");
        printWinningPlayer();
    }
}
