package yal.arbre.instructions;

import yal.arbre.BlocDInstructions;

public class Fonction extends Instruction {
    private String nomFonction;
    private BlocDInstructions listeInstructions;

    public Fonction(String idf, BlocDInstructions liste) {
        super(liste.getNoLigne());
        nomFonction = idf;
        listeInstructions = liste;
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        return listeInstructions.toMIPS();
    }
}
