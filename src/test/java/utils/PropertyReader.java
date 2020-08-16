package utils;

import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class PropertyReader {

    private static PropertyReader instance;
    private static Properties properties;
    private static String propPath = "src/test/resources/config.properties";

    public static synchronized PropertyReader getInstance() {
        if (instance == null) {
            instance = new PropertyReader();
            instance.getPropValues();
        }
        return instance;
    }

    public void getPropValues() {
        properties = new Properties();

        try (FileInputStream props = new FileInputStream(propPath)) {
            properties.load(props);
        } catch (Exception e) {
            System.out.println("Properties File Not Found...");
            e.printStackTrace();
        }

    }


    public String getDataFromProperties(String key) {
        return properties.getProperty(key, null);
    }

}
