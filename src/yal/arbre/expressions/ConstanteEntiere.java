package yal.arbre.expressions;

public class ConstanteEntiere extends Constante {
    
    public ConstanteEntiere(String texte, int n) {
        super(texte, n) ;
    }


    /**
     * Ecriture en assembleur MIPS d'une constante entière
     * @return
     */
    @Override
    public String toMIPS()
    {
        return "\tli $a0, " + cste + "\n";
    }

}
