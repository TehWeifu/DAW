public class Book extends Publication {
    private boolean borrowed;

    public Book(final int id, final String title, final int yearPublished) {
        super(id, title, yearPublished);
        this.borrowed = false;
    }

    @Override
    public void borrow() {
        this.borrowed = true;
    }

    @Override
    public void returned() {
        this.borrowed = false;
    }

    @Override
    public boolean isBorrowed() {
        return this.borrowed;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s%n%s: %b%n",
                "Libro",
                super.toString(),
                "Prestat", isBorrowed());
    }
}
