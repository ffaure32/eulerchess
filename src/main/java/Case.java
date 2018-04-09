import java.util.Objects;

public class Case {

    public static final int A_NUMERIC_VALUE = (int)'a' -1;
    public static final int ONE_NUMERIC_VALUE = (int)'1' -1;
    public final int colonne;
    public final int ligne;

    public Case(String pos) {
        colonne = (int)pos.charAt(0) - A_NUMERIC_VALUE;
        ligne = (int)pos.charAt(1) - ONE_NUMERIC_VALUE;
    }

    public Case(int colonne, int ligne) {
        this.colonne = colonne;
        this.ligne = ligne;
    }

    public boolean valide() {
        return ligneValide() && colonneValide();
    }

    private boolean colonneValide() {
        return colonne > 0 && colonne <= Echiquier.NB_COLONNES;
    }

    private boolean ligneValide() {
        return ligne > 0 && ligne <= Echiquier.NB_LIGNES;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Case)) {
            return false;
        }
        Case other = (Case) obj;
        return Objects.equals(this.ligne, other.ligne) &&
            Objects.equals(this.colonne, other.colonne);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.colonne, this.ligne);
    }

    @Override
    public String toString() {
        char pos = (char)(A_NUMERIC_VALUE+colonne);
        return new StringBuilder().append(pos).append(ligne).toString();
    }
}
