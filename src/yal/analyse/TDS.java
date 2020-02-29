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
    private int cpt = 0;
    private int tailleType = 4;
    private boolean instructions = false;

    private TDS()
    {
        table = new HashMap<Entree, Symbole>();
    }

    public static TDS getInstance()
    {
        return instance;
    }

    /**
     * Appel dans verifier() de l'analyseur syntaxique
     * @param e entrée : nom du symbole (nom de variable, de fonction)
     * @param s symbole : type de la variable associé au nom e
     */
    public void ajouter(Entree e, Symbole s) // throws AnalyseSyntaxiqueException => pas obligé car ExceptionRunTime
    {
        if(table.containsKey(e))
        {
            throw new AnalyseSyntaxiqueException("Une variable ne peut pas être déclarée deux fois.");
        }
        if(instructions){
            throw new AnalyseSyntaxiqueException("Les déclarations sont avant les instructions");
        }

        table.put(e,s);
        cpt++;
    }

    public void entreeBloc(){
        System.out.println("ENTREE");
    }

    public void sortieBloc(){
        System.out.println("SORTIE");
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

    public int tailleVariable(){
        return table.size()*-tailleType;
    }

    public int getTailleZoneVariable()
    {
        return 0;
    }

    public int getCpt()
    {
        return cpt;
    }

    public void setInstructions(boolean instructions) {
        this.instructions = instructions;
    }
}