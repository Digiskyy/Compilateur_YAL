package yal.arbre.instructions;

import yal.analyse.Entree;
import yal.analyse.Symbole;
import yal.analyse.TDS;

public class Lire extends Instruction {
    private String idf;
    private Symbole s;

    public Lire(String idf, int n) {
        super(n);
        this.idf = idf;
    }

    @Override
    public void verifier() {
        Entree e = new Entree(idf);
        s = TDS.getInstance().identifier(e);
    }

    @Override
    public String toMIPS() {
        verifier();
        StringBuilder str = new StringBuilder();
        str.append("#Lire "+idf+"\n");
        str.append("\tli $v0, 5 #Code du lire\n");
        str.append("\tsyscall\n");
        str.append("\tsw $v0,"+s.getTaille() +"($s7)\n\n");
        return str.toString();
    }
}
