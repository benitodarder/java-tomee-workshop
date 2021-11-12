package local.tin.tests.tomee.crud.service.web;

import java.util.Map;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import local.tin.tests.tomee.crud.dao.ProductDAOConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author benito.darder
 */
@WebListener
public class CRUDContextListener implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(CRUDContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Map<String, String> map = ProductDAOConfiguration.getInstance().getConfigurationMap();
        map.put(ProductDAOConfiguration.CRUD_BASE_PACKAGE, System.getProperty(ProductDAOConfiguration.CRUD_BASE_PACKAGE));
        map.put(ProductDAOConfiguration.DAO_BASE_PACKAGE, System.getProperty(ProductDAOConfiguration.DAO_BASE_PACKAGE));
        map.put(ProductDAOConfiguration.DAO_PERSISTENCE_UNIT, System.getProperty(ProductDAOConfiguration.DAO_PERSISTENCE_UNIT));
        map.put(ProductDAOConfiguration.MODEL_DOMAIN_PACKAGE, System.getProperty(ProductDAOConfiguration.MODEL_DOMAIN_PACKAGE));
        LOGGER.info("****************************************************************");
        LOGGER.info("*                                                              *");
        LOGGER.info("*       ServletContextListener: Context initialized!           *");
        LOGGER.info("*                                                              *");
        LOGGER.info("****************************************************************");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOGGER.info("****************************************************************");
        LOGGER.info("*                                                              *");
        LOGGER.info("*       ServletContextListener: Context destroyed!             *");
        LOGGER.info("*                                                              *");
        LOGGER.info("****************************************************************");
    }
}
