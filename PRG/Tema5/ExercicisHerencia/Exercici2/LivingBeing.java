public class LivingBeing {
    private byte age;

    public LivingBeing(final byte age) {
        this.age = (byte) Math.max(age, 0);
    }

    public byte getAge() {
        return age;
    }

    public LivingBeing setAge(final byte age) {
        this.age = (byte) Math.max(age, 0);
        return this;
    }

    public boolean equals(LivingBeing obj) {
        return this == obj || this.age == obj.age;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s: %d",
                "Ser vivo",
                "Edat", age);
    }
}
