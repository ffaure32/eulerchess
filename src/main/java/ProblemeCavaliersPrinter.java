import java.util.List;
import java.util.StringJoiner;

public class ProblemeCavaliersPrinter {
    public void print(List<Case> cases) {
        for (int i = Echiquier.NB_LIGNES; i >0; i--) {
            System.out.print(String.format("%1d  ", i));
            StringJoiner ligneJoiner = new StringJoiner("|", "[", "]");
            for (int j = 1; j <=Echiquier.NB_COLONNES; j++) {
                ligneJoiner.add(getPositionString(cases, i, j));
            }
            System.out.println(ligneJoiner.toString());
        }
        StringJoiner lettresJoiner = new StringJoiner(" ", " ", " ");
        lettresJoiner.add("  ");
        for(char col = 'a'; col <='h'; col++) {
            lettresJoiner.add(String.format("%1s ", col));
        }
        System.out.println(lettresJoiner.toString());
    }

    private String getPositionString(List<Case> cases, int i, int j) {
        Case caseAttendue = new Case(j, i);
        int pos = cases.indexOf(caseAttendue)+1;
        return String.format("%1$2d", pos);
    }

}
