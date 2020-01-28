package yal.arbre.expressions;

public class Variable extends Expression {
    String idf;

    public Variable(String idf, int n) {
        super(n);
        this.idf = idf;
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        return "COUCOU";
    }

    @Override
    public String toString() {
        return idf;
    }
}
