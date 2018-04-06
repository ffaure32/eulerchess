import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import org.junit.Test;

public class ProblemeCavaliersTest {

    @Test
    public void verifierResolution() {
        // ARRANGE
        ProblemeCavaliers pc = new ProblemeCavaliers();

        // ACT
        List<Case> resultat = pc.solutionProblemeEuler(new Case("a1"));

        // ASSERT
        assertThat(resultat).hasSize(64);
        assertThat(resultat.stream().allMatch(new HashSet<>()::add)).isTrue();
        new ProblemeCavaliersPrinter().print(resultat);

    }
}
