import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum DeplacementCavalier {
    NE(1, 2),
    ENE(2, 1),
    ESE(2, -1),
    SE(1, -2),
    SO(-1, -2),
    OSO(-2, -1),
    ONO(-2, 1),
    NO(-1, 2);

    private final int deplacementLignes;
    private final int deplacementColonnes;

    DeplacementCavalier(int deplacementColonnes, int deplacementLignes) {
        this.deplacementLignes = deplacementLignes;
        this.deplacementColonnes = deplacementColonnes;
    }

    public static List<Case> deplacementsPossibles(Case caseInitiale) {
        return Arrays.stream(DeplacementCavalier.values())
            .map(depEnum -> depEnum.deplacement(caseInitiale))
            .filter(Case::valide)
            .collect(Collectors.toList());
    }

    private Case deplacement(Case caseIniale) {
        return new Case(caseIniale.colonne+ deplacementColonnes, caseIniale.ligne+ deplacementLignes);
    }
}
