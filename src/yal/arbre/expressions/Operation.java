package yal.arbre.expressions;

public abstract class Operation extends Expression {
    protected Expression partieGauche;
    protected Expression partieDroite;


    public Operation(Expression gauche, Expression droite) {
        super(gauche.getNoLigne());
        partieGauche = gauche;
        partieDroite = droite;
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        return "#Operation : ";
    }

}
