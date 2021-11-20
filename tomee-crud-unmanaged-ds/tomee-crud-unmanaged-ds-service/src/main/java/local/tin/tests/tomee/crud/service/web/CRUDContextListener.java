package local.tin.tests.tomee.crud.service.web;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import local.tin.tests.tomee.crud.dao.ProductDAOConfiguration;
import local.tin.tests.tomee.crud.service.utils.PropertiesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author benito.darder
 */
@WebListener
public class CRUDContextListener implements ServletContextListener {

    public static final String CONFIGURATION_FILE_PROPERTY = "tomee.crud.service.configuration.path";
    public static final String CONFIGURATION_FILE_DEFAULT_NAME = "/crud.service.properties";
    private static final Logger LOGGER = LoggerFactory.getLogger(CRUDContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Properties properties;
            if (System.getProperty(CONFIGURATION_FILE_PROPERTY) != null && !System.getProperty(CONFIGURATION_FILE_PROPERTY).isEmpty()) {
                properties = PropertiesUtils.getInstance().getPropertiesFile(System.getProperty(CONFIGURATION_FILE_PROPERTY));
                 LOGGER.info(" Loading configuration from external file: {}", System.getProperty(CONFIGURATION_FILE_PROPERTY));
            } else {
                properties = PropertiesUtils.getInstance().getPropertiesFileFromResources(CONFIGURATION_FILE_DEFAULT_NAME);
                LOGGER.info(" Loading from default resources location.");
            }
            Map<String, String> map = ProductDAOConfiguration.getInstance().getConfigurationMap();
            map.put(ProductDAOConfiguration.CRUD_BASE_PACKAGE, properties.getProperty(ProductDAOConfiguration.CRUD_BASE_PACKAGE));
            map.put(ProductDAOConfiguration.DAO_BASE_PACKAGE, properties.getProperty(ProductDAOConfiguration.DAO_BASE_PACKAGE));
            map.put(ProductDAOConfiguration.DAO_PERSISTENCE_UNIT, properties.getProperty(ProductDAOConfiguration.DAO_PERSISTENCE_UNIT));
            map.put(ProductDAOConfiguration.MODEL_DOMAIN_PACKAGE, properties.getProperty(ProductDAOConfiguration.MODEL_DOMAIN_PACKAGE));
        } catch (Exception e) {
            LOGGER.error(" ServletContextListener: Context NOT initialized! ", e);
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOGGER.info("ServletContextListener: Context destroyed!");
    }
}
