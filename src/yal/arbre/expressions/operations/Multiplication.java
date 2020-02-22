package yal.arbre.expressions.operations;

import yal.arbre.expressions.Expression;
import yal.arbre.expressions.Operation;

public class Multiplication extends Operation
{
    public Multiplication(Expression gauche, Expression droite)
    {
        super(gauche, droite);
    }

    /**
     * Modèle de traduction de la multiplication en assembleur MIPS
     * @return la chaîne de caractère en MIPS correspondante à la multiplication
     */
    @Override
    public String toMIPS()
    {
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
        str.append("\tmult $t8, $a0 # Multiplication\n");
        /* La multiplication en MIPS stocke les 32 premiers bits du résultat dans le registre spécial lo, et les 32 autres bits suivants dans le registre hi.
        Cela est fait pour gérer le résultat lorsqu'il dépasse la capacité d'un registre (32 bits), pour des grands nombres.
        lo et hi ne sont pas adressables, on y accède par les instructions mflo et mfhi (move from lo / hi).
        Il faut donc gérer le résultat quand hi n'est plus égal à 0 (en cas de dépassement, "overflow").
         */
        str.append("\tmflo $a0 # Les 32 premiers bits du résultats sont stockés dans le registre lo\n");

        return str.toString();
    }

    @Override
    public String toString()
    {
        return partieGauche + " * " + partieDroite;
    }
}
