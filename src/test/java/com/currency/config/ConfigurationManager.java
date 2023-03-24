package com.currency.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ConfigurationManager {
    public static Properties getPropertyObject() throws IOException {
        FileInputStream propFile = new FileInputStream("src/test/resources/project.properties");
        Properties prop = new Properties();
        prop.load(propFile);
        return prop;
    }

    public static String getUrl() throws IOException {
        return getPropertyObject().getProperty("api.base.uri");
    }
}
