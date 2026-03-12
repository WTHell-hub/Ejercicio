public class Main {
    public static void main(String[] args) {

        System.out.println("Simulador");

        String[] equipos = {
                "Brasil", "Argentina", "Francia", "Alemania",
                "España", "Italia", "Inglaterra", "Holanda"
        };

        System.out.println("Equipos:");
        for (int i = 0; i < equipos.length; i++) {
            System.out.println("  " + (i+1) + ". " + equipos[i]);
        }

        PilaEnlace<String> pilaGlobal = new PilaEnlace<>();

        int total = 5;
        ArbolTorneo[] torneos = new ArbolTorneo[total];

        for (int i = 0; i < total; i++) {
            System.out.println("\n--- Torneo #" + (i+1) + " ---");

            torneos[i] = new ArbolTorneo(equipos, i+1);
            torneos[i].jugarTorneo();

            String campeon = torneos[i].dameCampeon();
            pilaGlobal.push(campeon);
        }

        String ultimo = pilaGlobal.top();
        System.out.println("\nUltimo campeon: " + ultimo);

        System.out.println("\nHistorial (al reves):");
        PilaEnlace<String> pilaTemp = new PilaEnlace<>();
        int cont = 1;

        while (!pilaGlobal.vacia()) {
            String campeon = pilaGlobal.pop();
            System.out.println("#" + cont + ": " + campeon);
            pilaTemp.push(campeon);
            cont++;
        }

        while (!pilaTemp.vacia()) {
            String campeon = pilaTemp.pop();
            pilaGlobal.push(campeon);
        }

        System.out.println("\nDetalles:");
        for (int i = 0; i < total; i++) {
            torneos[i].verTodo();
        }
    }
}