import java.util.List;
import org.junit.Test;

public class ProblemeCavaliersTest {

    @Test
    public void tentative1() {
        // ARRANGE
        ProblemeCavaliers pc = new ProblemeCavaliers();

        // ACT
        List<Case> resultat = pc.prochainDeplacement(new Echiquier(new Case("a1")));

        // ASSERT
        new ProblemeCavaliersPrinter().print(resultat);

    }
}
