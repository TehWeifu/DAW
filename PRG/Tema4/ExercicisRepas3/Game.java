import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static final Scanner scanner = new Scanner(System.in);
    public static final Random random = new Random();

    public static final List<Player> players = new ArrayList<>();

    public static void addPlayers() {
        System.out.print("Introduzca el nombre del jugador (-1 para empezar el juego): ");
        String inputName = scanner.nextLine();

        while (!inputName.equals("-1")) {
            System.out.print("Introduzca el numero de vidas: ");
            int inputLives = Integer.parseInt(scanner.nextLine());

            players.add(new Player(inputName, inputLives));

            System.out.print("Introduzca el nombre del jugador (-1 para empezar el juego): ");
            inputName = scanner.nextLine();
        }
    }

    public static void generateRndPlayers() {
        System.out.print("Introduzca el numero de jugadores a generar: ");
        int inputPLayers = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < inputPLayers; i++) {
            players.add(new Player(generateRndName()));
        }
    }

    public static String generateRndName() {
        StringBuilder res = new StringBuilder();

        res.append((char) ('A' + random.nextInt(26)));
        for (int i = 0; i < 4 + random.nextInt(11); i++) {
            res.append('a' + random.nextInt(26));
        }

        return res.toString();
    }

    public static void challenge() {
        Player tmpPlayer1 = players.get(random.nextInt(players.size()));
        Player tmpPlayer2;
        do {
            tmpPlayer2 = players.get(random.nextInt(players.size()));
        } while (tmpPlayer1.equals(tmpPlayer2));
        challenge(tmpPlayer1, tmpPlayer2, 1 + random.nextInt(2));
    }

    public static void challenge(Player player1, Player player2) {
        challenge(player1, player2, 1 + random.nextInt(2));
    }

    public static void challenge(Player player1, Player player2, int winnerInt) {
        Player winner;
        Player loser;

        if (winnerInt == 1) {
            winner = player1;
            loser = player2;
        } else {
            winner = player2;
            loser = player1;
        }

        System.out.printf("%s(%d vidas) ha ganado a %s(%d vidas)%n",
                winner.getName(), winner.getLives(),
                loser.getName(), loser.getLives());

        if (loser.getLives() < 1) {
            System.out.print("El jugador %s ha sido eliminado");
            players.remove(loser);
        }
    }

    public static int findPlayer(final String name) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(name)) return i;
        }
        return -1;
    }

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

    public static void printNumRemaining() {
        System.out.printf("Quedan un total de %d jugadores vivos", players.size());

    }

    public static void printWinningPlayer() {
        List<Player> winningPlayers = new ArrayList<>();

        for (Player player : players) {
            if (winningPlayers.isEmpty() || player.getLives() > winningPlayers.get(0).getLives()) {
                winningPlayers.clear();
                winningPlayers.add(player);
            } else if (player.getLives() == winningPlayers.get(0).getLives()) {
                winningPlayers.add(player);
            }
        }

        if (winningPlayers.size() == 1) {
            System.out.printf("El nombre del jugador con mayor puntuación es %s%n", winningPlayers.get(0).getName());
        } else {
            System.out.printf("Hay un total del %d jugadores empatados a puntos en el liderato: ", winningPlayers.size());
            System.out.printf("%s%n", winningPlayers);
        }
    }

    public static int startMenu() {
        System.out.println("╔═══════════════════════ INICIO ═══════════════════════╗");
        System.out.println("║ 1. Introducir jugadores                              ║");
        System.out.println("║ 2. Generar jugadores aleatoriamente                  ║");
        System.out.printf("║ NOTA: crear al menos 2 jugadores (actualmente: %d%n)  ║", players.size());
        System.out.println("╚══════════════════════════════════════════════════════╝");

        int inputOption;
        do {
            System.out.print("Introduzca una opción: ");
            inputOption = Integer.parseInt(scanner.nextLine());
        } while (inputOption < 1 || inputOption > 2);
        return inputOption;
    }

    public static int gameMenu() {
        System.out.println("╔═══════════════ PARTIDA ═══════════════╗");
        System.out.println("║ 1. Retar jugadores                    ║");
        System.out.println("║ 2. Retar jugadores (aleatoriamente)   ║");
        System.out.println("║ 3. Jugador(es) en cabeza              ║");
        System.out.println("║ 4. Numero de jugadores restantes      ║");
        System.out.println("║ 5. Buscar Jugador                     ║");
        System.out.println("║ 6. Finalizar juego                    ║");
        System.out.println("╚═══════════════════════════════════════╝");

        int inputOption;
        do {
            System.out.print("Introduzca una opción: ");
            inputOption = Integer.parseInt(scanner.nextLine());
        } while (inputOption < 1 || inputOption > 6);
        return inputOption;
    }

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

    public static Player getPlayerByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) return player;
        }
        return null;
    }

    public static void main(String[] args) {
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
            }
        } while (gameMenuOption != 6);
    }
}
