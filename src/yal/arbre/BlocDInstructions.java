package yal.arbre;

import yal.analyse.Bloc;
import yal.analyse.TDS;
import yal.arbre.instructions.Instruction;

import java.util.ArrayList;

/**
 * 21 novembre 2018
 *
 * @author brigitte wrobel-dautcourt
 */

public class BlocDInstructions extends ArbreAbstrait
{
    protected ArrayList<ArbreAbstrait> programme;
    protected ArrayList<Instruction> blocDInstructions ;
    static boolean premiereInstruction = false;
    private boolean blocPrincipal = false;

    public BlocDInstructions(int n)
    {
        super(n) ;
        programme = new ArrayList<>() ;
    }

    public void ajouter(ArbreAbstrait a)
    {
        programme.add(a) ;
    }

    @Override
    public String toString()
    {
        return programme.toString() ;
    }

    @Override
    public void verifier()
    {
        for(ArbreAbstrait arb : programme)
        {
            arb.verifier();
        }
    }

    @Override
    public String toMIPS()
    {
        StringBuilder strB = new StringBuilder();

        for(ArbreAbstrait arb : programme)
        {
            strB.append(arb.toMIPS());
        }
        
        return strB.toString();
    }

}
