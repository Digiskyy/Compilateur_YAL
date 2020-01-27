package yal.analyse;

import java.util.Objects;

public class Entree
{
    private String nomVariable;

    public Entree(String nom){
        nomVariable = nom;
    }

    public String getNomVariable() {
        return nomVariable;
    }

    @Override
    public String toString()
    {
        return nomVariable;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entree entree = (Entree) o;
        return Objects.equals(nomVariable, entree.nomVariable);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(nomVariable);
    }
}
