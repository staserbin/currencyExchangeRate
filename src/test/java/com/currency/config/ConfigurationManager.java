package com.currency.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationManager {

    private static Properties properties;
    private static final String propertyFilePath = "src/test/resources/configuration.properties";

    public static Properties propertiesReader() {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("configuration.properties not found at " + propertyFilePath);
        }
        return properties;
    }

    public String getDriverPath(){
        String driverPath = propertiesReader().getProperty("webdriver.chrome.driver");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }

    public long getImplicitlyWait() {
        String implicitlyWait = propertiesReader().getProperty("implicitlyWait");
        if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public static String getAPIUrl() {
        String url = propertiesReader().getProperty("api.base.uri");
        if(url != null) return url;
        else throw new RuntimeException("api.base.uri not specified in the Configuration.properties file.");
    }
}
