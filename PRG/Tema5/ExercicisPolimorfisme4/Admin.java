public class Admin extends User {
    private int deletedPosts;
    private int bans;

    public Admin(final String mail, final String nick) {
        this(0, mail, nick, 0, 0);
    }

    public Admin(final int messages, final String mail, final String nick, final int deletedPosts, final int bans) {
        super(messages, mail, nick);
        this.deletedPosts = deletedPosts;
        this.bans = bans;
    }

    public Admin addDeletedPost() {
        deletedPosts++;
        return this;
    }

    public Admin addBan() {
        bans++;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s: %d%n%s: %d",
                super.toString(),
                "Numero de Posts Borrados", deletedPosts,
                "Numero de Usuarios Baneados", bans);
    }
}
