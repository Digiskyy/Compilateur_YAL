package yal.arbre;

import yal.analyse.TDS;
import yal.arbre.instructions.Instruction;

import java.util.ArrayList;

/**
 * 21 novembre 2018
 *
 * @author brigitte wrobel-dautcourt
 */

public class BlocDInstructions extends ArbreAbstrait {
    
    protected ArrayList<ArbreAbstrait> programme ;
    private boolean premiereInstruction = false;

    public BlocDInstructions(int n) {
        super(n) ;
        programme = new ArrayList<>() ;
    }
    
    public void ajouter(ArbreAbstrait a) {
        programme.add(a) ;
    }
    
    @Override
    public String toString() {
        return programme.toString() ;
    }

    @Override
    public void verifier()
    {
    }
    
    @Override
    public String toMIPS()
    {
        StringBuilder strB = new StringBuilder("# Début d'un programme\n" +
                                                ".text\n" +
                                                "main :\n"+
                "# Initialiser $s7 (registre 7) avec $sp\n" +
                "    move $s7, $sp\n");

        for(ArbreAbstrait arb : programme)
        {
            if(arb instanceof Instruction && !premiereInstruction){
                strB.append("# Réserver la place pour "+ TDS.getInstance().getCpt()+" variables dans $s7\n" +
                        "    add $sp, $sp,"+ TDS.getInstance().getCpt()*-4+"\n");
                premiereInstruction = true;
            }
            strB.append(arb.toMIPS());
        }
        strB.append("# Fin du programme\n" +
                    "end :\n" +
                    "\tli $v0, 10\n" +
                    "\tsyscall");
        
        return strB.toString();
    }

}
