import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum DeplacementCavalier {
    NE(2, 1),
    ENE(1, 2),
    ESE(-1, 2),
    SE(-2, 1),
    SO(-2, -1),
    OSO(-1, -2),
    ONO(1, -2),
    NO(2, -1);

    private final int deplacementVertical;
    private final int deplacementHorizontal;

    DeplacementCavalier(int deplacementHorizontal, int deplacementVertical) {
        this.deplacementVertical = deplacementVertical;
        this.deplacementHorizontal = deplacementHorizontal;
    }

    public static List<Case> deplacementsPossibles(Case caseInitiale) {
        return Arrays.stream(DeplacementCavalier.values())
            .map(depEnum -> depEnum.deplacement(caseInitiale))
            .filter(Case::valide)
            .collect(Collectors.toList());
    }

    private Case deplacement(Case caseIniale) {
        return new Case(caseIniale.ligne+deplacementVertical, caseIniale.colonne+deplacementHorizontal);
    }
}
