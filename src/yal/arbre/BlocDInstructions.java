package yal.arbre;

import yal.analyse.Bloc;
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
    static boolean premiereInstruction = false;
    private boolean blocPrincipal = false;
    private Bloc bloc;

    public BlocDInstructions(int n)
    {
        super(n) ;
        programme = new ArrayList<>() ;
        bloc = new Bloc();
    }

    public BlocDInstructions(int n, Bloc blocPere)
    {
        this(n);
        bloc = blocPere;
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
            if(arb instanceof Instruction && !premiereInstruction)
            {
                strB.append("# Début d'un programme\n" +
                            ".text\n" +
                            "main :\n"+
                            "#Initialiser $s7 (registre 7) avec $sp\n" +
                            "\tmove $s7, $sp\n\n");
                strB.append("# Réserver la place pour "+ bloc.getCompteur() +" variables dans $s7\n" +
                            "\tadd $sp, $sp,"+ bloc.getCompteur() * (-4) +"\n\n");
                premiereInstruction = true;
                bloc.setInstructions(true);
                blocPrincipal = true;
            }
            strB.append(arb.toMIPS());
        }
        //On vérifie qu'il s'agit du bloc principal
        if(blocPrincipal)
        {
            strB.append("# Fin du programme\n" +
                    "end :\n" +
                    "\tli $v0, 10\n" +
                    "\tsyscall");
        }
        
        return strB.toString();
    }

}
