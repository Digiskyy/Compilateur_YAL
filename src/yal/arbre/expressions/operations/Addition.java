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
        str.append("\tli $t0, " + partieGauche.toString() + "\n");
        str.append("\tli $t1, " + partieDroite.toString() + "\n");
        str.append("\tadd $a0, $t0, $t1\n");

        return str.toString();
    }

    @Override
    public String toString() {
        return partieGauche+ " + " + partieDroite;
    }
}
