package yal.arbre.instructions;

import yal.arbre.expressions.Expression;

public class AppelFonction extends Expression {
    private String nomFonction;

    /**
     * Appelle une fonction qui a été déclarée
     * @param idf nom de la fonction
     * @param n ligne d'appel
     */
    public AppelFonction(String idf, int n) {
        super(n);
        nomFonction = idf;
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        return "#Fonction\n";
    }

    @Override
    public String toString() {
        return "Appel de la fonction "+nomFonction;
    }
}
