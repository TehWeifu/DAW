public class companyException extends RuntimeException {
    public companyException() {
        super();
    }

    public companyException(final String message) {
        super(message);
    }

    public companyException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public companyException(final Throwable cause) {
        super(cause);
    }
}
