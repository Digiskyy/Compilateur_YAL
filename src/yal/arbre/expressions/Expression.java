package yal.arbre.expressions;

import yal.arbre.ArbreAbstrait;

public abstract class Expression extends ArbreAbstrait
{
    
    protected Expression(int n)
    {
        super(n) ;
    }

    public String getComparaison1(){ return "";
    }

    public String getComparaison2(){ return "";
    }
}
