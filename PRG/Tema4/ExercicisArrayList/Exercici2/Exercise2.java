import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise2 {
    private static final List<Team> teamArr = new ArrayList<>();
    private static final SecureRandom numGen = new SecureRandom();
    private static final Scanner scanner = new Scanner(System.in);

    // Method that prints the main menu and prompts the user to input an option
    // Validates the user input and returns it
    private static int mainMenu() {
        int inputOption;
        System.out.println("╔═══════════ MENU ═══════════╗");
        System.out.println("║ 1. Generar equipos         ║");
        System.out.println("║ 2. Mostrar equipos         ║");
        System.out.println("║ 3. Equipo ganador          ║");
        System.out.println("║ 4. Salir                   ║");
        System.out.println("╚════════════════════════════╝");
        do {
            System.out.print("Introduzca una opción: ");
            inputOption = Integer.parseInt(scanner.nextLine());
        } while (inputOption < 1 || inputOption > 4);
        return inputOption;
    }

    // Method that clears the teamArr and then fills it up with random Team Objects
    // Generates 20 Team objects, with random names and random values as properties
    private static void generateTeams() {
        teamArr.clear();

        for (int i = 0; i < 20; i++) {
            teamArr.add(new Team(generateRndStr(), numGen.nextInt(20), numGen.nextInt(2000), numGen.nextInt(2000)));
        }
    }

    // Method that generates and returns a random String of lowercase characters with length between 5-15.
    private static String generateRndStr() {
        String resultStr = "";
        for (int i = 0; i < (5 + numGen.nextInt(11)); i++) {
            resultStr += (char) ('a' + numGen.nextInt(26));
        }
        return resultStr;
    }


    // Method that prints every Team Object stored in the teamArr container. Formatting ever output with left margin
    private static void printTeams() {
        System.out.printf("%-20s%-20s%-20s%s%n", "Equipo", "Partidos ganados", "Puntos a favor", "Puntos en contra");

        for (Team team : teamArr) {
            System.out.printf("%-20s%-20s%-20s%s%n", team.getName(), team.getGamesWon(), team.getPointsFavor(), team.getPointsAgainst());
        }
    }

    // Method that returns the Team object with the highest priority (based on compare method)
    // Returns null if the teamArr is empty
    private static Team bestTeam() {
        Team bestTeam;

        if (teamArr.isEmpty()) {
            return null;
        } else {
            bestTeam = teamArr.get(0);
        }

        for (Team team : teamArr) {
            if (compareTeams(bestTeam, team) < 0) {
                bestTeam = team;
            }
        }
        return bestTeam;
    }

    // Method that compares two Team objets to determine which has the highest precedence
    // Compares the gamesWon, points in favor and points conceded of each object, in that order
    // Returns a positive value if the first object has higher precedence, a negative number if the later Team has
    // higher precedence or zero if both teams has exactly the same precedence
    private static int compareTeams(final Team t1, final Team t2) {
        if (t1.getGamesWon() > t2.getGamesWon()) {
            return 1;
        } else if (t1.getGamesWon() == t2.getGamesWon()) {
            if (t1.getPointsFavor() > t2.getPointsFavor()) {
                return 1;
            } else if (t1.getPointsFavor() == t2.getPointsFavor()) {
                if (t1.getPointsAgainst() < t2.getPointsAgainst()) {
                    return 1;
                } else if (t1.getPointsAgainst() == t2.getPointsAgainst()) {
                    return 0;
                }
            }
        }
        return -1;
    }

    // Main method that loops the main menu until the user chooses to exit
    // For every loop switches the menu option, calling the appropriate function
    public static void main(String[] args) {
        int menuOption;
        do {
            menuOption = mainMenu();

            switch (menuOption) {
                case 1:
                    generateTeams();
                    break;
                case 2:
                    printTeams();
                    break;
                case 3:
                    Team tmpTeam = bestTeam();
                    if (tmpTeam == null) {
                        System.out.println("No hay equipos :(");
                    } else {
                        System.out.printf("El mejor equipo es %s. Ha ganado %d partidos, con puntos %d anotados y %d puntos en contra.%n",
                                tmpTeam.getName(), tmpTeam.getGamesWon(), tmpTeam.getPointsFavor(), tmpTeam.getPointsAgainst());
                    }
                    break;
            }
            System.out.println();
        } while (menuOption != 4);
    }
}
