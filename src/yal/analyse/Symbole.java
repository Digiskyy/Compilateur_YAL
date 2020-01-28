package yal.analyse;

public class Symbole
{
    public final String type;
    public int taille;

    public Symbole(String type)
    {
        this.type = type;
        taille = TDS.getInstance().tailleVariable();
    }

    @Override
    public String toString()
    {
        return type;
    }

    public int getTaille() {
        return taille;
    }

    public boolean estEntier(){
        return type.equals("entier");
    }

    public boolean estReel(){
        return type.equals("reel");
    }

    public boolean estBooleen(){
        return type.equals("booleen");
    }
}
