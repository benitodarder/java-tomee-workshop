package local.tin.tests.tomee.crud.service.controllers.crud;

import javax.ws.rs.Path;
import local.tin.tests.tomee.crud.model.domain.exceptions.ServiceException;
import local.tin.tests.tomee.crud.model.domain.product.Component;
import local.tin.tests.tomee.crud.service.crud.impl.AbstractCRUDService;
import local.tin.tests.tomee.crud.service.crud.impl.ComponentCRUD;
import local.tin.tests.tomee.crud.service.crud.impl.ProductCRUDServiceFactory;


/**
 *
 * @author benitodarder
 */
@Path("/crud/component")
public class ComponentFacade extends AbstractCRUDResource<Component> {
    
    private final ComponentCRUD crud;

    public ComponentFacade() throws ServiceException {
        crud = (ComponentCRUD) ProductCRUDServiceFactory.getInstance().getCRUD(Component.class);
    }

    @Override
    protected Class<Component> getCRUDClass() {
        return Component.class;
    }

    @Override
    protected AbstractCRUDService getCRUDService() {
        return crud;
    }
    
}
