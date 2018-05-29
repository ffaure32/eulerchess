import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ProblemeCavaliers {
    public List<Case> solutionProblemeEuler(Case caseDepart) {
        return prochainDeplacement(new Echiquier(caseDepart));
    }

    @SuppressWarnings("unchecked")
    private List<Case> prochainDeplacement(Echiquier etatEchiquierActuel) {
        List<Echiquier> nouvellesPositionsPossibles = etatEchiquierActuel.getNouveauxEchiquiersPossibles();

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
            .sorted(Comparator.comparingInt(Echiquier::nombreCasesAccessibles))
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

}
