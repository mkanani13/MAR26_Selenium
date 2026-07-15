package jayeshSonawane.technocreditsFoodAppWithFrameworkPOM.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyOperations {

    Properties properties;

    public PropertyOperations(String filePath) {
        File file = new File(filePath);//File init x - not reading operation yet
        try {
            FileInputStream fileInputStream = new FileInputStream(file); //File Check for it's existintance
            //Java class from util package
            properties = new Properties();
            properties.load(fileInputStream);//File loading for reading operations in memory
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getValue(String key) {
        String value = properties.getProperty(key);
        return value;
    }

//    public static void main(String[] args) throws IOException {
//        PropertyOperations configPropety = new PropertyOperations("src/technocredits/technoapp/config/config.properties");
//        configPropety.getValue("ACCESSCODE");
//        configPropety.getValue("STUDENTID");
//
//        PropertyOperations userConfig = new PropertyOperations("src/technocredits/technoapp/config/userConfig.properties");
//        userConfig.getValue("");
//    }


}