public class CuentaBancaria {
    final private int id;
    private String name;
    private double balance;

    private static double totalBalance = 0.0;

    public CuentaBancaria() {
        this(0, "", 0.0);
    }

    public CuentaBancaria(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = Math.max(balance, 0);

        totalBalance += this.balance;
    }

    public static double saldoTotalCuentas() {
        return totalBalance;
    }

    public int getId() {
        return id;
    }

    public String nombreTitular() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double obtenerSaldo() {
        return balance;
    }

    public void ingressar(final double amount) {
        if (amount >= 0) {
            this.balance += amount;
            totalBalance += amount;
        }
    }

    public void retirar(final double amount) {
        if (amount >= 0 && this.balance >= amount) {
            this.balance -= amount;
            totalBalance -= amount;
        }
    }
}
