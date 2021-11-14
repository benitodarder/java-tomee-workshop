package local.tin.tests.tomee.crud.service.crud.impl;

import local.tin.tests.tomee.crud.dao.impl.AbstractDAO;
import local.tin.tests.tomee.crud.model.domain.product.Assembly;



/**
 *
 * @author benitodarder
 */
public class AssemblyCRUD extends AbstractCRUDService<Assembly> {

    public AssemblyCRUD(AbstractDAO dao) {
        super(dao);
    }
    
}
