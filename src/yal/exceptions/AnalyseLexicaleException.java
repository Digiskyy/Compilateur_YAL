package yal.exceptions;

public class AnalyseLexicaleException extends AnalyseException
{
 
    public AnalyseLexicaleException(int ligne, int colonne, String m)
    {
        super("ERREUR LEXICALE :\n\t" +
                "ligne " + ligne + " colonne " + colonne + "\n\t"
                + m + " : caractère non reconnu") ;
    }

}
