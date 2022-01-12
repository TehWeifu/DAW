public class Book {
    private String title;

    public Book() {
        this(null);
    }

    public Book(final String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
