import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class DeplacementTest {

    private Echiquier echiquier;

    @Test
    public void testCoinBasGauche() {
        // ARRANGE
        echiquier = new Echiquier(new Case("a1"));

        // ACT
        List<Case> deplacementsPossibles = echiquier.casesAccessibles();

        // ASSERT
        assertThat(deplacementsPossibles).containsExactly(
            new Case("b3"),
            new Case("c2"));
    }

    @Test
    public void testCoinBasGaucheApresDeplacement() {
        // ARRANGE
        echiquier = new Echiquier(Collections.singletonList(new Case("b3")), new Case("a1"));

        // ACT
        List<Case> deplacementsPossibles = echiquier.casesAccessibles();

        // ASSERT
        assertThat(deplacementsPossibles).containsExactly(new Case("c2"));
    }
    @Test
    public void testCentre() {
        // ARRANGE
        echiquier = new Echiquier(new Case("e4"));

        // ACT
        List<Case> deplacementsPossibles = echiquier.casesAccessibles();

        // ASSERT
        assertThat(deplacementsPossibles).containsExactly(
            new Case("f6"),
            new Case("g5"),
            new Case("g3"),
            new Case("f2"),
            new Case("d2"),
            new Case("c3"),
            new Case("c5"),
            new Case("d6"));
    }
}
