package yal.arbre.expressions.operations;

import yal.arbre.expressions.Expression;
import yal.arbre.expressions.Operation;

public class Addition extends Operation {
    public Addition(Expression gauche, Expression droite, int n) {
        super(gauche, droite, n);
    }
}
