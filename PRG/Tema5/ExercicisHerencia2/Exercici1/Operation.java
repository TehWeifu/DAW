import java.util.Scanner;

public class Operation {
    public static final Scanner scanner = new Scanner(System.in);

    private double op1;
    private double op2;
    private double result;

    public Operation() {
        this(0.0, 0.0, 0.0);
    }

    private Operation(final double op1, final double op2, final double result) {
        this.op1 = op1;
        this.op2 = op2;
        this.result = result;
    }

    public void cargar1() {
        System.out.print("Introduzca el valor del operador 1: ");
        this.op1 = Double.parseDouble(scanner.nextLine());
    }

    public void cargar2() {
        System.out.print("Introduzca el valor del operador 2: ");
        this.op2 = Double.parseDouble(scanner.nextLine());
    }

    public void mostrarResultado() {
        System.out.println(this.result);
    }

    public double getOp1() {
        return op1;
    }

    public double getOp2() {
        return op2;
    }

    protected Operation setResult(final double result) {
        this.result = result;
        return this;
    }
}
