package Space;

public class Cube {
    private double side;
    private double area;

    // Constructor that receives a side to initialize both the side and the area of the object
    // Validates the side to be a positive number
    public Cube(final double side) {
        this.side = Math.max(side, 0.0);
        this.area = calculateArea(this.side);

    }

    // Setters and Getters
    // Setters return a self-reference to enable method chaining
    public double getSide() {
        return side;
    }

    // Validates the side to be a positive number
    // Updates the area value with the new side value
    public Cube setSide(double side) {
        this.side = Math.max(side, 0.0);
        this.area = calculateArea(this.side);
        return this;
    }

    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "Cube{" +
                "side=" + String.format("%,.2f", side) +
                ", area=" + String.format("%,.2f", area) +
                '}';
    }

    private static double calculateArea(final double side) {
        return Math.pow(side, 3);
    }
}
