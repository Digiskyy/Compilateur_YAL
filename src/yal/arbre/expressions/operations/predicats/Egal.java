package yal.arbre.expressions.operations.predicats;

import yal.arbre.expressions.Expression;
import yal.arbre.expressions.Operation;
import yal.arbre.expressions.operations.Operande;

public class Egal extends Operation {
    public Egal(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
}
