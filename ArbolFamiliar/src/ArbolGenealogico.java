public class ArbolGenealogico {
    private NodoFamiliar root;

    public ArbolGenealogico() {
        this.root = null;
    }

    public void addRoot(String nombre, String fecha, char sexo, int max) {
        if (root == null) {
            Persona p = new Persona(nombre, fecha, sexo);
            root = new NodoFamiliar(p, max);
            System.out.println("Raiz: " + nombre);
        } else {
            System.out.println("Ya hay raiz");
        }
    }

    public void addChild(String padre, String nombre, String fecha, char sexo, int max) {
        NodoFamiliar n = findNode(padre);

        if (n != null) {
            Persona p = new Persona(nombre, fecha, sexo);
            NodoFamiliar child = new NodoFamiliar(p, max);
            n.addHijo(child);
            System.out.println(nombre + " hijo de " + padre);
        } else {
            System.out.println("No existe " + padre);
        }
    }

    private NodoFamiliar findNode(String nombre) {
        return findNodeRec(root, nombre);
    }

    private NodoFamiliar findNodeRec(NodoFamiliar curr, String nombre) {
        if (curr == null) return null;

        if (curr.getPersona().getNombre().equals(nombre)) {
            return curr;
        }

        for (int i = 0; i < curr.getCantidad(); i++) {
            NodoFamiliar found = findNodeRec(curr.getHijo(i), nombre);
            if (found != null) return found;
        }

        return null;
    }

    public void showAncestros(String nombre) {
        System.out.println("\nAncestros de " + nombre + ":");
        NodoFamiliar n = findNode(nombre);

        if (n == null) {
            System.out.println("  No existe");
            return;
        }

        LinkedQue<String> q = new LinkedQue<>();
        NodoFamiliar curr = n.getPapa();
        boolean hay = false;

        while (curr != null) {
            q.enqueue(curr.getPersona().getNombre());
            curr = curr.getPapa();
            hay = true;
        }

        if (!hay) {
            System.out.println("  No tiene (es la raiz)");
        } else {
            int pos = 1;
            while (!q.empty()) {
                System.out.println("  Gen " + pos + ": " + q.dequeue());
                pos++;
            }
        }
    }

    public void showDescendientes(String nombre) {
        System.out.println("\nDescendientes de " + nombre + ":");
        NodoFamiliar n = findNode(nombre);

        if (n == null) {
            System.out.println("  No existe");
            return;
        }

        if (n.esHoja()) {
            System.out.println("  No tiene");
            return;
        }

        LinkedQue<NodoFamiliar> q = new LinkedQue<>();
        for (int i = 0; i < n.getCantidad(); i++) {
            q.enqueue(n.getHijo(i));
        }

        int c = 1;
        while (!q.empty()) {
            NodoFamiliar curr = q.dequeue();
            System.out.println("  " + c + ". " + curr.getPersona().getNombre());

            for (int i = 0; i < curr.getCantidad(); i++) {
                q.enqueue(curr.getHijo(i));
            }
            c++;
        }
    }

    public void deleteBranch(String nombre) {
        System.out.println("\nBorrando " + nombre + "...");
        NodoFamiliar n = findNode(nombre);

        if (n == null) {
            System.out.println("  No existe");
            return;
        }

        if (n == root) {
            root = null;
            System.out.println("  Se borro todo");
            return;
        }

        NodoFamiliar p = n.getPapa();
        if (p != null) {
            NodoFamiliar[] hijos = p.getHijos();
            for (int i = 0; i < p.getCantidad(); i++) {
                if (hijos[i] != null && hijos[i].getPersona().getNombre().equals(nombre)) {
                    hijos[i] = null;

                    for (int j = i; j < p.getCantidad() - 1; j++) {
                        hijos[j] = hijos[j + 1];
                    }
                    hijos[p.getCantidad() - 1] = null;
                    p.setCantidad(p.getCantidad() - 1);
                    break;
                }
            }
            System.out.println("  Borrado");
        }
    }

    public void showDepth() {
        System.out.println("\nProfundidad: " + calcDepth(root));
    }

    private int calcDepth(NodoFamiliar n) {
        if (n == null) return 0;

        int max = 0;
        for (int i = 0; i < n.getCantidad(); i++) {
            int d = calcDepth(n.getHijo(i));
            if (d > max) max = d;
        }

        return max + 1;
    }

    public void recorridoXGen() {
        System.out.println("\nPor generaciones:");

        if (root == null) {
            System.out.println("  Vacio");
            return;
        }

        LinkedQue<NodoFamiliar> q = new LinkedQue<>();
        q.enqueue(root);
        int g = 1;

        while (!q.empty()) {
            int level = q.count();
            System.out.print("  Gen " + g + ": ");

            for (int i = 0; i < level; i++) {
                NodoFamiliar curr = q.dequeue();
                System.out.print(curr.getPersona().getNombre());

                for (int j = 0; j < curr.getCantidad(); j++) {
                    q.enqueue(curr.getHijo(j));
                }

                if (i < level - 1) System.out.print(", ");
            }
            System.out.println();
            g++;
        }
    }

    public void showTree() {
        System.out.println("\n\tARBOL");
        if (root == null) {
            System.out.println("Vacio");
            return;
        }
        showTreeRec(root, 0);
    }

    private void showTreeRec(NodoFamiliar n, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }

        System.out.println("- " + n.getPersona().getNombre() +
                " (" + n.getPersona().getNacimiento() + ")");

        for (int i = 0; i < n.getCantidad(); i++) {
            showTreeRec(n.getHijo(i), level + 1);
        }
    }
}