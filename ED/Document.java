import java.util.Arrays;
import java.util.Date;

public class Document {
    private String[] authors;
    private Date date;

    public Document() {
        this(new String[1], null);
    }

    public Document(final String[] authors, final Date date) {
        this.authors = authors;
        this.date = date;
    }

    public String[] getAuthors() {
        return Arrays.copyOf(authors, authors.length);
    }

    public void addAuthor(final String name) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) {
                authors[i] = name;
                return;
            }
        }

        authors = Arrays.copyOf(authors, authors.length + 1);
        authors[authors.length - 1] = name;
    }

    public Date getDate() {
        return date;
    }
}
