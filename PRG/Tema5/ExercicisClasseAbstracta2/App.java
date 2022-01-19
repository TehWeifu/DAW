public class App {
    public static void main(String[] args) {

        ListinLegisladores miListin = new ListinLegisladores();

        miListin.addLegislador(new Diputado("Paco", "Sanz", 2_000, "Valencia"));
        miListin.addLegislador(new Senador("Kiko", "Rivera", 39, "Madrid"));

        miListin.printLegisladores();
    }
}
