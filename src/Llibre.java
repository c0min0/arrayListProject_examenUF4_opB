public class Llibre extends Producte {
    boolean tapaDura;

    public Llibre(String nom, float preu, boolean tapaDura) throws Exception {
        super(nom, preu, 4);
        this.tapaDura = tapaDura;
    }

    public String getInfo() {
        String nom = String.format("%-15s%s", "Nom:", this.nom);
        String pvp = String.format("%-15s%.2f", "PVP:", this.pvp());
        return nom + "\n" + pvp + "\n";
    }
}
