public class Roba extends Producte {
    String color;
    char talla;

    public Roba(String nom, float preu, String color, char talla) throws Exception {
        super(nom, preu, 21);

        if (!tallaOK(talla)) throw new Exception("La talla és incorrecte.");

        this.color = color;
        this.talla = talla;
    }

    public String getInfo() {
        String nom = String.format("%-15s%s", "Nom:", this.nom);
        String color = String.format("%-15s%s", "Color:", this.color);
        String talla = String.format("%-15s%s", "Talla:", this.talla);
        String pvp = String.format("%-15s%.2f", "PVP:", this.pvp());

        return nom +
                "\n" + color +
                "\n" + talla +
                "\n" + pvp + "\n";
    }

    boolean tallaOK(char t) {
        return t == 'S' || t == 'M' || t == 'L';
    }
}
