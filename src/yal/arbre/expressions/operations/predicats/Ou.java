package yal.arbre.expressions.operations.predicats;

import yal.arbre.expressions.Expression;
import yal.arbre.expressions.Operation;

public class Ou extends Operation {

    public Ou(Expression gauche, Expression droite) {
        super(gauche, droite);
        System.out.println("yolo");
    }

    @Override
    public String toMIPS() {
        return "à faire\n";
    }

    @Override
    public String toString() {
        return partieGauche+" ou " +partieDroite;
    }
}
