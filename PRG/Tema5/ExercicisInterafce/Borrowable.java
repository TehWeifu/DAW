public interface Borrowable {
    void borrow();

    void returned();

    boolean isBorrowed();
}
