package yal.arbre.instructions;

import yal.analyse.Entree;
import yal.analyse.Symbole;
import yal.analyse.TDS;
import yal.arbre.expressions.Expression;
import yal.exceptions.AnalyseSemantiqueException;
import yal.exceptions.AnalyseSyntaxiqueException;

public class AffectationVariable extends Affectation {
    protected String partieD;
    private  Symbole symboleDroit;

    /**Gère les affectations entre deux variables
     * @param gauche variable qui prend l'affectation
     * @param droite variable qui donne sa valeur
     * @param n position
     */
    public AffectationVariable(String gauche, String droite, int n) {
        super(n);
        partieG = gauche;
        partieD = droite;
    }


    @Override
    public void verifier() {
        Entree e = new Entree(partieG);
        Symbole s = TDS.getInstance().identifier(e);
        //On vérifie que la variable qui va prendre l'affectation est déclarée
        if(s==null){
            throw new AnalyseSemantiqueException(noLigne, partieG+ " n'a pas été déclaré");
        }
        deplacement = s.getTaille();


        Entree entreeDroite = new Entree(partieD);
        symboleDroit = TDS.getInstance().identifier(entreeDroite);
        //On vérifie que la variable qui donne sa valeur est déclarée
        if(symboleDroit==null){
            throw new AnalyseSemantiqueException(noLigne, partieD+ " n'a pas été déclaré.");
        }
    }

    @Override
    public String toMIPS() {
        verifier();
        System.out.println("FIN");

        int deplacementDroite = symboleDroit.getTaille();
        StringBuilder str = new StringBuilder();
        str.append("# Affectation " + partieG + " = " + partieD + "\n");
        str.append("\tlw $v0, "+ deplacementDroite+"($s7)\n");
        str.append("\tsw $v0, "+deplacement+"($s7)\n\n");
        return str.toString();
    }
}
