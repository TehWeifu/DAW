public class Box {
    private double length;
    private double height;
    private double width;

    public Box() {
        this(0.0, 0.0, 0.0);
    }

    public Box(final double length, final double height, final double width) {
        this.length = Math.max(length, 0.0);
        this.height = Math.max(height, 0.0);
        this.width = Math.max(width, 0.0);
    }

    public double getLength() {
        return length;
    }

    public Box setLength(final double length) {
        this.length = Math.max(length, 0.0);
        return this;
    }

    public double getHeight() {
        return height;
    }

    public Box setHeight(final double height) {
        this.height = Math.max(height, 0.0);
        return this;
    }

    public double getWidth() {
        return width;
    }

    public Box setWidth(final double width) {
        this.width = Math.max(width, 0.0);
        return this;
    }

    public double getVolume() {
        return this.height * this.width * this.length;
    }
}
