package yal.arbre.instructions;

import yal.analyse.Entree;
import yal.analyse.Symbole;
import yal.analyse.TDS;

public class AffectationVariable extends Affectation {
    protected AffectationVariable(int n) {
        super(n);
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
