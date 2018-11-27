package com.meganour.kelkoo.recturement.collection.crud.commons;

import java.util.Properties;
/**
 * L'interface implementee par les accesseurs de ressources de configuration de l'application.
 * @author megaNour
 *
 */
public interface ResourceReader {
    /**
     * Permet de lire un fichier de resource contenant dans un artifact.
     * @param fileName le chemin relatif du fichier depuis la racine de l'artifact.
     * @return le contenu du fichier.
     */
    String getResource(String fileName);
    /**
     * Permet charger un fichier de proprietes.
     * @param fileName le chemin relatif du fichier depuis la racine de l'artifact.
     * @return le @Properties demande. Sinon un @Properties vide.
     */
    Properties getProperties(String fileName);
}
