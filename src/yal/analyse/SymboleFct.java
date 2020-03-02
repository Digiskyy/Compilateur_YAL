package yal.analyse;

import java.util.ArrayList;

public class SymboleFct extends Symbole
{
    private ArrayList<String> signatureFct;

    public SymboleFct(Bloc bloc, ArrayList<String> signature)
    {
        super(bloc);
        this.signatureFct = signature;
    }
}
