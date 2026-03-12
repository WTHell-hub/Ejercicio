public class PilaEnlace<T> implements PilaInterface<T> {
    private NodoLista<T> cima;

    public PilaEnlace() {
        this.cima = null;
    }

    public boolean vacia() {
        return cima == null;
    }

    public void push(T item) {
        NodoLista<T> n = new NodoLista<>(item);
        if (vacia()) {
            cima = n;
        } else {
            n.setNext(cima);
            cima = n;
        }
    }

    public T top() {
        if (vacia()) {
            return null;
        } else {
            return cima.getDato();
        }
    }

    public T pop() {
        if (vacia()) {
            return null;
        } else {
            T aux = cima.getDato();
            cima = cima.getNext();
            return aux;
        }
    }
}