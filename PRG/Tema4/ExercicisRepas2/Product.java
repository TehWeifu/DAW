// Class that represents a product
// Has a static variable to keep track of the quantity of all objects created

public class Product {
    private String name;
    private String category;
    private long quantity;

    private static long totalQuantity = 0;
    private static int totalCount = 0;

    // Two-parameter constructor that delegates on the main constructor
    public Product(final String name, final String category) {
        this(name, category, 0);
    }

    // Main constructor that initializes the properties to the arguments values
    // Validates quantity to be a positive number
    // Updates the static variables
    public Product(final String name, final String category, final long quantity) {
        this.name = name;
        this.category = category;
        this.quantity = Math.max(quantity, 0);

        totalQuantity += this.quantity;
        totalCount++;
    }

    // Setters and Getters
    // Setters return a self-reference to enable chaining
    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Product setCategory(String category) {
        this.category = category;
        return this;
    }

    public long getQuantity() {
        return quantity;
    }

    // Valides the quantity to be a positive number
    // Updates the static total quantity with the new value
    public Product setQuantity(final long quantity) {
        totalQuantity -= this.quantity;

        this.quantity = Math.max(quantity, 0);

        totalQuantity += this.quantity;
        return this;
    }

    public static long getTotalQuantity() {
        return totalQuantity;
    }

    public static int getTotalCount() {
        return totalCount;
    }

    public static void decreaseCount() {
        totalCount--;
    }
}
