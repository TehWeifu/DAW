public class PruebaCliente {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(1, "Juan", "Perez Goñi", "Oro");
        Cliente cliente2 = new Cliente(2, "Luis", "Soriano Garcia", "Plata");
        Cliente cliente3 = new Cliente(3, "Fautino", "Perez Perez", "");
        System.out.println(cliente1.NombreCliente() + ": " + cliente1.MuestraDatos());
        System.out.println(cliente2.NombreCliente() + ": " + cliente2.MuestraDatos());
        System.out.println(cliente3.NombreCliente() + ": " + cliente3.MuestraDatos());
        System.out.println(Cliente.TotalClientes());
    }
}

