public class Gato extends Animal {
    public Gato(final String nombre) {
        super(nombre);

        System.out.println("Constructor Gato, nombre: " + this.getNombre());
    }
}
