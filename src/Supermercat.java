import java.util.ArrayList;
public class Supermercat {
    public static ArrayList<Producte> productes = new ArrayList<Producte>();

    public static void afegirProducte(Producte p) {
        productes.add(p);
    }

    public static void eliminarProducte(String n) {
        for (int i = 0; i < productes.size(); ++i) {
            if (productes.get(i).getNom().equals(n)) {
                productes.remove(i);
            }
        }
    }

    public static ArrayList<Producte> filtrarProductes(String tipus) {
        // Convertim els tipus d'entrada als de les classes
        if (tipus.equals("Roba")) tipus = Roba.class.getSimpleName();
        if (tipus.equals("Aliment")) tipus = Aliment.class.getSimpleName();
        if (tipus.equals("Llibre")) tipus = Llibre.class.getSimpleName();

        // Creem l'ArrayList
        ArrayList<Producte> productesFiltrats = new ArrayList<>();

        // Afegim cada element del tipus desitjat al nou array
        for (Producte producte : productes) {
            if (producte.getClass().getSimpleName().equals(tipus)) {
                productesFiltrats.add(producte);
            }
        }

        return productesFiltrats;
    }

    public static void mostrarLlista(ArrayList<Producte> l) {
        for (Producte i : l) System.out.println(i.getInfo());
    }

    static Producte crearAliment(String nom, float preu, int calories, boolean esBeguda) {
        Producte p = null;
        try {
            p = new Aliment(nom, preu, calories, esBeguda);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return p;
    }

    static Producte crearLlibre(String nom, float preu, boolean teTapaDura) {
        Producte p = null;
        try {
            p = new Llibre(nom, preu, teTapaDura);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return p;
    }

    static Producte crearRoba(String nom, float preu, String color, char talla) {
        Producte p = null;
        try {
            p = new Roba(nom, preu, color, talla);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return p;
    }

    public static void main(String[] args) {
        // Instanciem productes
        Producte a1 = crearAliment("Patates", 5.9f, 600, false);
        Producte a2 = crearAliment("Patates", 5.9f, 600, false);
        Producte a3 = crearAliment("Aquarius", 2.4f, 400, true);
        Producte a4 = crearAliment("CocaCola", 2.9f, 900, true);
        Producte l1 = crearLlibre("El silmarillion", 25f, true);
        Producte l2 = crearLlibre("1984", 19.99f, false);
        Producte r1 = crearRoba("Samarreta", 5.99f, "Vermell", 'S');
        Producte r2 = crearRoba("Pantaló", 29.99f, "Blau", 'M');
        Producte r3 = crearRoba("Faldilla", 19.99f, "Blanc", 'L');

        // Afegim productes a la llista
        afegirProducte(a1);
        afegirProducte(a2);
        afegirProducte(a3);
        afegirProducte(a4);
        afegirProducte(l1);
        afegirProducte(l2);
        afegirProducte(r1);
        afegirProducte(r2);
        afegirProducte(r3);

        // Eliminem un producte
        eliminarProducte("Cocacola");

        // Mostrem roba
        System.out.println("ROBA ------------------");
        mostrarLlista(filtrarProductes("Roba"));

        // Mostrem aliments
        System.out.println("ALIMENT ---------------");
        mostrarLlista(filtrarProductes("Aliment"));

        // Mostrem llibre
        System.out.println("LLIBRE ---------------");
        mostrarLlista(filtrarProductes("Llibre"));

        // Comparem preus d'l1 i l2
        if (Producte.compare(productes.get(4), productes.get(5)) == -1) System.out.println(l2.getNom() + " és més car que " + l1.getNom());
        else if (Producte.compare(productes.get(4), productes.get(5)) == 1) System.out.println(l1.getNom() + " és més car que " + l2.getNom());
        else System.out.println(l1.getNom() + " i " + l2.getNom() + " tenen el mateix preu");
        System.out.println();

        // Generem excepcions
        System.out.println("Instanciem aliment amb calories incorrectes:");
        Producte e1 = crearAliment("Caducat", 5.99f, 2000, false);

        System.out.println("\nInstanciem producte amb preu incorrecte:");
        Producte e2 = crearLlibre("Llibre preu erroni", 0.99f, false);

        System.out.println("\nInstanciem roba amb talla incorrecta:");
        Producte e3 = crearRoba("Roba talla erronia", 5.99f, "Caqui", 'X');

    }
}
