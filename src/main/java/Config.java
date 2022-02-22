import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private final String configPath = "config.properties";
    private FileInputStream propertyFile;
    private Properties PROPERTIES;

    public Config() {
        try {
            propertyFile = new FileInputStream(configPath);
            PROPERTIES = new Properties();
            PROPERTIES.load(propertyFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String val){
        return PROPERTIES.getProperty(val);
    }
}
