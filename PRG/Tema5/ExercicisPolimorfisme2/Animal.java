public class Animal {
    private String nombre;

    public Animal(final String nombre) {
        this.nombre = nombre;

        System.out.println("Constructor Animal, nombre del animal: " + nombre);
    }

    public void tipoAnimal() {
        if (this instanceof Gato) {
            System.out.println("Tipo Animal: Es un Gato");
        }

        if (this instanceof Perro) {
            System.out.println("Tipo Animal: Es un Perro");
        }
    }

    public String getNombre() {
        return nombre;
    }
}
