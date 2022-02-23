import java.time.LocalDate;

public class User {
    private String name;
    private String url;
    private LocalDate date;

    public User(final String name, final String url, final LocalDate date) {
        this.name = name;
        this.url = url;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public User setName(final String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public User setUrl(final String url) {
        this.url = url;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public User setDate(final LocalDate date) {
        this.date = date;
        return this;
    }
}
