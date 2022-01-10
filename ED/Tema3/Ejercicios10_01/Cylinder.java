public class Cylinder extends Circle {
    private final double height;

    public Cylinder() {
        this(1.0, 1.0);
    }

    public Cylinder(final double radius) {
        this(radius, 1.0);
    }

    public Cylinder(final double radius, final double height) {
        super(radius, "red");
        this.height = Math.max(height, 0.0);
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return Math.PI * Math.pow(this.getRadius(), 2) * this.getHeight();
    }
}
