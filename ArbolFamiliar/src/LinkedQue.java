public class LinkedQue<T> {
    private Nodo<T> front;
    private Nodo<T> rear;

    public LinkedQue() {
        this.front = null;
        this.rear = null;
    }

    public boolean empty() {
        return front == null;
    }

    public void enqueue(T item) {
        Nodo<T> n = new Nodo<>(item);

        if (empty()) {
            front = n;
            rear = n;
        } else {
            rear.setNext(n);
            rear = n;
        }
    }

    public T dequeue() {
        if (empty()) {
            return null;
        } else {
            T tmp = front.getData();
            front = front.getNext();

            if (front == null) {
                rear = null;
            }

            return tmp;
        }
    }

    public T peek() {
        if (empty()) {
            return null;
        } else {
            return front.getData();
        }
    }

    public int count() {
        int c = 0;
        Nodo<T> curr = front;

        while (curr != null) {
            c++;
            curr = curr.getNext();
        }

        return c;
    }
}