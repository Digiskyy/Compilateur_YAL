package yal.analyse;

import yal.exceptions.AnalyseSyntaxiqueException;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Représente un bloc, à chaque bloc est associé une table des symboles
 */
public class Bloc
{
    private HashMap<Entree, Symbole> table; // Table Des Symboles
    private Bloc blocPere;
    private ArrayList<Bloc> blocsFils;
    private int cpt = 0;
    private final int tailleType = 4;
    private boolean instructions = false;
    private boolean blocRacine;

    public Bloc() // Pour le bloc principal qui n'a pas de bloc père
    {
        blocRacine = true;
        blocsFils = new ArrayList<>();
        table = new HashMap<Entree, Symbole>();
    }

    public Bloc(Bloc blocPere)
    {
        this.blocPere = blocPere;
        blocsFils = new ArrayList<>();
        table = new HashMap<Entree, Symbole>();
        blocRacine = false;
    }

    /**
     * Appel dans verifier() de l'analyseur syntaxique
     * @param e entrée : nom du symbole (nom de variable, de fonction)
     * @param s symbole : type de la variable associé au nom e
     */
    public void ajouter(Entree e, Symbole s) // throws AnalyseSyntaxiqueException => pas obligé car ExceptionRunTime
    {
        if(table.containsKey(e))
            throw new AnalyseSyntaxiqueException("Une variable ne peut pas être déclarée deux fois.");

        if(instructions)
            throw new AnalyseSyntaxiqueException("Les déclarations sont avant les instructions");

        table.put(e,s);
        cpt++;
    }

    /**
     * Renvoie la table des symboles
     * @return la tds
     */
    public HashMap<Entree, Symbole> getTds()
    {
        return table;
    }

    /**
     * On ajoute un bloc dans la collection des blocs fils, c-à-d ceux déclarés directement dans le bloc là
     * @param fils bloc déclaré à l'intérieur du bloc père
     */
    public void ajouterBlocFils(Bloc fils)
    {
        blocsFils.add(fils);
    }

    /**
     * Parcourt toutes les déclarations de la tables des symboles, si le symbole cherché n'y est pas,
     * on remonte et fait la même chose dans le bloc père, et ainsi de suite, jusqu'à le trouver.
     * Appel dans vérifier() de l'analyseur sémantique
     * @param e nom de la variable
     * @return le symbole (type ou signature de fonction) de l'entrée associé au nom e dans la tds
     */
    public Symbole identifier(Entree e)
    {
        Symbole s = table.get(e);
        if(s == null && !blocRacine) // Si le symbole n'est pas dans ce bloc, on remonte dans le bloc père
            s = blocPere.identifier(e);

        return s;
    }

    public int getTailleVariable()
    {
        return table.size()*-tailleType;
    }

    public int getCompteur()
    {
        return cpt;
    }

    public void setInstructions(boolean instructions)
    {
        this.instructions = instructions;
    }

    public Bloc getBlocPere()
    {
        if(blocRacine)
            return this;
        return blocPere;
    }
}