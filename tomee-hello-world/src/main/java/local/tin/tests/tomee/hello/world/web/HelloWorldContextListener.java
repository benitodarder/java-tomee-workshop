package local.tin.tests.tomee.hello.world.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author benito.darder
 */
@WebListener
public class HelloWorldContextListener implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
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
