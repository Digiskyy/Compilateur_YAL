package yal.analyse;

public class Symbole
{
    public enum typeVariable
    {
        entier,
        booleen,
        reel;
    }
    public final String type;

    public Symbole(String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return type;
    }
}
