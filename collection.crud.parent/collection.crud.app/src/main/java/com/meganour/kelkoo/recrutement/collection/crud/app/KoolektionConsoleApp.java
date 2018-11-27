package com.meganour.kelkoo.recrutement.collection.crud.app;

import java.io.File;
import java.util.Locale;
import java.util.Properties;

import com.meganour.kelkoo.recrutement.collection.commons.impl.ResourceReaderImpl;
import com.meganour.kelkoo.recrutement.collection.crud.api.StringCollectionManipulator;
import com.meganour.kelkoo.recrutement.collection.crud.impl.StringCollectionManipulatorImpl;
import com.meganour.kelkoo.recturement.collection.crud.commons.ResourceReader;
/**
 * Cette application permet d'utiliser la classe retirant un element
 * precis d'un tableau de @String.
 * @author megaNour
 *
 */
public final class KoolektionConsoleApp {
    /**
     * Cette classe n'est pas destinee a etre instanciee.
     */
    private KoolektionConsoleApp() { };
    /**
     * Le nom du fichier de config de l'app.
     */
    private static final String CONFIG_NOM = "config.properties";
    /**
     * Le nom de la property contenant le nom du fichier manuel.
     */
    private static final String MANUEL_NOM = "manuel.nom.fichier";

    /**
     * Le point d'entree de l'application.
     * @param args un nombre variable de chaines de characteres qui se termine par un entier.
     */
    public static void main(String[] args) {
        StringCollectionManipulator manipulator = new StringCollectionManipulatorImpl();
        String[] result = manipulator.remove(args);
        if (result != null) {
            for (String s : result) {
                System.out.println(s);
            }
        } else {
            System.out.println(getMan());
        }
    }

    /**
     * Lire des ressources.
     * @return le contenu de la ressource.
     */
    private static String getMan() {
        ResourceReader resourceReader = new ResourceReaderImpl(KoolektionConsoleApp.class.getClassLoader());
        String langue = Locale.getDefault().getLanguage();
        Properties props = resourceReader.getProperties(CONFIG_NOM);
        props.getProperty(MANUEL_NOM);
        return resourceReader.getResource(langue + File.separator + props.getProperty(MANUEL_NOM));
    }
}
