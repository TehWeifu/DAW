public class notaMalException extends IllegalArgumentException {
    public notaMalException() {
        super();
    }

    public notaMalException(final String s) {
        super(s);
    }

    public notaMalException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public notaMalException(final Throwable cause) {
        super(cause);
    }
}
