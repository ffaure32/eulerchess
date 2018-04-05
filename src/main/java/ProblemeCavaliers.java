import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProblemeCavaliers {

    public List<Case> prochainDeplacement(Echiquier etatEchiquierActuel) {
        List<Case> casesAccessibles = etatEchiquierActuel.casesAccessibles();
        List<Case> deplacementsAnterieurs = etatEchiquierActuel.getDeplacements();

        List<Echiquier> nouvellesPositionsPossibles = getNouvellesPositionsPossibles(casesAccessibles,
            deplacementsAnterieurs);
        if(cheminCondamne(nouvellesPositionsPossibles)) {
            return Collections.EMPTY_LIST;
        }
        Optional<Echiquier> solution = getSolution(nouvellesPositionsPossibles);
        if(solution.isPresent()) {
            return solution.get().getDeplacements();
        }

        for(Echiquier nouveauDeplacement : nouvellesPositionsPossibles) {
            List<Case> solutions = prochainDeplacement(nouveauDeplacement);
            if (!solutions.isEmpty()) {
                return solutions;
            }
        }
        return Collections.EMPTY_LIST;
    }

    private Optional<Echiquier> getSolution(List<Echiquier> nouvellesPositionsPossibles) {
        return nouvellesPositionsPossibles
            .stream()
            .filter(Echiquier::echiquierComplet)
            .collect(Collectors.reducing((a, b) -> null));
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
            .anyMatch(nouveauDeplacement -> isCheminCondamne(nouveauDeplacement));
    }

    private boolean isCheminCondamne(Echiquier nouveauDeplacement) {
        return nouveauDeplacement.casesAccessibles().isEmpty() && !nouveauDeplacement.echiquierComplet();
    }
}
