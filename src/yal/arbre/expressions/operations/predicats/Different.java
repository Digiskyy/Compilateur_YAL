package yal.arbre.expressions.operations.predicats;

import yal.arbre.expressions.Expression;
import yal.arbre.expressions.Operation;
import yal.arbre.expressions.operations.Operande;

public class Different extends Operation {
    public Different(Expression gauche, Expression droite, int n) {
        super(gauche, droite, n);
    }
}
