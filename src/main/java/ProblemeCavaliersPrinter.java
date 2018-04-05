import java.util.List;
import java.util.StringJoiner;

public class ProblemeCavaliersPrinter {
    public void print(List<Case> cases) {
        for (int i = 1; i <= Echiquier.NB_LIGNES; i++) {
            StringJoiner ligneJoiner = new StringJoiner("|", "[", "]");
            for (int j = 1; j <=Echiquier.NB_COLONNES; j++) {
                ligneJoiner.add(getPositionString(cases, i, j));
            }
            System.out.println(ligneJoiner.toString());
        }
    }

    private String getPositionString(List<Case> cases, int i, int j) {
        Case caseAttendue = new Case(j, i);
        int pos = cases.indexOf(caseAttendue)+1;
        return String.format("%1$2d", pos);
    }

}
