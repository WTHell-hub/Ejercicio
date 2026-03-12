public class NodoFamiliar {
    private Persona persona;
    private int cantidad;
    private NodoFamiliar[] hijos;
    private NodoFamiliar papa;

    public NodoFamiliar(Persona persona, int max) {
        this.persona = persona;
        this.cantidad = 0;
        this.hijos = new NodoFamiliar[max];
        this.papa = null;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public NodoFamiliar[] getHijos() {
        return hijos;
    }

    public NodoFamiliar getHijo(int i) {
        if (i >= 0 && i < cantidad) {
            return hijos[i];
        }
        return null;
    }

    public void setHijo(int i, NodoFamiliar h) {
        if (i >= 0 && i < hijos.length) {
            hijos[i] = h;
            if (h != null) {
                cantidad++;
            }
        }
    }

    public void addHijo(NodoFamiliar h) {
        if (cantidad < hijos.length) {
            hijos[cantidad] = h;
            h.setPapa(this);
            cantidad++;
        } else {
            System.out.println("No caben mas hijos");
        }
    }

    public NodoFamiliar getPapa() {
        return papa;
    }

    public void setPapa(NodoFamiliar papa) {
        this.papa = papa;
    }

    public boolean esHoja() {
        return cantidad == 0;
    }
}