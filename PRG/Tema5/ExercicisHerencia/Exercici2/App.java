public class App {
    public static void main(String[] args) {
        Human myHuman1 = new Human("Julian Sanchez", (byte) 34);
        Human myHuman2 = new Human("Paco Sanz", (byte) 52);

        System.out.println(myHuman1.greater(myHuman2));
        System.out.println();

        if (myHuman1.equals(myHuman2)) {
            System.out.println("Los dos humanos son iguales");
        } else {
            System.out.println("Los dos humanos son diferentes");
        }
    }
}
