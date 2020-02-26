package yal.arbre.expressions.operations;

import yal.arbre.expressions.ConstanteEntiere;
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
        Multiplication mult = new Multiplication(expression, new ConstanteEntiere("-1", expression.getNoLigne()));
        return mult.toMIPS();
    }

    @Override
    public String toString() {
        return "-"+expression;
    }
}
