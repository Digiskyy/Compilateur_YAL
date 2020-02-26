package yal.arbre.expressions.operations.predicats;

import yal.arbre.expressions.Expression;
import yal.arbre.expressions.Operation;

public class Ou extends Operation {

    public Ou(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String toMIPS() {
        StringBuilder strb = new StringBuilder();
        strb.append(partieGauche.toMIPS()+"");
        return strb.toString();
    }

    @Override
    public String toString() {
        return partieGauche+" ou " +partieDroite;
    }
}