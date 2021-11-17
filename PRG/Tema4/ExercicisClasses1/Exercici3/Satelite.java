public class Satelite {
    private double meridiano;
    private double paralelo;

    // Error. El tipus es "double"
    private double distancia_tierra;

    // Error. El tipus es "double"
    public void setPosicion(double m, double p, double d) {
        meridiano = m;
        paralelo = p;
        distancia_tierra = d;
    }

    // Error. El parametre s'anomena "meridiano"
    // Error. Faltan comentes dobles despres del string "kilometros"
    public void printPosicion() {
        System.out.println("El satellite se encuentra en el paralelo " + paralelo + " Meridiano " +
                meridiano + " a una distancia de la tierra de " + distancia_tierra + " kilómetros");
    }
}
