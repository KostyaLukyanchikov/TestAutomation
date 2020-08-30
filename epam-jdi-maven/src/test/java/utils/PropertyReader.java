package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {

    private static Properties properties;
    private static String propPath = "src/test/resources/config.properties";

    public static Properties getInstance() {
        if (properties == null) {
            getPropValues();
        }
        return properties;
    }

    public static void getPropValues() {
        properties = new Properties();
        try (FileInputStream props = new FileInputStream(propPath)) {
            properties.load(props);
        } catch (Exception e) {
            System.out.println("Properties File Not Found...");
            e.printStackTrace();
        }
    }

}
