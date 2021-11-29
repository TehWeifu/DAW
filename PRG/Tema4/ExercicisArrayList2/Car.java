public class Car {
    private String plateNum;
    private String brand;
    private String model;
    private double kms;

    private static int carCount = 0;

    // Three-parameter constructor that delegates on main constructo
    public Car(final String plateNum, final String brand, final String model) {
        this(plateNum, brand, model, 0.0);
    }

    // Main constructor to initialize every dynamic variable
    // Validates plateNum to be a valid code by using helper method
    // Validates kms to be a positive number
    public Car(final String plateNum, final String brand, final String model, final double kms) {
        this.plateNum = (isPlateNumValid(plateNum) ? plateNum.replaceAll(" ", "").toUpperCase() : "0000AAA");
        this.brand = brand;
        this.model = model;
        this.kms = Math.max(kms, 0.0);

        increaseCarCount();
    }

    // Getters & Setters for each property
    // Setters return a self-reference to enable method chaining
    public String getPlateNum() {
        return plateNum;
    }

    // Validates plateNum to be a valid code by using helper method
    // Establishes a XXXX-000 format to store the plateNum
    public Car setPlateNum(final String plateNum) {
        this.plateNum = (isPlateNumValid(plateNum) ? plateNum.replaceAll(" ", "").toUpperCase() : "0000AAA");
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public Car setBrand(final String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(final String model) {
        this.model = model;
        return this;
    }

    public double getKms() {
        return kms;
    }

    // Validates kms to be a positive number
    public Car setKms(final double kms) {
        this.kms = Math.max(kms, 0);
        return this;
    }

    public static int getCarCount() {
        return carCount;
    }

    public static void increaseCarCount() {
        carCount++;
    }

    public static void decreaseCarCount() {
        carCount--;
    }

    public static boolean isPlateNumValid(final String plateNum) {
        return plateNum.replaceAll(" ", "").matches("^\\d{4}[A-Za-z]{3}$");
    }
}
