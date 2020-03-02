package yal.analyse;

/**
 * Un symbole peut représenter une variable (son type) ou une fonction (sa signature)
 */
public abstract class Symbole
{
    public int taille;
    private Bloc blocOuJeSuis; // Bloc où est déclaré le symbole (son bloc père)

    public Symbole(Bloc bloc)
    {
        blocOuJeSuis = bloc;
        taille = bloc.getTailleVariable();
    }

    public int getTaille()
    {
        return taille;
    }
}
