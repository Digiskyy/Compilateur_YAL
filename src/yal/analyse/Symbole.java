package yal.analyse;

public class Symbole
{
    public enum typeVariable
    {
        entier,
        booleen,
        reel;
    }
    public String type;

    public Symbole(String type, int n)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return type;
    }
}
