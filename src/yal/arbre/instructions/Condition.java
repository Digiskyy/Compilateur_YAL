package yal.arbre.instructions;

import yal.arbre.BlocDInstructions;
import yal.arbre.expressions.Expression;

public class Condition extends Instruction {
    private Expression exp;
    private BlocDInstructions bloc;
    private BlocDInstructions sinon;

    /**
     * Gère les conditions simples
     * @param e l'expression booléenne
     * @param b les instructions à faire si e e est vrai
     */
    public Condition(Expression e, BlocDInstructions b) {
        super(e.getNoLigne());
        exp = e;
        bloc = b;
    }

    /**
     * Gère les conditions doubles
     * @param e l'expression booléenne
     * @param b les instructions à faire si e e est vrai
     * @param c les instructions à faire si e e est faux
     */
    public Condition(Expression e, BlocDInstructions b, BlocDInstructions c) {
        super(e.getNoLigne());
        exp = e;
        bloc = b;
        sinon = c;
    }

    @Override
    public void verifier() {
        exp.verifier();
        bloc.verifier();
        if(sinon != null) {
            sinon.verifier();
        }
    }

    @Override
    public String toMIPS() {
        verifier();
        return "CONDITION\n\n";
    }
}
