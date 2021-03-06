package yal.arbre.instructions;

import yal.analyse.Entree;
import yal.analyse.Symbole;
import yal.analyse.Bloc;
import yal.analyse.TDS;
import yal.arbre.expressions.Expression;
import yal.exceptions.AnalyseSemantiqueException;

public class Affectation extends Instruction
{
    protected String partieG;
    protected int deplacement;
    protected Expression partieD;


    /**
     * Gère les affectations entre deux variables
     * @param gauche variable qui prend l'affectation
     * @param droite variable qui donne sa valeur
     */
    public Affectation(String gauche, Expression droite) {
        super(droite.getNoLigne());
        partieG = gauche;
        partieD = droite;
    }

    @Override
    public void verifier()
    {
        Entree e = new Entree(partieG);
        Symbole s = TDS.getInstance().getBlocActuel().identifier(e);

        // On vérifie que la variable qui va prendre l'affectation est déclarée
        if(s==null)
            throw new AnalyseSemantiqueException(noLigne, partieG + " n'a pas été déclaré");
        deplacement = s.getTaille();
    }

    /**
     * Traduction de l'affectation en langage Assembleur MIPS
     * @return la chaîne de caractère correspondante
     */
    @Override
    public String toMIPS(){
        verifier();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("# Affectation  " + partieG + " = " + partieD + "\n");
        stringBuilder.append(partieD.toMIPS());
        stringBuilder.append("\tsw $a0, " + deplacement + "($s7) # Affectation\n\n");
        return stringBuilder.toString();
    }
}
