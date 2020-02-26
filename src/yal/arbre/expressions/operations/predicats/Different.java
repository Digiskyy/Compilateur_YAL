package yal.arbre.expressions.operations.predicats;

import yal.arbre.expressions.Expression;
import yal.arbre.expressions.Operation;

public class Different extends Operation {
    public Different(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String toMIPS() {
        return  partieGauche.getComparaison1() + partieDroite.getComparaison2()+
                "\tbeq $t1, $t2, ";
    }

    @Override
    public String toString() {
        return partieGauche+" != "+partieDroite;
    }
}
