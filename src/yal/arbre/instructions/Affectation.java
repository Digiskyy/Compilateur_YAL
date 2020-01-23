package yal.arbre.instructions;

import yal.arbre.expressions.Expression;

public class Affectation extends Instruction {
    private String partieG;
    private Expression partieD;

    protected Affectation(String idf, Expression exp) {
        super(exp.getNoLigne());
        partieG = idf;
        partieD = exp;
    }


    @Override
    public void verifier() {
    }

    @Override
    public String toMIPS() {
        return null;
    }
}
