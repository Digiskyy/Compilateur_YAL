package yal.arbre.expressions.operations.predicats;

import yal.arbre.expressions.Expression;

public class Non extends Expression {
    Expression expression;

    public Non(Expression exp) {
        super(exp.getNoLigne());
        expression = exp;
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        return expression.toMIPS()+
                "\txori $a0, $a0, 1\n";
    }

    @Override
    public String toString() {
        return "non "+expression;
    }
}
