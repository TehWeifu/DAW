public class Circle {
    private final double radius;
    private final String color;

    public Circle() {
        this(1.0, "red");
    }

    public Circle(final double radius, final String color) {
        this.radius = Math.max(radius, 0.0);
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(getRadius(), 2);
    }
}
