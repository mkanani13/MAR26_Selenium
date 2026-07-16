package onkarPatil.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropFileOperations {

    private Properties prop;

    public PropFileOperations(String filePath){
        File file = new File(filePath);

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            prop = new Properties();
            prop.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getValue(String key){
        return prop.getProperty(key);
    }
}
