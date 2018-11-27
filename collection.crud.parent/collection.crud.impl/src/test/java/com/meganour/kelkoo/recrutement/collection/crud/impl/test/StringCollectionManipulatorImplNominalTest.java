package com.meganour.kelkoo.recrutement.collection.crud.impl.test;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.meganour.kelkoo.recrutement.collection.crud.api.StringCollectionManipulator;
import com.meganour.kelkoo.recrutement.collection.crud.impl.StringCollectionManipulatorImpl;

/**
 * Classe de tests unitaires permettant de verifier le bon fonctionnement de notre
 * classe @StringCollectionManipulatorImpl.
 * Cette classe teste remove(String[] args) qui elle meme appelle remove(String[] args, int index).
 * Les deux methodes sont par consequent testees.
 * @author megaNour
 *
 */
@RunWith(Parameterized.class)
public class StringCollectionManipulatorImplNominalTest {

    /**
     * Les arguments qui seraient passes en ligne de commande.
     */
    private String[] nominalArgs;
    /**
     * Les resultats attendus. null indique un echec.
     */
    private String[] nominalResult;

    /**
     * Constructeur a parametres de la classe de test.
     * @param paramArgs les arguments a tester.
     * @param paramExpected le retour attendu.
     */
    public StringCollectionManipulatorImplNominalTest(String[] paramArgs, String[] paramExpected) {
        nominalArgs = paramArgs;
        nominalResult = paramExpected;
    }

    /**
     * Creation des donnees de test.
     * On teste:
     * <code>
     *  <ul>
     *      <li>les extremites du tableau et le milieu.</li>
     *      <li>les debordements d'index</li>
     *      <li>le tableau d'arguments vide</li>
     *      <li>le tableau qui ne contient qu'une chaine</li>
     *      <li>le tableau qui ne contient qu'un chiffre</li>
     *      <li>le melange de chiffres et lettres en argument d'index</li>
     *      <li>les flottants en argument d'index</li>
     *      <li>les tableau sans index a la fin</li>
     *  </ul>
     * </code>
     * @return une collection de tableaux d'objets pour JUnit.
     */
    @Parameters
    public static Collection<Object[][]> makeData() {
        Object[][][] donnees = new Object[][][] {
            new String[][] {
                {"bonbon", "chocolat", "dorade", "eclair", "3"},
                {"bonbon", "chocolat", "eclair"},
            },
            new String[][] {
                {"bonbon", "chocolat", "dorade", "eclair", "1"},
                {"chocolat", "dorade", "eclair"},
            },
            new String[][] {
                {"bonbon", "chocolat", "dorade", "eclair", "4"},
                {"bonbon", "chocolat", "dorade"},
            },
            new String[][] {
                {"bonbon", "chocolat", "dorade", "eclair", "5"},
                null
            },
            new String[][] {
                {""},
                null
            },
            new String[][] {
                {"2"},
                null
            },
            new String[][] {
                {"bonbon"},
                null
            },
            new String[][] {
                {"bonbon", "chocolat", "dorade", "eclair", "0"},
                null
            },
            new String[][] {
                {"bonbon", "chocolat", "dorade", "eclair", "1.5"},
                null
            },
            new String[][] {
                {"bonbon", "chocolat", "dorade", "eclair", "-2"},
                null
            },
            new String[][] {
                {"bonbon", "chocolat", "dorade", "eclair", "b-2"},
                null
            },
            new String[][] {
                {"bonbon", "chocolat", "dorade", "eclair"},
                null
            },
        };
        return Arrays.asList(donnees);
    }

    /**
     * Le deroulement du test.
     * Ce dernier verifie que le tableau d'origine, une fois altere par notre objet
     * donne bien le resultat escompte.
     */
    @Test
    public void nominalRemove() {
        StringCollectionManipulator manipulator = new StringCollectionManipulatorImpl();
        String[] result = manipulator.remove(nominalArgs);
        assertArrayEquals(nominalResult, result);
    }
}
