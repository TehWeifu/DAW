public class Cliente {
    final private int id;
    private String firstName;
    private String lastName;
    private String metal;

    private static int totalObjs = 0;

    public Cliente(int id, String firstName, String lastName, String metal) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.metal = metal;

        totalObjs++;
    }

    public int getId() {
        return id;
    }

    public String NombreCliente() {
        return firstName;
    }

    public Cliente setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Cliente setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getMetal() {
        return metal;
    }

    public Cliente setMetal(String metal) {
        this.metal = metal;
        return this;
    }

    public String MuestraDatos() {
        return String.format("%s. %s %s. %s", this.id, this.firstName, this.lastName, this.metal);
    }

    public static int TotalClientes() {
        return totalObjs;
    }
}

