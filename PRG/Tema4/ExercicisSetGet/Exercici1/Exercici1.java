public class Exercici1 {
    private static void printBomber(final Bomber bomber, final String name) {
        System.out.println(name);
        System.out.println("Nom: " + bomber.getNom());
        System.out.println("Cognoms: " + bomber.getCognoms());
        System.out.println("Edat: " + bomber.getEdat());
        System.out.println("Casat: " + bomber.isCasat());
        System.out.println("Especialista: " + bomber.isEspecialista());
        System.out.println();
    }

    public static void main(String[] args) {
        Bomber myBomber = new Bomber("Julian", "Sanchez", 89, false, true);
        printBomber(myBomber, "myBomber");

        myBomber.setNom("Paco").setCognoms("Sanz").setEdat(-2000).setCasat(true).setEspecialista(true);
        printBomber(myBomber, "myBomber");
    }
}

