public class Person {
    private String name;
    private int age;
    private double weight;
    private double height;

    public Person(final String name, final int age, final double weight, final double height) {

        if (age < 0 || age > 130) {
            throw new IllegalArgumentException("La edad ha de estar comprendida entre 0 y 130");
        }
        if (weight < 0 || weight > 500) {
            throw new IllegalArgumentException("El peso ha de estar comprendido entre 0 y 500");
        }
        if (height < 0 || height > 3.0) {
            throw new IllegalArgumentException("La altura ha de estar comprendida entre 0 y 3");
        }

        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public Person setName(final String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(final int age) {
        if (age < 0 || age > 130) {
            throw new IllegalArgumentException("La edad ha de estar comprendida entre 0 y 130");
        }
        this.age = age;
        return this;
    }

    public double getWeight() {
        return weight;
    }

    public Person setWeight(final double weight) {
        if (weight < 0 || weight > 500) {
            throw new IllegalArgumentException("El peso (en kilos) ha de estar comprendido entre 0 y 500");
        }
        this.weight = weight;
        return this;
    }

    public double getHeight() {
        return height;
    }

    public Person setHeight(final double height) {
        if (height < 0 || height > 3.0) {
            throw new IllegalArgumentException("La altura (en metros) ha de estar comprendida entre 0 y 3");
        }
        this.height = height;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s: %s%n%s: %d%n%s: %.2f%n%s: %.2f",
                "Nombre", getName(),
                "Edad", getAge(),
                "Peso", getWeight(),
                "Altura", getHeight());
    }
}
