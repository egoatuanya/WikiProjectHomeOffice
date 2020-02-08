package org.wikipedia.app.utilities;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Settings {

    public static String getTestConfig(String keyName)
    {
        String testConfigFile ="/src/main/resources/testSettings.properties";
        String filePath = System.getProperty("user.dir")+ testConfigFile;

        FileInputStream fis = null;

        try {
            fis = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Properties properties = new Properties();
        try {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties.getProperty(keyName);
    }

    public static String getStackConfig(String keyName)
    {
        String testConfigFile ="/src/main/resources/browserStack.properties";
        String filePath = System.getProperty("user.dir")+ testConfigFile;

        FileInputStream fis = null;

        try {
            fis = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Properties properties = new Properties();
        try {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties.getProperty(keyName);
    }
}

