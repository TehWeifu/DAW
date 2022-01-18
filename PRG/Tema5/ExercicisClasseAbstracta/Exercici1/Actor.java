public class Actor extends Persona {
    private String pelicula;

    public Actor(String nombre, String pelicula) {
        // Esta clase no puede inicializar la propiedad "nombre" directamente. Tiene que delegar en el superconstructor
        super(nombre);

        this.pelicula = pelicula;
    }

    public String getPelicula() {
        return pelicula;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s: %s%n",
                super.toString(),
                "Pelicula", pelicula);
    }
}
