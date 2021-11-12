package local.tin.tests.tomee.crud.service.crud.impl;

import local.tin.tests.tomee.crud.dao.impl.AbstractDAO;
import local.tin.tests.tomee.crud.model.domain.product.Product;


/**
 *
 * @author benitodarder
 */
public class ProductCRUD extends AbstractCRUDService<Product> {

    public ProductCRUD(AbstractDAO dao) {
        super(dao);
    }
  
    
    
}
