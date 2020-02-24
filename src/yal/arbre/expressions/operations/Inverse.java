package yal.arbre.expressions.operations;

import yal.arbre.expressions.Expression;

public class Inverse extends Expression {
    private Expression expression;

    public Inverse(Expression exp) {
        super(exp.getNoLigne());
        expression = exp;
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        return "à faire";
    }
}
