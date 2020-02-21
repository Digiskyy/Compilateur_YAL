package yal.arbre.instructions;

import yal.arbre.BlocDInstructions;
import yal.arbre.expressions.Expression;

public class Boucle extends Instruction {
    private Expression exp;
    private BlocDInstructions tantQue;

    public Boucle(Expression e, BlocDInstructions b) {
        super(e.getNoLigne());
        exp = e;
        tantQue = b;
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        return "BOUCLE\n\n";
    }
}
