package yal.arbre.instructions;

import yal.arbre.expressions.Expression;

public class AppelFonction extends Expression {
    private String nomFonction;
    private static int cpt = 0;
    /**
     * Appelle une fonction qui a été déclarée
     * @param idf nom de la fonction
     * @param n ligne d'appel
     */
    public AppelFonction(String idf, int n) {
        super(n);
        nomFonction = idf;
        cpt++;
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        String mips = "";
        mips += "# Appel de la fonction "+nomFonction+"\n"+
                "\tadd $sp, $sp, -4\n\n"+
                "# Jump vers le label " + nomFonction + "\n"+
                "\tjal " + nomFonction + "\n\n"+
                "retour"+cpt+":"+
                "# Depile dans $v0\n" +
                "\tadd $sp, $sp, 4\n"+
                "\tlw $v0, 0($sp)\n\n";
        return mips;
    }

    @Override
    public String toString() {
        return "Appel de la fonction "+nomFonction;
    }
}
