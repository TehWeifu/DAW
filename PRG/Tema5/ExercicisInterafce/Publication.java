public abstract class Publication implements Borrowable {
    private final int id;
    private String title;
    private int yearPublished;

    public Publication(final int id, final String title, final int yearPublished) {
        this.id = id;
        this.title = title;
        this.yearPublished = yearPublished;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Publication setTitle(final String title) {
        this.title = title;
        return this;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public Publication setYearPublished(final int yearPublished) {
        this.yearPublished = yearPublished;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s: %d%n%s: %s%n%s: %s",
                "ID", getId(),
                "Títol", getTitle(),
                "Any de publicació", getYearPublished());
    }
}
