package yal.arbre.expressions;

public class ConstanteEntiere extends Constante {
    
    public ConstanteEntiere(String texte, int n) {
        super(texte, n) ;
    }

    @Override
    public String toMIPS()
    {
        // Ecriture en assembleur MIPS d'une constante entière
        return "# Ecriture d'une constante entière\n" +
                "\tli $v0, 1\n" +
                "\tli $a0, " + cste;
    }

}
