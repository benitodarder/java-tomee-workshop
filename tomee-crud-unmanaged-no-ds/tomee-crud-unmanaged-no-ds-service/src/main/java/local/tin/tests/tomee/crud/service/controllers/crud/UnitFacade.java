package local.tin.tests.tomee.crud.service.controllers.crud;

import javax.ws.rs.Path;
import local.tin.tests.tomee.crud.model.domain.exceptions.ServiceException;
import local.tin.tests.tomee.crud.model.domain.product.Unit;
import local.tin.tests.tomee.crud.service.crud.impl.AbstractCRUDService;
import local.tin.tests.tomee.crud.service.crud.impl.ProductCRUDServiceFactory;
import local.tin.tests.tomee.crud.service.crud.impl.UnitCRUD;


/**
 *
 * @author benitodarder
 */
@Path("/crud/unit")
public class UnitFacade extends AbstractCRUDResource<Unit>{

    private final UnitCRUD crud;
    

    public UnitFacade() throws ServiceException {
        crud = (UnitCRUD) ProductCRUDServiceFactory.getInstance().getCRUD(Unit.class);
    }
    
    @Override
    protected Class<Unit> getCRUDClass() {
        return Unit.class;
    }

    @Override
    protected AbstractCRUDService getCRUDService() {
        return crud;
    }
    
        
}
