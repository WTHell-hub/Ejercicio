public class ArbolTorneo {
    private NodoPartido cabeza;
    private PilaEnlace<String> pilaGanadores;
    private int numTorneo;

    public ArbolTorneo(String[] equipos, int numTorneo) {
        if (equipos.length != 8) {
            System.out.println("Error: necesitas 8 equipos");
            return;
        }

        this.numTorneo = numTorneo;
        this.pilaGanadores = new PilaEnlace<>();

        NodoPartido c1 = new NodoPartido(equipos[0], equipos[1]);
        NodoPartido c2 = new NodoPartido(equipos[2], equipos[3]);
        NodoPartido c3 = new NodoPartido(equipos[4], equipos[5]);
        NodoPartido c4 = new NodoPartido(equipos[6], equipos[7]);

        NodoPartido s1 = new NodoPartido(c1, c2, "Semis");
        NodoPartido s2 = new NodoPartido(c3, c4, "Semis");

        this.cabeza = new NodoPartido(s1, s2, "Final");

        System.out.println("Torneo #" + numTorneo + " listo");
    }

    public void jugarTorneo() {
        System.out.println("\nTorneo #" + numTorneo);

        System.out.println("\nCuartos:");
        jugarCuartos(cabeza.getIzq().getIzq());
        jugarCuartos(cabeza.getIzq().getDer());
        jugarCuartos(cabeza.getDer().getIzq());
        jugarCuartos(cabeza.getDer().getDer());

        System.out.println("\nSemis:");
        jugarSemis(cabeza.getIzq());
        jugarSemis(cabeza.getDer());

        System.out.println("\nFinal:");
        jugarFinal(cabeza);

        String campeon = cabeza.getGanador();
        pilaGanadores.push(campeon);
        System.out.println("\nCampeon: " + campeon);
    }

    private void jugarCuartos(NodoPartido nodo) {
        double r = Math.random();
        String gana = (r < 0.5) ? nodo.getEq1() : nodo.getEq2();
        nodo.setGanador(gana);
        System.out.println("  " + nodo);
    }

    private void jugarSemis(NodoPartido nodo) {
        String g1 = nodo.getIzq().getGanador();
        String g2 = nodo.getDer().getGanador();

        nodo.setEq1(g1);
        nodo.setEq2(g2);

        double r = Math.random();
        String gana = (r < 0.5) ? g1 : g2;
        nodo.setGanador(gana);

        System.out.println("  " + nodo);
    }

    private void jugarFinal(NodoPartido nodo) {
        String f1 = nodo.getIzq().getGanador();
        String f2 = nodo.getDer().getGanador();

        nodo.setEq1(f1);
        nodo.setEq2(f2);

        double r = Math.random();
        String gana = (r < 0.5) ? f1 : f2;
        nodo.setGanador(gana);

        System.out.println("  " + nodo);
    }

    public String dameCampeon() {
        if (cabeza != null && cabeza.getGanador() != null) {
            return cabeza.getGanador();
        }
        return "No hay";
    }

    public void verTodo() {
        System.out.println("\nTorneo #" + numTorneo + "\n");

        System.out.println("Cuartos:");
        verPartido(cabeza.getIzq().getIzq());
        verPartido(cabeza.getIzq().getDer());
        verPartido(cabeza.getDer().getIzq());
        verPartido(cabeza.getDer().getDer());

        System.out.println("\nSemis:");
        verPartido(cabeza.getIzq());
        verPartido(cabeza.getDer());

        System.out.println("\nFinal:");
        verPartido(cabeza);

        System.out.println("\nCampeon: " + dameCampeon());
    }

    private void verPartido(NodoPartido nodo) {
        if (nodo.getGanador() != null) {
            System.out.println("  " + nodo.getRonda() + ": " +
                    nodo.getEq1() + " vs " + nodo.getEq2() +
                    " -> " + nodo.getGanador());
        }
    }
}