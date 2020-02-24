package yal.arbre.expressions.operations.predicats;

import yal.arbre.expressions.Expression;
import yal.arbre.expressions.Operation;
import yal.arbre.expressions.operations.Operande;

public class PlusPetitQue extends Operation {
    public PlusPetitQue(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String toMIPS() {
        return partieGauche.getComparaison1() + partieDroite.getComparaison2()+
                 "\tslt $t3, $t1, $t2\n"
                +"\tli $t4, 0\n"
                +"\tbeq $t3, $t4, ";
    }

    @Override
    public String toString() {
        return partieGauche+" plus petit que "+partieDroite;
    }
}
