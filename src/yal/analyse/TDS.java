package yal.analyse;


public class TDS
{
    private Bloc blocActuel;
    private static TDS instance = new TDS();

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
        System.out.println("ENTREE");
        if(blocActuel == null)
            blocActuel = new Bloc(); // Bloc racine
        else
        {
            // blocActuel = new Bloc(blocActuel); // Bloc fils
            System.out.println(blocActuel);
            Bloc b = new Bloc(blocActuel);
            blocActuel = b;
            System.out.println(blocActuel);
        }
    }

    /**
     * Le bloc actuel devient le bloc père
     */
    public void sortieBloc()
    {
        System.out.println("SORTIE");
        System.out.println("ZOUZOU" + blocActuel);
        System.out.println(blocActuel.getBlocPere());
        blocActuel = blocActuel.getBlocPere();
        System.out.println("ZaZa" + blocActuel);
    }

    public Bloc getBlocActuel()
    {
        return blocActuel;
    }
}
