public abstract class Producte {
    String nom;
    float preu;
    int iva;

    public Producte(String nom, float preu, int iva) throws Exception {
        if (!preuOK(preu)) throw new Exception("Un preu inferior a 1 no és vàlid");

        this.nom = nom;
        this.preu = preu;
        this.iva = iva;
    }

    public abstract String getInfo();

    boolean preuOK(float preu) {
        return preu > 1;
    }

    public String getNom() {
        return nom;
    }

    public float pvp() {
        return preu + (preu * iva / 100);
    }

    public static int compare(Producte a, Producte b) {
        return Float.compare(a.preu, b.preu);
    }
}
