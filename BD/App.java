import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException {
        Random rnd = new Random();
        StringBuilder result = new StringBuilder();

        FileWriter myFile = new FileWriter("./sql.txt");

        Map<Integer, List<Integer>> championsToPlayers = new HashMap<>();

        result.append("INSERT INTO Tienen\n");
        result.append("VALUES");

        for (int i = 0; i < 500; i++) {
            int rndChamp = 1 + rnd.nextInt(33);
            int rndPlayer = 1 + rnd.nextInt(18);

            if (championsToPlayers.containsKey(rndChamp)) {
                if (championsToPlayers.get(rndChamp).contains(rndPlayer)) continue;
                else championsToPlayers.get(rndChamp).add(rndPlayer);
            } else {
                championsToPlayers.put(rndChamp, new ArrayList<>());
                championsToPlayers.get(rndChamp).add(rndPlayer);
            }

            result.append(String.format("(null, %d, %d, %d),\n",
                    rndChamp,
                    rndPlayer,
                    rnd.nextInt(10_000_000)));
        }

        result.deleteCharAt(result.length() - 1);
        result.deleteCharAt(result.length() - 1);
        result.append(System.lineSeparator());
        myFile.write(result.toString());
        myFile.close();
    }
}
