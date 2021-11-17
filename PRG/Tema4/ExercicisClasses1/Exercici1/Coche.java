public class Coche {
    private int velocidad;

    public Coche() {
        this.velocidad = 0;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void acelera(int mas) {
        this.velocidad += mas;
    }

    public void frena(int menos) {
        this.velocidad -= menos;
        if (this.getVelocidad() < 0) this.velocidad = 0;
    }
}
