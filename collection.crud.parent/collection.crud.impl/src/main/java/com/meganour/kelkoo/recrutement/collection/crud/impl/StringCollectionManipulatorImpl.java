package com.meganour.kelkoo.recrutement.collection.crud.impl;

import java.util.Arrays;

import com.meganour.kelkoo.recrutement.collection.crud.api.StringCollectionManipulator;

/**
 *
 * @author megaNour
 * Implementation du manipulateur de String {@link #StringCollectionManipulatorImpl()}.
 */
public class StringCollectionManipulatorImpl implements StringCollectionManipulator {
    /**
     * {@inheritDoc}
     * Dans cette implementation, on fait bien 2 appels successifs a une meme methode,
     * menant a l'enchainement de 2 boucles for.
     * Le nombre d'iteration total ne change pas. Il est egal a la taille du nouveau tableau.
     * Seulement en coupant notre boucle en 2, on se dispense de verifier a chaque iteration
     * si l'index doit etre copie ou non.
     * On copie jusqu'a atteindre l'index a sauter
     * puis on copie depuis juste apres jusqu'a la fin.
     */
    @Override
    public String[] remove(String[] input, int index) {
        String[] result;
        /**
         * Un try permettra de gerer finement les erreurs a l'avenir.
         * Je l'ai privillegie a un if (input != null && index >= 0 && index < input.length).
         */
        try {
            result = new String[input.length - 1];
            extractAndCopySlice(input, result, 1, index, 0);
            extractAndCopySlice(input, result, index, input.length, 1);
        /**
         * On catch ces types ensemble car le seul traitement voulu est le retour de null en cas
         * de pepin. Cependant si pour chaque cas on voulait un traitement specifique,
         * On pourrait faire deux catch distincts.
         * Je ne fais pas de catch Exception car on ne veut pas tout catcher, seulement ces deux cas.
         */
        } catch (NullPointerException | IndexOutOfBoundsException | NegativeArraySizeException e) {
            //e.printStackTrace();
            result = null;
        }
        /**
         * Dans notre cas, un finally est inutile.
         */
        return result;
    }

    /**
     * Cette methode permet de copier des portions de tableau d'un index de depart inclus
     * a un index de fin exclus.
     * Outre la dispense de verification a chaque iteration, cette implementation offre
     * une maniere plus souple de travailler.
     * On peut ainsi imaginer une methode a retraits multiples sans conditions compliquees,
     * mais aussi une jointure de differents tableaux.
     * @param input le tableau d'entree dont on extrait les donnees.
     * @param result le tableau cible qui copie les donnees.
     * @param startIndex l'index INCLUSIF auquel on commence en base 1.
     * @param stopIndex l'index EXCLUSIF auquel on termine en base 1.
     * @param decallage le decallage a operer entre les tableaux.
     */
    private void extractAndCopySlice(
            String[] input, String[] result, int startIndex, int stopIndex, int decallage) {
        for (int i = startIndex - 1; i < stopIndex - 1; i++) {
            result[i] = input[i + decallage];
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] remove(String[] args) {
        String[] result = null;
        if (args != null) {
            try {
                //l'input correspond a tout le tableau sauf la derniere entree
                String[] input = Arrays.copyOfRange(args, 0, args.length - 1);
                //la derniere entree correspond a l'index
                int index = Integer.parseInt(args[args.length - 1]);
                result = remove(input, index);
            } catch (IllegalArgumentException e) {
                //e.printStackTrace();
            }
        }
        return result;
    }
}
