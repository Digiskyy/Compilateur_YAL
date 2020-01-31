package yal.arbre.instructions;

import yal.arbre.expressions.Expression;

public class Ecrire extends Instruction
{

    protected Expression exp ;

    public Ecrire (Expression e, int n)
    {
        super(n) ;
        exp = e ;
    }

    @Override
    public void verifier()
    {
    }

    @Override
    public String toMIPS()

    {
        verifier();
        return exp.toMIPS() + "\n\tsyscall # Appel système pour l'écriture\n"; // Appel système à la fin de l'écriture
    }

}
