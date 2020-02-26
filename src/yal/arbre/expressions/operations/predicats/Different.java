package yal.arbre.expressions.operations.predicats;

import yal.arbre.expressions.Expression;
import yal.arbre.expressions.Operation;

public class Different extends Operation {
    public Different(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String toMIPS() {
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

        // Difference et mise dans $a0
        str.append("\tsne $a0, $t8, $a0 # Different\n");

        return str.toString();
    }

    @Override
    public String toString() {
        return partieGauche+" != "+partieDroite;
    }
}
