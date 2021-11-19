package local.tin.tests.tomee.crud.dao;

import local.tin.tests.tomee.crud.dao.ProductDAOConfiguration;
import java.util.Map;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;

/**
 *
 * @author benitodarder
 */
public class ProductDAOConfigurationTest {
    

    @Test
    public void getConfigurationMap_is_not_null() {
        Map<String, String> configurationMap = null;
        Whitebox.setInternalState(ProductDAOConfiguration.class, "configurationMap", configurationMap);
        
        Map<String, String> result = ProductDAOConfiguration.getInstance().getConfigurationMap();
        
        assertThat(result, notNullValue());
    }
    
    @Test
    public void getLogger_returs_class_logger() {
        Logger mockedLogger = mock(Logger.class);
        Whitebox.setInternalState(ProductDAOConfiguration.class, "LOGGER", mockedLogger);
        
        Logger logger = ProductDAOConfiguration.getInstance().getLogger();
        
        assertThat(logger, equalTo(mockedLogger));
    }
            
}
