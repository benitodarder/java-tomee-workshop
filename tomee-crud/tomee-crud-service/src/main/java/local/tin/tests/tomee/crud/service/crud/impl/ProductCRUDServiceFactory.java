package local.tin.tests.tomee.crud.service.crud.impl;


import local.tin.tests.tomee.crud.dao.impl.AbstractDAOFactory;
import local.tin.tests.tomee.crud.dao.impl.ProductDAOFactory;
import org.apache.log4j.Logger;

/**
 *
 * @author benitodarder
 */
public class ProductCRUDServiceFactory extends AbstractCRUDServiceFactory {

    private static final Logger LOGGER = Logger.getLogger(ProductCRUDServiceFactory.class);

    private ProductCRUDServiceFactory(AbstractDAOFactory baseDAOFactory) {
        super(baseDAOFactory);
    }

    public static ProductCRUDServiceFactory getInstance() {
        return ProductCRUDServiceFactoryHolder.INSTANCE;
    }

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

    private static class ProductCRUDServiceFactoryHolder {

        private static final ProductCRUDServiceFactory INSTANCE = new ProductCRUDServiceFactory(ProductDAOFactory.getInstance());
    }
    
    @Override
    protected String getCRUDServicesPackage() {
        return "local.tin.tests.tomee.crud.service.crud.impl";
    }
    
}
