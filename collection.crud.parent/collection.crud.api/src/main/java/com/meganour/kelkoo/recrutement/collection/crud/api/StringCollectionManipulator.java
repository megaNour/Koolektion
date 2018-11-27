package com.meganour.kelkoo.recrutement.collection.crud.api;
/**
 *
 * @author megaNour
 * Le manipulateur de collection doit pouvoir...
 */
public interface StringCollectionManipulator {
    /**
     * Une methode pour supprimer une entree d'un tableau de String donne.
     * @param input le tableau en entree dont on veut retirer un String.
     * @param index l'index en BASE 1 a retirer du tableau.
     * @return un nouveau tableau allege de la ligne indiquee en index.
     */
    String[] remove(String[] input, int index);
    /**
     * Cette methode permet de garder la logique de verification des arguments dans
     * l'implementation de {@link StringCollectionManipulator}.
     * En effet, l'argument index est deduit apres verification en interne.
     * Les applications qui appellent cette methode n'auront pas a faire de verif metier.
     * @param args le tableau de String ET l'index a retirer
     * @return le nouveau tableau si tout s'est bien passe, sinon null.
     */
    String[] remove(String[] args);
}
