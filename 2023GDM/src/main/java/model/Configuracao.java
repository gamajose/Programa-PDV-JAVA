/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Configuracao {

    public String loadParams(String key) throws FileNotFoundException, IOException {
        if (!new File("config.properties").exists()) {
            saveParamChangesDefault();
        }
        Properties props = new Properties();
        InputStream is = new FileInputStream("config.properties");
        props.load(is);

        String value = props.getProperty(key);

        return value;
    }

    public void saveParamChangesDefault() throws IOException {

        if (!new File("config.properties").exists()) {
            FileWriter fl = new FileWriter(new File("config.properties"));
            fl.close();
        }

        try {
            PropertiesConfiguration config = new PropertiesConfiguration("config.properties");

            config.setProperty("fluxo_acumulado", "yes");
            config.setProperty("backup_auto", "no");
            config.setProperty("folder_drop", "no");
            config.save();

            System.out.println("Config Successfully Updated..");
        } catch (ConfigurationException ex) {

        }

    }

    public String loadParamsPrint(String key) {
        String value = null;
        try {
            if (!new File("config-print.properties").exists()) {
                saveParamChangesDefaultPrint();
            }
            Properties props = new Properties();
            InputStream is = new FileInputStream("config-print.properties");
            props.load(is);

            value = props.getProperty(key);

        } catch (IOException e) {
            System.out.println("Erro ao acessar arquivo config.");
        }

        return value;
    }

    public void saveParamChangesDefaultPrint() throws IOException {

        if (!new File("config-print.properties").exists()) {
            FileWriter fl = new FileWriter(new File("config-print.properties"));
            fl.close();
        }

        try {
            PropertiesConfiguration config = new PropertiesConfiguration("config-print.properties");

            config.setProperty("imprimir", "NAO");

            config.save();

            System.out.println("Arquivo Config Updated..");
        } catch (ConfigurationException ex) {

        }

    }

}
