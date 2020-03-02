package yal.arbre.expressions.operations;

import yal.arbre.expressions.ConstanteEntiere;
import yal.arbre.expressions.Expression;
import yal.arbre.expressions.Operation;
import yal.exceptions.AnalyseSemantiqueException;

public class Division extends Operation
{
    public Division(Expression gauche, Expression droite)
    {
        super(gauche, droite);
    }

    @Override
    public void verifier() {
        if (partieDroite instanceof ConstanteEntiere){
            if(partieDroite.toString().equals("0")){
                throw new AnalyseSemantiqueException(noLigne, "Division par zéro.");
            }
        }
    }

    /**
     * Modèle de traduction de la division en assembleur MIPS
     * @return la chaîne de caractère en MIPS correspondante à la division
     */
    @Override
    public String toMIPS()
    {
        verifier();
        StringBuilder str = new StringBuilder();
        str.append(super.toMIPS()+toString()+"\n");

        // Evaluation de l'opérande gauche et mise de sa valeur dans $a0
        str.append(partieGauche.toMIPS() + "\n");

        // Empilement $a0
        str.append("\t# Empilement de $a0\n");
        str.append("\tsw $a0, 0($sp)\n");
        str.append("\tadd $sp, $sp, -4\n");

        // Evaluation de l'opérande droit et mise de sa valeur dans $a0
        str.append(partieDroite.toMIPS() + "\n");

        // Dépilement de $a0 et mise de la valeur dans $t8
        str.append("\t# Dépilement de $a0\n");
        str.append("\tadd $sp, $sp, 4\n");
        str.append("\tlw $t8, ($sp)\n");

        // Multiplication et mise dans $a0
        str.append("\tdiv $t8, $a0 # Division entière\n");

        /* La division en MIPS estr une division entière.
        Le dividende est stocké dans le registre spécial lo et le reste de la division est stocké dans le registre spécial hi.
        lo et hi ne sont pas adressables, on y accède par les instructions mflo et mfhi (move from lo / hi).
         */
        str.append("\tmflo $a0 # Le dividende est stocké dans le registre lo, le reste dans le registre hi.\n");

        return str.toString();
    }

    @Override
    public String toString()
    {
        return partieGauche + " / " + partieDroite + " (Division entière)";
    }
}
