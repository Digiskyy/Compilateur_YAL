package yal.arbre.instructions;

import yal.analyse.Entree;
import yal.analyse.Symbole;
import yal.analyse.TDS;
import yal.arbre.expressions.Expression;

public class Affectation extends Instruction {
    protected String partieG;
    protected int deplacement;

    protected Affectation(int n) {
        super(n);
    }


    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        return null;
    }
}
