public class NodoPartido {
    private String eq1;
    private String eq2;
    private String ganador;
    private String ronda;

    private NodoPartido izq;
    private NodoPartido der;

    public NodoPartido(String eq1, String eq2) {
        this.eq1 = eq1;
        this.eq2 = eq2;
        this.ganador = null;
        this.ronda = "Cuartos";
        this.izq = null;
        this.der = null;
    }

    public NodoPartido(NodoPartido izq, NodoPartido der, String ronda) {
        this.izq = izq;
        this.der = der;
        this.eq1 = null;
        this.eq2 = null;
        this.ganador = null;
        this.ronda = ronda;
    }

    public String getEq1() { return eq1; }
    public void setEq1(String eq1) { this.eq1 = eq1; }

    public String getEq2() { return eq2; }
    public void setEq2(String eq2) { this.eq2 = eq2; }

    public String getGanador() { return ganador; }
    public void setGanador(String ganador) { this.ganador = ganador; }

    public String getRonda() { return ronda; }

    public NodoPartido getIzq() { return izq; }
    public NodoPartido getDer() { return der; }

    public String getEquipos() {
        if (eq1 != null && eq2 != null) {
            return eq1 + " vs " + eq2;
        }
        return "? vs ?";
    }

    public String toString() {
        if (ganador != null) {
            return ronda + ": " + getEquipos() + " -> " + ganador;
        }
        return ronda + ": " + getEquipos() + " -> pendiente";
    }
}