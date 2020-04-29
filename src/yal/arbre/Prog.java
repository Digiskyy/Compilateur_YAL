package yal.arbre;

import yal.analyse.TDS;

public class Prog extends ArbreAbstrait {
    private BlocDInstructions listeDeclarations;
    private BlocDInstructions listeInstructions;

    public Prog(BlocDInstructions decl, BlocDInstructions li) {
        super(decl.getNoLigne());
        listeDeclarations = decl;
        listeInstructions = li;
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        StringBuilder str = new StringBuilder();
        str.append("# Début d'un programme\n" +
                ".text\n" +
                "main :\n"+
                "#Initialiser $s7 (registre 7) avec $sp\n" +
                "\tmove $s7, $sp\n\n");
        str.append("# Réserver la place pour "+ TDS.getInstance().getBlocActuel().getCompteur() +" variables dans $s7\n" +
                "\tadd $sp, $sp,"+  TDS.getInstance().getBlocActuel().getCompteur() * (-4) +"\n\n");
        str.append(listeDeclarations.toMIPS() + listeInstructions.toMIPS());
        str.append("# Fin du programme\n" +
                "end :\n" +
                "\tli $v0, 10\n" +
                "\tsyscall");
        return str.toString();
    }
}
