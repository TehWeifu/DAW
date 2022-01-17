public class User {
    private int messages;
    private String mail;
    private final String nick;

    public User(final String mail, final String nick) {
        this(0, mail, nick);
    }

    public User(final int messages, final String mail, final String nick) {
        this.messages = Math.max(messages, 0);
        this.mail = mail;
        this.nick = nick;
    }

    public int getMessages() {
        return messages;
    }

    public String getMail() {
        return mail;
    }

    public String getNick() {
        return nick;
    }

    public User addMessage() {
        messages++;
        return this;
    }

    public User decreaseMessage() {
        messages = Math.max(messages - 1, 0);
        return this;
    }

    public User setMail(final String mail) {
        this.mail = mail;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s: %s%n%s: %s%n%s: %d",
                "Nick", nick,
                "E-Mail", mail,
                "Numero de mensajes", messages);
    }
}
