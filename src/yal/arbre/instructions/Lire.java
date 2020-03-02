package yal.arbre.instructions;

import yal.analyse.Entree;
import yal.analyse.Symbole;
import yal.analyse.Bloc;
import yal.exceptions.AnalyseSemantiqueException;


public class Lire extends Instruction
{
    private String idf;
    private Symbole s;

    /**
     * Permet de demander à l'utilisateur de rentrer une variable
     * @param idf nom de la variable à affecter
     * @param n numéro de ligne
     */
    public Lire(String idf, int n)
    {
        super(n);
        this.idf = idf;
    }

    @Override
    public void verifier()
    {
        Entree e = new Entree(idf);
        s = Bloc.getInstance().identifier(e);

        // On vérifie que la variable qui donne sa valeur est déclarée
        if(s == null)
            throw new AnalyseSemantiqueException(noLigne, idf+ " n'a pas été déclaré.");
    }

    @Override
    public String toMIPS() {
        verifier();
        StringBuilder str = new StringBuilder();
        str.append("#Lire "+idf+"\n");
        str.append("\tli $v0, 5 #Code du lire\n");
        str.append("\tsyscall\n");
        str.append("\tsw $v0,"+s.getTaille() +"($s7)\n\n");
        return str.toString();
    }
}
