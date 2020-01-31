package yal.exceptions;

public class AnalyseSyntaxiqueException extends AnalyseException
{
 
    public AnalyseSyntaxiqueException(String m)
    {
        super("ERREUR SYNTAXIQUE ligne :\n\t" + m) ;
    }

    public AnalyseSyntaxiqueException(String m, int ligne)
    {
        super("ERREUR SYNTAXIQUE ligne "+ligne+" :\n\t" + m) ;
    }

}
