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
     * @param b les instructions à faire si e est vrai
     * @param c les instructions à faire si e est faux
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
        StringBuilder strB = new StringBuilder();
        strB.append("#CONDITION\n");
        strB.append(exp.toMIPS());
        strB.append(bloc.toMIPS());
        strB.append("\tj endif\n");
        strB.append("Else:\n");
        if(sinon != null) {
            strB.append(sinon.toMIPS());
        }
        strB.append("endif:\n");
        return strB.toString();
    }
}
