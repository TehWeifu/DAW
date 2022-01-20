public class Magazine extends Publication {
    private int numberBorrowed;

    public Magazine(final int id, final String title, final int yearPublished, final int numberBorrowed) {
        super(id, title, yearPublished);
        this.numberBorrowed = numberBorrowed;
    }

    @Override
    public void borrow() {
        this.numberBorrowed = 1;
    }

    @Override
    public void returned() {
        this.numberBorrowed = 0;
    }

    @Override
    public boolean isBorrowed() {
        return numberBorrowed == 1;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s%n%s: %b(%d)%n",
                "Revista",
                super.toString(),
                "Prestado", isBorrowed(), this.numberBorrowed);
    }
}
