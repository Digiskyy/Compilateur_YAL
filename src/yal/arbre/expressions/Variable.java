package yal.arbre.expressions;

import yal.analyse.Entree;
import yal.analyse.Symbole;
import yal.analyse.TDS;
import yal.exceptions.AnalyseSemantiqueException;

public class Variable extends Expression {
    private String idf;
    private Symbole symboleDroit;
    private boolean zero = false;

    public Variable(String idf, int n) {
        super(n);
        this.idf = idf;
    }

    @Override
    public void verifier() {
        Entree entreeDroite = new Entree(idf);
        symboleDroit = TDS.getInstance().identifier(entreeDroite);
        //On vérifie que la variable qui donne sa valeur est déclarée
        if (symboleDroit == null) {
            throw new AnalyseSemantiqueException(noLigne, idf + " n'a pas été déclaré.");
        }

    }

    @Override
    public String toMIPS() {
        verifier();
        return "\tlw $a0, " + symboleDroit.getTaille() + "($s7)\n";
    }

    @Override
    public String toString() {
        return idf;
    }

    public void setZero(boolean zero) {
        this.zero = zero;
    }

    public boolean isZero() {
        return zero;
    }
}