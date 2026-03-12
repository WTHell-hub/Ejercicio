public class NodoLista<E> {
    protected E dato;
    protected NodoLista<E> next;

    public NodoLista(E dato) {
        this.dato = dato;
        this.next = null;
    }

    public NodoLista(E dato, NodoLista<E> next) {
        this.dato = dato;
        this.next = next;
    }

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }

    public NodoLista<E> getNext() {
        return next;
    }

    public void setNext(NodoLista<E> next) {
        this.next = next;
    }
}