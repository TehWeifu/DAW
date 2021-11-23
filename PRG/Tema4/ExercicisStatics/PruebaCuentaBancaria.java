class PruebaCuentaBancaria {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria(1, "Juan Perez", 0);
        CuentaBancaria cuenta2 = new CuentaBancaria(2, "Luis Soriano", 100);
        CuentaBancaria cuenta3 = new CuentaBancaria(3, "Fautino Perez", 5000);

        cuenta1.ingressar(200);
        cuenta2.ingressar(100);
        cuenta3.retirar(300);
        cuenta1.ingressar(1000);

        System.out.println(cuenta1.nombreTitular() + ": " + cuenta1.obtenerSaldo());
        System.out.println(cuenta2.nombreTitular() + ": " + cuenta2.obtenerSaldo());
        System.out.println(cuenta3.nombreTitular() + ": " + cuenta3.obtenerSaldo());

        System.out.println(CuentaBancaria.saldoTotalCuentas());
    }
}