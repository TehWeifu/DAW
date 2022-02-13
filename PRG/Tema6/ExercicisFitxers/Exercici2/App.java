import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        FileWriter myFile = new FileWriter("./ppl.txt");

        String tmpLine;
        do {
            tmpLine = promptPerson();

            if (tmpLine != null) {
                myFile.append(tmpLine);
            }

        } while (tmpLine != null);

        myFile.close();
    }

    private static String promptPerson() {
        System.out.print("Introduzca un nombre (-1 para salir): ");
        String inputName = scanner.nextLine();

        if (inputName.equals("-1")) return null;

        boolean validAge;
        int inputAge = 0;
        do {
            validAge = true;
            System.out.print("Introduzca la edad: ");

            try {
                inputAge = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                validAge = false;
            }

            if (inputAge < 0 || inputAge > 130) validAge = false;

            if (!validAge) {
                System.out.println("Error. Se ha introducido una edad no valida");
            }
        } while (!validAge);
        return String.format("%s %d%n", inputName, inputAge);
    }
}
