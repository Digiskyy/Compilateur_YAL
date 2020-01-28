package yal.arbre.instructions;

import yal.analyse.Entree;
import yal.analyse.Symbole;
import yal.analyse.TDS;
import yal.arbre.expressions.Expression;

public class AffectationVariable extends Affectation {
    protected String partieD;
    public AffectationVariable(String gauche, String droite, int n) {
        super(n);
        partieG = gauche;
        partieD = droite;
    }

    @Override
    public void verifier() {
        Entree e = new Entree(partieG);
        Symbole s = TDS.getInstance().identifier(e);

        deplacement = s.getTaille();
    }

    @Override
    public String toMIPS() {
        verifier();
        Entree e = new Entree(partieD.toString());
        Symbole s = TDS.getInstance().identifier(e);

        int deplacementDroite = s.getTaille();
        StringBuilder str = new StringBuilder();
        str.append("# Affectation " + partieG + " = " + partieD + "\n");
        str.append("\tlw $v0, "+ deplacementDroite+"($s7)\n");
        str.append("\tsw $v0, "+deplacement+"($s7)\n\n");
        return str.toString();
    }
}
