package com.qa.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties prop;

    /**
     * This method is used to load the properties from config.properties file
     * @return it returns Properties prop object
     * @throws IOException
     */
    public Properties init_prop() throws IOException {
        prop = new Properties();
        FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
        prop.load(ip);

        return prop;
    }
}
