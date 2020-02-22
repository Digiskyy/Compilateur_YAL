package yal.arbre.instructions;

import yal.arbre.BlocDInstructions;
import yal.arbre.expressions.Expression;

public class Boucle extends Instruction {
    private Expression exp;
    private BlocDInstructions tantQue;
    private static int cpt = 0;
    private int compteur;

    public Boucle(Expression e, BlocDInstructions b) {
        super(e.getNoLigne());
        exp = e;
        tantQue = b;
        cpt ++;
        compteur = cpt;
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        StringBuilder strB = new StringBuilder();
        strB.append("#Boucle\n");
        strB.append("loop"+compteur+":\n");
        strB.append(exp.toMIPS()+"fintantque"+compteur+"\n");
        strB.append(tantQue.toMIPS());
        strB.append("\tj loop"+compteur+"\n");
        strB.append("fintantque"+compteur+":\n\n");
        return strB.toString();
    }
}
