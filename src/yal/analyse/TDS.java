package yal.analyse;

import yal.exceptions.AnalyseSyntaxiqueException;

import java.util.HashMap;

public class TDS {
    private static TDS instance  = new TDS();
    private HashMap<Entree, Symbole> tableau;

    private TDS(){
        tableau = new HashMap<Entree, Symbole>();
    }

    public static TDS getInstance() {
        return instance;
    }

    public void ajouter(Entree e, Symbole s){
        if(tableau.containsKey(e)){
            throw new AnalyseSyntaxiqueException("Une variable ne peut pas être déclarée deux fois");
        }
        tableau.put(e,s);
    }

    Symbole identifier(Entree e){
        return tableau.get(e);
    }
}
