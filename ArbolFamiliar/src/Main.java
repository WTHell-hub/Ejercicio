public class Main {
    public static void main(String[] args) {

        System.out.println("SISTEMA ARBOL GENEALOGICO\n");

        ArbolGenealogico fam = new ArbolGenealogico();


        fam.addRoot("Carlos Ruiz", "15/03/1950", 'M', 3);

        fam.addChild("Carlos Ruiz", "Ana Ruiz", "20/07/1975", 'F', 2);
        fam.addChild("Carlos Ruiz", "Luis Ruiz", "10/11/1978", 'M', 3);
        fam.addChild("Carlos Ruiz", "Marta Ruiz", "05/02/1982", 'F', 2);

        fam.addChild("Ana Ruiz", "Pedro Ruiz", "12/04/2000", 'M', 0);
        fam.addChild("Ana Ruiz", "Sofia Ruiz", "25/09/2003", 'F', 0);

        fam.addChild("Luis Ruiz", "Diego Ruiz", "30/06/2005", 'M', 0);
        fam.addChild("Luis Ruiz", "Valentina Ruiz", "18/01/2008", 'F', 0);
        fam.addChild("Luis Ruiz", "Javier Ruiz", "22/11/2010", 'M', 0);

        fam.addChild("Marta Ruiz", "Camila Ruiz", "07/03/2012", 'F', 0);
        fam.addChild("Marta Ruiz", "Nicolas Ruiz", "19/08/2015", 'M', 0);

        fam.addChild("Diego Ruiz", "Lucia Ruiz", "10/05/2030", 'F', 0);


        fam.showTree();
        fam.recorridoXGen();
        fam.showDepth();

        fam.showAncestros("Diego Ruiz");
        fam.showAncestros("Lucia Ruiz");
        fam.showAncestros("Carlos Ruiz");
        fam.showAncestros("Xxx Xxx");

        fam.showDescendientes("Luis Ruiz");
        fam.showDescendientes("Ana Ruiz");
        fam.showDescendientes("Diego Ruiz");

        System.out.println("\nPRUEBA BORRADO");

        fam.deleteBranch("Marta Ruiz");

        System.out.println("\nDespues de borrar:");
        fam.showTree();
        fam.showDepth();

        fam.deleteBranch("Camila Ruiz");
    }
}