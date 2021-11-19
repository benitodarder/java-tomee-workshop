package local.tin.tests.tomee.crud.service.crud.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import local.tin.tests.tomee.crud.dao.impl.AbstractDAO;
import local.tin.tests.tomee.crud.dao.impl.AbstractDAOFactory;
import local.tin.tests.tomee.crud.model.domain.exceptions.DAOException;
import local.tin.tests.tomee.crud.model.domain.exceptions.ServiceException;
import org.slf4j.Logger;

/**
 *
 * @author benitodarder
 */
public abstract class AbstractCRUDServiceFactory {
    
    private final AbstractDAOFactory baseDAOFactory;

    protected AbstractCRUDServiceFactory(AbstractDAOFactory baseDAOFactory) {
        this.baseDAOFactory = baseDAOFactory;
    }

    protected abstract Logger getLogger(); 

    public AbstractCRUDService getCRUD(Class klass) throws ServiceException {
        try {
            String crudFullName = getCRUDFullName(klass);
            Class<?> daoClass = Class.forName(crudFullName);
            Constructor<?> constructor = daoClass.getDeclaredConstructor(AbstractDAO.class);
            AbstractDAO abstractDAO = baseDAOFactory.getDAO(klass);
            return (AbstractCRUDService) constructor.newInstance(abstractDAO);
        } catch (DAOException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException ex) {
            throw new ServiceException("Could not instantiate CRUD for class: " + klass.getSimpleName(), ex);
        } 
    }

    private String getCRUDFullName(Class klass) throws ServiceException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getCRUDServicesPackage()).append(".").append(klass.getSimpleName()).append("CRUD");
        return stringBuilder.toString();
    }

    protected abstract String getCRUDServicesPackage();
    
    public AbstractCRUDService getCRUD(String className) throws ServiceException {
        Class klass;
        try {
            klass = Class.forName(className);
        } catch (ClassNotFoundException ex) {
            throw new ServiceException("Could not instantiate CRUD for class: " + className, ex);
        }
        return getCRUD(klass);
    }     
    
}
