import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum DeplacementCavalier {
    NORD_EST(1, 2),
    EST_NORD_EST(2, 1),
    EST_SUD_EST(2, -1),
    SUD_SUD_EST(1, -2),
    SUD_OUEST(-1, -2),
    OUEST_SUD_OUEST(-2, -1),
    OUEST_NORD_OUEST(-2, 1),
    NORD_OUEST(-1, 2);

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
