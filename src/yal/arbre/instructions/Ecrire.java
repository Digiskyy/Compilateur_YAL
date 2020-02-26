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
        return "# Ecriture de "+exp+"\n" +
                exp.toMIPS() +
                "\tli $v0, 1\n" +
                "\tsyscall\n" +
                "\taddi $a0, $0, 0xA \n" +
                "\taddi $v0, $0, 0xB \n" +
                "\tsyscall #Saut de ligne\n\n"; // Appel système à la fin de l'écriture
    }

}