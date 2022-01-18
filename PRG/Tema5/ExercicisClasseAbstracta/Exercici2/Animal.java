public abstract class Animal {
    private String nombre;

    public Animal(final String nombre) {
        this.nombre = nombre;

        System.out.println("Constructor Animal, nombre del animal: " + nombre);
    }

    public abstract void tipoAnimal();

    public String getNombre() {
        return nombre;
    }
}
