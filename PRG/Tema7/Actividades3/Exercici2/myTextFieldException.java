public class myTextFieldException extends RuntimeException {
    public myTextFieldException() {
        super();
    }

    public myTextFieldException(final String message) {
        super(message);
    }

    public myTextFieldException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public myTextFieldException(final Throwable cause) {
        super(cause);
    }
}
