public class Main {
    public static void main(String[] args) {

        System.out.println("SISTEMA ARBOL GENEALOGICO - FAMILIA RODRÍGUEZ\n");

        ArbolGenealogico familia = new ArbolGenealogico();


        familia.addRoot("José Rodríguez", "15/03/1950", 'M', 3);

        familia.addChild("José Rodríguez", "María Rodríguez", "20/07/1975", 'F', 2);
        familia.addChild("José Rodríguez", "Carlos Rodríguez", "10/11/1978", 'M', 3);
        familia.addChild("José Rodríguez", "Ana Rodríguez", "05/02/1982", 'F', 2);

        familia.addChild("María Rodríguez", "Pedro Rodríguez", "12/04/2000", 'M', 0);
        familia.addChild("María Rodríguez", "Lucía Rodríguez", "25/09/2003", 'F', 0);

        familia.addChild("Carlos Rodríguez", "Andrés Rodríguez", "30/06/2005", 'M', 0);
        familia.addChild("Carlos Rodríguez", "Valentina Rodríguez", "18/01/2008", 'F', 0);
        familia.addChild("Carlos Rodríguez", "Mateo Rodríguez", "22/11/2010", 'M', 0);

        familia.addChild("Ana Rodríguez", "Camila Rodríguez", "07/03/2012", 'F', 0);
        familia.addChild("Ana Rodríguez", "Nicolás Rodríguez", "19/08/2015", 'M', 0);

        familia.addChild("Andrés Rodríguez", "Sofía Rodríguez", "10/05/2030", 'F', 0);


        familia.showTree();
        familia.recorridoXGen();
        familia.showDepth();

        familia.showAncestros("Andrés Rodríguez");
        familia.showAncestros("Sofía Rodríguez");
        familia.showAncestros("José Rodríguez");
        familia.showAncestros("Xxx Xxx");

        familia.showDescendientes("Carlos Rodríguez");
        familia.showDescendientes("María Rodríguez");
        familia.showDescendientes("Andrés Rodríguez");

        System.out.println("\nPRUEBA BORRADO");

        familia.deleteBranch("Ana Rodríguez");

        System.out.println("\nDespués de borrar:");
        familia.showTree();
        familia.showDepth();

        familia.deleteBranch("Camila Rodríguez");
    }
}