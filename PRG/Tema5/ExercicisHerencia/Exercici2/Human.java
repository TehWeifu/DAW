public class Human extends LivingBeing {
    private String name;

    public Human(final String name, final byte age) {
        super(age);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Human setName(final String name) {
        this.name = name;
        return this;
    }

    public boolean equals(final Human obj) {
        if (this == obj) return true;
        return (super.equals(obj) && this.name.compareTo(obj.name) == 0);
    }

    public Human greater(final Human obj) {
        if (obj.getAge() > this.getAge()) return obj;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n%s: %s",
                "Humano", super.toString(),
                "Edad", name);
    }
}
