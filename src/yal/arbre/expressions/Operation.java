package yal.arbre.expressions;

import yal.arbre.expressions.operations.Operande;

public abstract class Operation extends Expression {
    protected Expression partieGauche;
    protected Expression partieDroite;


    public Operation(Expression gauche, Expression droite, int n) {
        super(n);
        partieGauche = gauche;
        partieDroite = droite;
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        return "Operation";
    }
}
