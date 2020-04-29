package yal.arbre.instructions;

import yal.analyse.TDS;
import yal.arbre.expressions.Expression;

public class Retourner extends Instruction {
    private Expression expression;
    private static int cpt = 0;

    public Retourner(Expression e) {
        super(e.getNoLigne());
        expression = e;
        cpt++;
    }


    @Override
    public void verifier() {

    }


    @Override
    public String toMIPS() {
        String mips = "# Retour de la fonction \n" +
                "# Mets "+ expression.toString()+" dans $v0\n" +
                expression.toMIPS() + "\n";

        if(TDS.getInstance().getCpt() > 0){
            mips = mips +
                    "# Retire les variables de la pile\n" +
                    "\tmove $sp, $s7\n" +
                    "\tlw $s7, 8($sp)\n" +
                    "# Dépile le bloc numéro "+TDS.getInstance().getCpt()+" \n" +
                    "\tadd $sp, $sp, 12\n" +
                    "\tlw $ra, 0($sp)\n" + "\n" +
                    "# Sauvegarde la valeur dans $v0\n" +
                    "\tsw $v0, 4($sp)\n"+"\n" +
                    "# Jump vers le bloc père\n" +
                    "\tjr $ra\n" +
                    "\n";
        }
        else{
            mips = mips + "# Jump à la fin du programme\n"
                      + "\tj retour"+cpt+"\n";
        }
        return mips;
    }
}
