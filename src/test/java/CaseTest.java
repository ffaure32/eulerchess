import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class CaseTest {

    @Test
    public void toStringTest() {
        // ARRANGE
        Case pos = new Case(2, 2);
        // ACT
        String stringValue = pos.toString();

        // ASSERT
        assertThat(stringValue).isEqualTo("b2");

    }

    @Test
    public void fromString() {
        // ARRANGE
        Case pos = new Case("b3");

        // ACT
        String stringValue = pos.toString();

        // ASSERT
        assertThat(stringValue).isEqualTo("b3");
    }
}
