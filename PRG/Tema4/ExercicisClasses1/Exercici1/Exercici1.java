public class Exercici1 {
    public static void main(String[] args) {
        Coche myCar = new Coche();

        myCar.acelera(100);
        myCar.frena(3);

        System.out.println("La velocidad actual del coche es: " + myCar.getVelocidad());
    }
}

