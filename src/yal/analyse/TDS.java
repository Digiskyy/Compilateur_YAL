package yal.analyse;


public class TDS
{
    private Bloc blocActuel;
    private static TDS instance = new TDS();
    private int cpt = 0;
    private final int tailleType = 4;

    private TDS()
    {

    }

    public static TDS getInstance()
    {
        return instance;
    }

    /**
     * Crée un nouveau bloc et l'ajoute dans la liste
     */
    public void entreeBloc()
    {
        if(blocActuel == null)
            blocActuel = new Bloc(); // Bloc racine
        else
        {
            blocActuel = new Bloc(blocActuel);
        }
        cpt++;
    }

    /**
     * Le bloc actuel devient le bloc père
     */
    public void sortieBloc()
    {
        blocActuel = blocActuel.getBlocPere();
        cpt--;
    }

    public Bloc getBlocActuel()
    {
        return blocActuel;
    }

    public int getCpt() {
        return cpt;
    }

    public int getTailleType() {
        return tailleType;
    }
}
