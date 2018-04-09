import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProblemeCavaliers {

    public List<Case> solutionProblemeEuler(Case caseDepart) {
        return prochainDeplacement(new Echiquier(caseDepart));
    }

    private List<Case> prochainDeplacement(Echiquier etatEchiquierActuel) {
        List<Case> casesAccessibles = etatEchiquierActuel.casesAccessibles();
        List<Case> deplacementsAnterieurs = etatEchiquierActuel.getDeplacements();

        List<Echiquier> nouvellesPositionsPossibles = getNouvellesPositionsPossibles(casesAccessibles,
            deplacementsAnterieurs);
        if(cheminCondamne(nouvellesPositionsPossibles)) {
            return Collections.EMPTY_LIST;
        }
        Optional<Echiquier> solution = solutionParmiNouvellesPositions(nouvellesPositionsPossibles);
        if(solution.isPresent()) {
            return solution.get().getDeplacements();
        }

        Optional<List<Case>> solutionRemontee = testerProchainsDeplacements(nouvellesPositionsPossibles);
        return solutionRemontee.orElse(Collections.EMPTY_LIST);
    }

    private Optional<List<Case>> testerProchainsDeplacements(List<Echiquier> nouvellesPositionsPossibles) {
        return nouvellesPositionsPossibles
            .stream()
            .map(this::prochainDeplacement)
            .filter(cs -> !cs.isEmpty())
            .findFirst();
    }

    private Optional<Echiquier> solutionParmiNouvellesPositions(List<Echiquier> nouvellesPositionsPossibles) {
        return nouvellesPositionsPossibles
            .stream()
            .filter(Echiquier::echiquierComplet)
            .findFirst();
    }

    private List<Echiquier> getNouvellesPositionsPossibles(List<Case> casesAccessibles,
        List<Case> deplacementsAnterieurs) {
        return casesAccessibles
            .stream()
            .map(pos -> new Echiquier(deplacementsAnterieurs, pos))
            .collect(Collectors.toList());
    }

    private boolean cheminCondamne(List<Echiquier> nouvellesPositionsPossibles) {
        return nouvellesPositionsPossibles
            .stream()
            .anyMatch(this::isCheminCondamne);
    }

    private boolean isCheminCondamne(Echiquier nouveauDeplacement) {
        return nouveauDeplacement.casesAccessibles().isEmpty() && !nouveauDeplacement.echiquierComplet();
    }
}
