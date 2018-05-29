import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Echiquier {

    public static final int NB_COLONNES = 8;
    public static final int NB_LIGNES = 8;

    private static final int TAILLE_ECHIQUIER = NB_COLONNES * NB_LIGNES;

    private final List<Case> deplacements;

    public Echiquier(Case caseInitiale) {
        this.deplacements = new ArrayList<>();
        deplacements.add(caseInitiale);
    }

    public Echiquier(List<Case> anciennesCases, Case caseInitiale) {
        this.deplacements = new ArrayList<>();
        deplacements.addAll(anciennesCases);
        deplacements.add(caseInitiale);
    }

    public List<Case> casesAccessibles() {
        Case caseActuelle = Iterables.getLast(deplacements);
        List<Case> positionsPossibles = DeplacementCavalier.deplacementsPossibles(caseActuelle);
        return positionsPossibles.stream().filter(this::caseInoccupee)
            .collect(Collectors.toList());
    }

    public int nombreCasesAccessibles() {
        return casesAccessibles().size();
    }

    private boolean caseInoccupee(Case pos) {
        return !deplacements.contains(pos);
    }

    public List<Case> getDeplacements() {
        return Collections.unmodifiableList(deplacements);
    }

    public boolean echiquierComplet() {
        return deplacements.size() == TAILLE_ECHIQUIER;
    }

    public List<Echiquier> getNouveauxEchiquiersPossibles() {
        return getNouvellesPositionsPossibles(casesAccessibles(),
            getDeplacements());
    }

    private List<Echiquier> getNouvellesPositionsPossibles(List<Case> casesAccessibles,
        List<Case> deplacementsAnterieurs) {
        return casesAccessibles
            .stream()
            .map(pos -> new Echiquier(deplacementsAnterieurs, pos))
            .collect(Collectors.toList());
    }
}
