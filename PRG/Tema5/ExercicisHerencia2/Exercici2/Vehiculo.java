public class Vehiculo {
    private String name;

    public Vehiculo() {
        this(null);
    }

    public Vehiculo(final String name) {
        this.name = name;
    }

    public void setnombreVehiculo(final String name) {
        this.name = name;
    }

    public String getnombreVehiculo() {
        return name;
    }

    public String transportar() {
        return "Método transportar de la clase Vehiculo";
    }
}
