package local.tin.tests.tomee.crud.service.crud.impl;

import local.tin.tests.tomee.crud.dao.impl.AbstractDAO;
import local.tin.tests.tomee.crud.model.domain.product.Unit;


/**
 *
 * @author benitodarder
 */
public class UnitCRUD extends AbstractCRUDService<Unit> {

    public UnitCRUD(AbstractDAO dao) {
        super(dao);
    }
   
}
