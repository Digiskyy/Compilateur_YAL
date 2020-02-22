package yal.arbre.instructions;

import yal.arbre.BlocDInstructions;
import yal.arbre.expressions.Expression;

public class Condition extends Instruction {
    private Expression exp;
    private BlocDInstructions bloc;
    private BlocDInstructions sinon;
    private static int cpt = -1;
    private int compteurActuel;

    /**
     * Gère les conditions simples
     * @param e l'expression booléenne
     * @param b les instructions à faire si e e est vrai
     */
    public Condition(Expression e, BlocDInstructions b) {
        super(e.getNoLigne());
        exp = e;
        bloc = b;
        cpt++;
        compteurActuel = cpt;
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
        cpt++;
        compteurActuel = cpt;
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
        strB.append("# Condition\n");
        strB.append(exp.toMIPS()+"Else"+compteurActuel+"\n");
        strB.append(bloc.toMIPS());
        strB.append("\tj endif"+compteurActuel+"\n");
        strB.append("Else"+compteurActuel+":\n");
        if(sinon != null) {
            strB.append(sinon.toMIPS());
        }
        strB.append("endif"+compteurActuel+":\n");
        return strB.toString();
    }
}
