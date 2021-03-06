package local.tin.tests.tomee.crud.dao;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author benito.darder
 */
public class ProductDAOConfiguration extends AbstractDAOConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductDAOConfiguration.class);
    private static Map<String, String> configurationMap;

    private ProductDAOConfiguration() {
    }

    public static synchronized ProductDAOConfiguration getInstance() {

        if (configurationMap == null) {
            configurationMap = new HashMap<>();
        }
        return DAOConfigurationConfigurationHolder.INSTANCE;
    }

    private static class DAOConfigurationConfigurationHolder {

        private static final ProductDAOConfiguration INSTANCE = new ProductDAOConfiguration();

        private DAOConfigurationConfigurationHolder() {
        }
    }

    @Override
    public Map<String, String> getConfigurationMap() {
        return configurationMap;
    }

    @Override
    public Logger getLogger() {
        return LOGGER;
    }

}
