import java.util.List;
import java.util.StringJoiner;

public class ProblemeCavaliersPrinter {
    public void print(List<Case> cases) {
        for (int numLigne = Echiquier.NB_LIGNES; numLigne >0; numLigne--) {
            afficherNumeroLigne(numLigne);
            afficherContenuLigne(cases, numLigne);
        }
        afficherLettresSurDerniereLigne();
    }

    private void afficherNumeroLigne(int i) {
        System.out.print(String.format("%1d  ", i));
    }

    private void afficherContenuLigne(List<Case> cases, int numLigne) {
        StringJoiner ligneJoiner = new StringJoiner("|", "[", "]");
        for (int numColonne = 1; numColonne <=Echiquier.NB_COLONNES; numColonne++) {
            ligneJoiner.add(recupererClassementCase(cases, numLigne, numColonne));
        }
        System.out.println(ligneJoiner.toString());
    }

    private String recupererClassementCase(List<Case> cases, int numLigne, int numColonne) {
        Case caseAttendue = new Case(numColonne, numLigne);
        int pos = cases.indexOf(caseAttendue)+1;
        return String.format("%1$2d", pos);
    }

    private void afficherLettresSurDerniereLigne() {
        StringJoiner lettresJoiner = new StringJoiner(" ", "    ", " ");
        for(char col = 'a'; col <='h'; col++) {
            lettresJoiner.add(String.format("%1s ", col));
        }
        System.out.println(lettresJoiner.toString());
    }


}
