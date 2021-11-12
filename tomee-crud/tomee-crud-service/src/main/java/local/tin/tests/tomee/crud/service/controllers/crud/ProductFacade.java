package local.tin.tests.tomee.crud.service.controllers.crud;

import javax.ws.rs.Path;
import local.tin.tests.tomee.crud.model.domain.exceptions.ServiceException;
import local.tin.tests.tomee.crud.model.domain.product.Product;
import local.tin.tests.tomee.crud.service.crud.impl.AbstractCRUDService;
import local.tin.tests.tomee.crud.service.crud.impl.ProductCRUD;
import local.tin.tests.tomee.crud.service.crud.impl.ProductCRUDServiceFactory;



/**
 *
 * @author benitodarder
 */
@Path("/crud/product")
public class ProductFacade extends AbstractCRUDResource<Product> {
    
    private final ProductCRUD crud;

    public ProductFacade() throws ServiceException {
        crud = (ProductCRUD) ProductCRUDServiceFactory.getInstance().getCRUD(Product.class);
    }
  
    @Override
    protected Class<Product> getCRUDClass() {
        return Product.class;
    }

    @Override
    protected AbstractCRUDService getCRUDService() {
        return crud;
    }
    
}
