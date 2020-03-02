package yal.analyse;

public class SymboleVariable extends Symbole
{
    private final String type;

    public SymboleVariable(Bloc bloc, String type)
    {
        super(bloc);
        this.type = type;
    }

    /**
     * Vérifie si le type de la variable est un entier
     * @return Vrai si c'est un entier, faux sinon
     */
    public boolean estEntier()
    {
        return type.equals("entier");
    }

    /**
     * Vérifie si le type de la variable est un booléen
     * @return Vrai si c'est un booléen, faux sinon
     */
    public boolean estBooleen()
    {
        return type.equals("booleen");
    }

    @Override
    public String toString()
    {
        return type;
    }
}
