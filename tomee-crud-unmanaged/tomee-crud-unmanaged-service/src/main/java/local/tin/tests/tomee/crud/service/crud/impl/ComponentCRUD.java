package local.tin.tests.tomee.crud.service.crud.impl;

import local.tin.tests.tomee.crud.dao.impl.AbstractDAO;
import local.tin.tests.tomee.crud.model.domain.product.Component;


/**
 *
 * @author benitodarder
 */
public class ComponentCRUD extends AbstractCRUDService<Component>{

    public ComponentCRUD(AbstractDAO dao) {
        super(dao);
    }
    
}
