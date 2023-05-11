public class Aliment extends Producte {
    int calories;
    boolean beguda;

    public Aliment(String nom, float preu, int calories, boolean beguda) throws Exception {
        super(nom, preu, (beguda ? 21 : 10));

        if (!caloriesOK(calories)) throw new Exception("Calories incorrectes.");

        this.calories = calories;
        this.beguda = beguda;
    }

    public String getInfo() {
        String nom = String.format("%-15s%s", "Nom", this.nom);
        String calories = String.format("%-15s%d", "Calories:", this.calories);
        String pvp = String.format("%-15s%.2f", "PVP:", this.pvp());
        return nom +
                "\n" + calories +
                "\n" + pvp + "\n";
    }

    boolean caloriesOK(int c) {
        return c > 0 && c < 1000;
    }
}
