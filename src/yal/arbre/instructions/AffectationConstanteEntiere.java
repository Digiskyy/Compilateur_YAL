package yal.arbre.instructions;

import yal.analyse.Entree;
import yal.analyse.Symbole;
import yal.analyse.TDS;
import yal.arbre.expressions.ConstanteEntiere;
import yal.exceptions.AnalyseSemantiqueException;

public class AffectationConstanteEntiere extends Affectation {
    protected ConstanteEntiere partieD;

    /**
     * Affecte un entier à une variable
     * @param idf variable à affecter
     * @param cons valeur souhaitée
     */
    public AffectationConstanteEntiere(String idf, ConstanteEntiere cons) {
        super(cons.getNoLigne());
        partieG = idf;
        partieD = cons;
    }

    @Override
    public void verifier() {
        Entree e = new Entree(partieG);
        Symbole s = TDS.getInstance().identifier(e);

        //On vérifie que la variable qui doit être affectée est déclarée
        if(s==null){
            throw new AnalyseSemantiqueException(noLigne, partieG+ " n'a pas été déclaré.");
        }

        deplacement = s.getTaille();
    }

    @Override
    public String toMIPS() {
        verifier();
        StringBuilder str = new StringBuilder();
        str.append("# Affectation " + partieG + " = " + partieD + "\n");
        str.append("\tli $v0, "+partieD+"\n");
        str.append("\tsw $v0, "+deplacement+"($s7)\n\n");
        return str.toString();
    }
}
