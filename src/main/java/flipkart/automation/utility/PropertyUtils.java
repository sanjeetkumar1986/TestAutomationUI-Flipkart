package flipkart.automation.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {
    private static final Logger log = LoggerFactory.getLogger(PropertyUtils.class);
    static Properties properties;

    public PropertyUtils() {

    }


    public static String getValue(String path, String key) {
        File file = new File(path);
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return properties.getProperty(key);
    }
}