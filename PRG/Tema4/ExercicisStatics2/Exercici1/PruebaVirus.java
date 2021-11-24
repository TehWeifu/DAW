import java.util.Scanner;

public class PruebaVirus {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("¿Cuantos virus quieres?: ");
        int numViruses = leer.nextInt();
        if (numViruses > 0) {
            Virus[] virii = new Virus[numViruses];
            for (int i = 0; i < numViruses; i++) {
                virii[i] = new Virus(i);
            }
            for (int i = 0; i < numViruses; i++) {
                System.out.println("Virus num: " + virii[i].NumeroVirus());
            }
            System.out.println("Hay " + Virus.getVirusCount() + " viruses.");
        }
    }
}
