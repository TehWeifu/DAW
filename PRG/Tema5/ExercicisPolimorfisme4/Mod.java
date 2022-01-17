public class Mod extends User {
    private int deletedPosts;

    public Mod(final String mail, final String nick) {
        this(0, mail, nick, 0);
    }

    public Mod(final int messages, final String mail, final String nick, final int deletedPosts) {
        super(messages, mail, nick);
        this.deletedPosts = Math.max(deletedPosts, 0);
    }

    public Mod addDeletedPost() {
        deletedPosts++;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s: %d",
                super.toString(),
                "Numero de Posts Borrados", deletedPosts);
    }
}
