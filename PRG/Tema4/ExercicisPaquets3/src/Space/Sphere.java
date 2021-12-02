package Space;

public class Sphere {
    private double radius;
    private double area;

    // Constructor that receives a radius to initialize both the side and the area of the object
    // Validates the side to be a positive number
    public Sphere(final double radius) {
        this.radius = Math.max(radius, 0);
        this.area = calculateArea(this.radius);
    }

    // Setters and Getters
    // Setters return a self-reference to enable method chaining
    public double getRadius() {
        return radius;
    }

    // Validates the radius to be a positive number
    // Updates the area value with the new side value
    public Sphere setRadius(double radius) {
        this.radius = Math.max(radius, 0);
        this.area = calculateArea(this.radius);
        return this;
    }

    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "radius=" + String.format("%,.2f", radius) +
                ", area=" + String.format("%,.2f", area) +
                '}';
    }

    private static double calculateArea(final double radius) {
        return Math.PI * Math.pow(radius, 3) * 4 / 3;
    }
}
