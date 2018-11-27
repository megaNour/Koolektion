package com.meganour.kelkoo.recrutement.collection.commons.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.meganour.kelkoo.recturement.collection.crud.commons.ResourceReader;
/**
 * Une premiere implementation de @ResourceReader.
 * @author megaNour
 *
 */
public class ResourceReaderImpl implements ResourceReader {

    /**
     * Le classLoader est fourni lors de l'instantiation
     * pour ne pas dependre de la classe qui l'instancie.
     */
    private ClassLoader classLoader;

    /**
     * Une @Map permettant de stocker les @Properties deja instanciees.
     */
    private Map<String, Properties> propsMap;

    /**
     * Constructeur de la classe.
     * @param paramClassLoader permet de choisir le classLoader.
     */
    public ResourceReaderImpl(ClassLoader paramClassLoader) {
        classLoader = paramClassLoader;
        propsMap = new HashMap<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getResource(String fileName) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream(fileName)))) {
            String line;
            while ((line = br.readLine()) != null) {
                result.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            //e.printStackTrace();
        }
        return result.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Properties getProperties(String fileName) {
        if (propsMap.get(fileName) == null) {
            Properties props = readProperties(fileName);
            propsMap.put(fileName, props);
            return props;
        }
        return propsMap.get(fileName);
    }

    /**
     * C'est ici qu'on verifie si la @Properties est deja en memoire.
     * Si elle ne l'est pas, on l'instancie.
     * @param fileName le chemin relatif du fichier depuis la racine de l'artifact.
     * @return la @Properties demandee ou une nouvelle @Properties en cas d'echec.
     */
    private Properties readProperties(String fileName) {
        Properties props = new Properties();
        try {
            InputStream inputProperties;
            inputProperties = classLoader.getResourceAsStream(fileName);
            props.load(inputProperties);
        } catch (IOException e) {
            //e.printStackTrace();
        }
        return props;
    }
}
