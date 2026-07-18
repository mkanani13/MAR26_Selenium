package riteshMali.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyOperations {
    Properties properties;

    public PropertyOperations(String filePath) {
        File file = new File(filePath);
        try {
            FileInputStream fis = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getValue(String key) {
        return properties.getProperty(key);

    }


}
