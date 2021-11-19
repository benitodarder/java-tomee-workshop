package local.tin.tests.tomee.crud.service.interfaces;

import java.util.List;
import local.tin.tests.tomee.crud.model.domain.exceptions.ServiceException;
import local.tin.tests.tomee.crud.model.domain.interfaces.IIdentifiable;




/**
 *
 * @author benitodarder
 * @param <C>
 */
public interface IAbstractService<C extends IIdentifiable> {

    /**
     * Inserts a new element in the system
     * 
     * @param c of C
     * @return C
     * @throws ServiceException 
     */
    public C insert(C c) throws ServiceException;

    /**
     * List all elements from the system
     * 
     * @return List of C
     * @throws ServiceException 
     */
    public List<C> listAll() throws ServiceException;

    /**
     * Updates entity elements.
     * 
     * @param c of C
     * @return C
     * @throws ServiceException 
     */
    public C update(C c) throws ServiceException;

    /**
     * Inserts a new element in the system
     * 
     * @param id
     * @return C
     * @throws ServiceException 
     */
    public C retrieveById(Object id) throws ServiceException;
}
