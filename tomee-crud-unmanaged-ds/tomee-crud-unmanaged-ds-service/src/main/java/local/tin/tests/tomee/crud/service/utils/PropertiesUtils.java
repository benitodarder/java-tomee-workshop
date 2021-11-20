package local.tin.tests.tomee.crud.service.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author benitodarder
 */
public class PropertiesUtils {

    private PropertiesUtils() {
    }

    public static PropertiesUtils getInstance() {
        return PropertiesUtilsHolder.INSTANCE;
    }

    private static class PropertiesUtilsHolder {
        private static final PropertiesUtils INSTANCE = new PropertiesUtils();
    }
    
        /**
     * Opens the specified file path, and returns a Properties with the included
     * properties.
     *
     * @param filePath String
     * @return Properties
     * @throws FileNotFoundException
     * @throws IOException
     */
    public Properties getPropertiesFile(String filePath) throws IOException {
        try ( InputStream fileInputStream = new FileInputStream(filePath)) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties;
        }

    }
    
        /**
     * Opens the specified file path, and returns a Properties with the included
     * properties.
     *
     * @param klass
     * @param fileName
     * @return Properties
     * @throws IOException
     */
    public Properties getPropertiesFileFromResources(String fileName) throws IOException {
        InputStreamReader fileInputStream = new InputStreamReader(PropertiesUtils.class.getResourceAsStream(fileName));
        Properties properties = new Properties();
        properties.load(fileInputStream);
        return properties;
    }  
 }
