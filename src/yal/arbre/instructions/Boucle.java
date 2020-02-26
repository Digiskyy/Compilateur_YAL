package yal.arbre.instructions;

import yal.arbre.BlocDInstructions;
import yal.arbre.expressions.Expression;

public class Boucle extends Instruction {
    private Expression exp;
    private BlocDInstructions listeInstructions;
    private static int cpt = 0;
    private int compteur;

    public Boucle(Expression e, BlocDInstructions b) {
        super(e.getNoLigne());
        exp = e;
        listeInstructions = b;
        cpt ++;
        compteur = cpt;
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        StringBuilder strB = new StringBuilder();
        strB.append("# Tant que " + exp.toString() + "\n");
        strB.append("loop" + compteur + ":\n");
        strB.append(exp.toMIPS()
                + "\tli $t1, 1\n"
                + "\tbne $a0, $t1, fintantque" + compteur + "\n");
        strB.append(listeInstructions.toMIPS());
        strB.append("\tj loop" + compteur + "\n");
        strB.append("fintantque" + compteur + ":\n\n");
        return strB.toString();
    }
}
