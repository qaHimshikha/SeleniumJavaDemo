package HelperMethods;

import java.io.*;
import java.util.Properties;

public class FetchPropertiesFileData {
    public String fetchPropertiesData(String key) {
        Properties propData = new Properties();
        try {
            String propertiesFile = System.getProperty("user.dir") + "/src/test/java/TestData/Data.properties";
            propData.load(new FileReader(propertiesFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propData.getProperty(key);
    }
}