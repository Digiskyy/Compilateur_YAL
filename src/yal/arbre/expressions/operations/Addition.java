package yal.arbre.expressions.operations;

import yal.arbre.expressions.Expression;
import yal.arbre.expressions.Operation;

public class Addition extends Operation {
    public Addition(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String toMIPS() {
        StringBuilder str = new StringBuilder();
        str.append(super.toMIPS()+toString()+"\n");
        str.append("\tadd $v0, "+partieGauche.toString()+", "+partieDroite.toString()+"\n");

        return str.toString();
    }

    @Override
    public String toString() {
        return partieGauche+ " + " + partieDroite;
    }
}
