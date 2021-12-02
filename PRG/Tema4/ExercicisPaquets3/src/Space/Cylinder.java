package Space;

public class Cylinder {
    private double radius;
    private double height;
    private double area;

    // Constructor that receives a side to initialize both the side and the area of the object
    // Validates the side to be a positive number
    public Cylinder(double radius, double height) {
        this.radius = Math.max(radius, 0.0);
        this.height = Math.max(height, 0.0);
        this.area = calculateArea(this.radius, this.height);
    }

    // Setters and Getters
    // Setters return a self-reference to enable method chaining
    public double getRadius() {
        return radius;
    }

    // Validates the radius to be a positive number
    // Updates the area value with the new side value
    public Cylinder setRadius(double radius) {
        this.radius = Math.max(radius, 0.0);
        this.area = calculateArea(this.radius, this.height);
        return this;
    }

    public double getHeight() {
        return height;
    }

    // Validates the height to be a positive number
    // Updates the area value with the new side value
    public Cylinder setHeight(double height) {
        this.height = Math.max(height, 0.0);
        this.area = calculateArea(this.radius, this.height);
        return this;
    }

    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "radius=" + String.format("%,.2f", radius) +
                ", height=" + String.format("%,.2f", height) +
                ", area=" + String.format("%,.2f", area) +
                '}';
    }

    private static double calculateArea(final double height, final double radius) {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}
