package yal.arbre.instructions;

import yal.analyse.Entree;
import yal.analyse.Symbole;
import yal.analyse.TDS;
import yal.arbre.expressions.Expression;

public class AffectationConstanteEntiere extends Affectation {
    public AffectationConstanteEntiere(String idf, Expression exp) {
        super(exp.getNoLigne());
        partieG = idf;
        partieD = exp;
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
        StringBuilder str = new StringBuilder();
        str.append("# Affectation " + partieG + " = " + partieD + "\n");
        str.append("\tli $v0, "+partieD+"\n");
        str.append("\tsw $v0, "+deplacement+"($s7)\n\n");
        return str.toString();
    }
}
