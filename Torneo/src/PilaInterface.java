public interface PilaInterface<T> {
    void push(T item);
    T top();
    T pop();
    boolean vacia();
}