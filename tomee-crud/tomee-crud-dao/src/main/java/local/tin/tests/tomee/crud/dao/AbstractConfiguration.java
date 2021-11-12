package local.tin.tests.tomee.crud.dao;

import java.util.Map;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author benito.darder
 */
public abstract class AbstractConfiguration {
       
    public abstract Map<String, String> getConfigurationMap();

    public abstract Logger getLogger();    
 
    public void resetConfiguration() {
        getConfigurationMap().clear();
    }

    public void loadProperties(Properties properties) {
        for (Map.Entry<Object,Object> current : properties.entrySet()) {
            getConfigurationMap().put((String) current.getKey(), (String) current.getValue());
        }
    }
        
}
