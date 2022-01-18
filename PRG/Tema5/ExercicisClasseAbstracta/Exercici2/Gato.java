public class Gato extends Animal {
    public Gato(final String nombre) {
        super(nombre);

        System.out.println("Constructor Gato, nombre: " + this.getNombre());
    }

    @Override
    public void tipoAnimal() {
        System.out.println("Tipo Animal: Es un Gato");
    }
}
