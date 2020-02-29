package yal.arbre.instructions;

import yal.arbre.BlocDInstructions;

public class Fonction extends Instruction {
    private String nomFonction;
    private BlocDInstructions listeInstructions;

    /**
     * Permet de déclarer une fonction
     * @param idf nom de la fonction
     * @param liste instructions que la fonction réalise
     */
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
        return null;
    }

    @Override
    public String toString() {
        return "Fonction " + nomFonction;
    }
}
