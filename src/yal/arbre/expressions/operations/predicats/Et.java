package yal.arbre.expressions.operations.predicats;

import yal.arbre.expressions.Expression;
import yal.arbre.expressions.Operation;

public class Et extends Operation {

    public Et(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String toString() {
        return partieGauche+" et " +partieDroite;
    }
}
