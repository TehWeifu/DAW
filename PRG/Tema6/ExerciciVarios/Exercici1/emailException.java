public class emailException extends IllegalArgumentException {
    public emailException() {
        super();
    }

    public emailException(final String s) {
        super(s);
    }

    public emailException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public emailException(final Throwable cause) {
        super(cause);
    }
}
