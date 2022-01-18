public class Perro extends Animal {
    public Perro(final String nombre) {
        super(nombre);

        System.out.println("Constructor Perro, nombre: " + this.getNombre());
    }

    @Override
    public void tipoAnimal() {
        System.out.println("Tipo Animal: Es un Perro");
    }
}
