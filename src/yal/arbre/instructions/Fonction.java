package yal.arbre.instructions;

import yal.analyse.TDS;
import yal.arbre.BlocDInstructions;

public class Fonction extends Instruction {
    private String nomFonction;
    private BlocDInstructions listeInstructions;

    /**
     * Permet de déclarer une fonction
     * @param idf nom de la fonction
     * @param liste instructions que la fonction réalise
     */
    public Fonction(String idf, BlocDInstructions liste) {
        super(liste.getNoLigne());
        nomFonction = idf;
        listeInstructions = liste;
    }

    @Override
    public void verifier() {
        listeInstructions.verifier();
    }

    @Override
    public String toMIPS() {
        StringBuilder mips = new StringBuilder("#Fonction\n" + nomFonction + ":\n" +
                "#Empile l'adresse de retour\n" +
                "\tsw $ra, 0($sp)\n" +
                "\tadd $sp, $sp, -4\n" + "\n" +
                "#Empilement chainage dynamique\n" +
                "\tsw $s7, 0($sp)\n" +
                "\tadd $sp, $sp, -4\n" + "\n" +
                "#Empilement de l'id de la region\n" +
                "\tli $t8, " + TDS.getInstance().getCpt() + "\n" +
                "\tsw $t8, 0($sp)\n"+
                "\tadd $sp, $sp, -4\n" + "\n" +
                "#Deplacement de la base\n" +
                "\tmove $s7, $sp\n" + "\n" +
                "#Allocation des variables \n" +
                "\tadd $sp, $sp , -" + TDS.getInstance().getTailleType() + "\n" +
                "# initialisation de toutes les variables a 0\n") ;

        for(int dep = 0; dep < TDS.getInstance().getTailleType() ; dep += 4) {
            mips.append("\tsw $zero, -");
            mips.append(dep);
            mips.append("($s7)\n");
        }

        mips.append("#Instruction dans la fonction\n");
        mips.append(listeInstructions.toMIPS());
        mips.append("\n");

        return mips.toString();
    }

    @Override
    public String toString() {
        return "Fonction " + nomFonction;
    }
}
