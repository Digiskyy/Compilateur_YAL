package yal.analyse;

import yal.exceptions.AnalyseSyntaxiqueException;

import java.util.HashMap;


/**
 * Singleton de la table des symboles
 */
public class TDS
{
    private static TDS instance  = new TDS();
    private HashMap<Entree, Symbole> table;
    private int cptDeplacement;

    private TDS()
    {
        cptDeplacement = 0;
        table = new HashMap<Entree, Symbole>();
    }

    public static TDS getInstance()
    {
        return instance;
    }

    /**
     * Appel dans verifier() de l'analyseur syntaxique
     * @param e
     * @param s
     */
    public void ajouter(Entree e, Symbole s) // throws AnalyseSyntaxiqueException
    {
        if(table.containsKey(e))
        {
            throw new AnalyseSyntaxiqueException("Une variable ne peut pas être déclarée deux fois.");
        }
        table.put(e,s);
    }

    /**
     * Appel dans vérifier() de l'analyseur sémantique
     * @param e nom de la variable
     * @return le symbole (type) de la variable associé au nom e
     */
    public Symbole identifier(Entree e)
    {
        return table.get(e);
    }

    public int getTailleZoneVariable()
    {
        return 0;
    }

    public int getCptDeplacement()
    {
        return cptDeplacement;
    }
}
