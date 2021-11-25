import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercici2 {
    private static List<Team> teamArr = new ArrayList<>();
    private static final SecureRandom numGen = new SecureRandom();
    private static final Scanner scanner = new Scanner(System.in);

    private static int mainMenu() {
        int inputOption;
        System.out.println("#########MENU#########");
        System.out.println("# 1. Generar equips  #");
        System.out.println("# 2. Mostrar equips  #");
        System.out.println("# 3. Equip guanyador #");
        System.out.println("# 4. Eixir           #");
        System.out.println("######################");
        do {
            System.out.print("Introduïsca una opció: ");
            inputOption = Integer.parseInt(scanner.nextLine());
        } while (inputOption < 1 || inputOption > 4);
        return inputOption;
    }

    private static void generateTeams() {
        teamArr.clear();

        for (int i = 0; i < 20; i++) {
            teamArr.add(new Team(generateRndStr(), numGen.nextInt(20), numGen.nextInt(2000), numGen.nextInt(2000)));
        }
    }

    private static String generateRndStr() {
        String resultStr = "";
        for (int i = 0; i < (5 + numGen.nextInt(11)); i++) {
            resultStr += (char) (97 + numGen.nextInt(26));
        }
        return resultStr;
    }

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

    private static void printTeams() {
        System.out.printf("%-20s%-20s%-20s%s%n", "Equip", "Partits guanyats", "Punts a favor", "Punts en contra");

        for (Team team : teamArr) {
            System.out.printf("%-20s%-20s%-20s%s%n", team.getName(), team.getGamesWon(), team.getPointsFavor(), team.getPointsAgainst());
        }
    }

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
                        System.out.println("No hi han equips :(");
                    } else {
                        System.out.printf("El millor equip es %s. Ha gunyat %d partits, amb punts %d anotats i %d punts en contra.%n",
                                tmpTeam.getName(), tmpTeam.getGamesWon(), tmpTeam.getPointsFavor(), tmpTeam.getPointsAgainst());
                    }
                    break;
            }
            System.out.println();
        } while (menuOption != 4);
    }
}
