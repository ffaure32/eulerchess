import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ProblemeCavaliersPrinter {
    public void print(List<Case> cases) {
        afficherLignes(cases);
        afficherLettresSurDerniereLigne();
    }

    private void afficherLignes(List<Case> cases) {
        reverseIntStream(Echiquier.NB_LIGNES).forEach(numLig -> afficherLigne(cases, numLig));
    }

    private Stream<Integer> reverseIntStream(int nbLignes) {
        return IntStream.rangeClosed(1, nbLignes).boxed().sorted(Collections.reverseOrder());
    }

    private void afficherLigne(List<Case> cases, int numLigne) {
        afficherNumeroLigne(numLigne);
        afficherContenuLigne(cases, numLigne);
    }

    private void afficherNumeroLigne(int numLigne) {
        System.out.print(String.format("%1d  ", numLigne));
    }

    private void afficherContenuLigne(List<Case> cases, int numLigne) {
        StringJoiner ligneJoiner = new StringJoiner("|", "[", "]");
        IntStream.rangeClosed(1, Echiquier.NB_COLONNES)
            .forEach(numColonne -> ligneJoiner.add(recupererClassementCase(cases, numLigne, numColonne)));
        System.out.println(ligneJoiner.toString());
    }

    private String recupererClassementCase(List<Case> cases, int numLigne, int numColonne) {
        Case caseAttendue = new Case(numColonne, numLigne);
        int pos = cases.indexOf(caseAttendue)+1;
        return String.format("%1$2d", pos);
    }

    private void afficherLettresSurDerniereLigne() {
        StringJoiner lettresJoiner = new StringJoiner(" ", "    ", " ");
        IntStream
            .range(Case.A_NUMERIC_VALUE+1, Case.A_NUMERIC_VALUE+1+Echiquier.NB_COLONNES)
            .forEach(col -> lettresJoiner.add(String.format("%1s ", (char)col)));
        System.out.println(lettresJoiner.toString());
    }


}
