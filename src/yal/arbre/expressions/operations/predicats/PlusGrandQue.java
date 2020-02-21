package yal.arbre.expressions.operations.predicats;

import yal.arbre.expressions.Expression;
import yal.arbre.expressions.Operation;
import yal.arbre.expressions.operations.Operande;

public class PlusGrandQue extends Operation {
    public PlusGrandQue(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String toMIPS() {
        return partieGauche.getComparaison1() + partieDroite.getComparaison2()+
                "\tsgt $t3, $t1, $t2\n"
                +"\t li $t4, 0\n"
                +"\tbeq $t3, $t4, Else\n";
    }
}
