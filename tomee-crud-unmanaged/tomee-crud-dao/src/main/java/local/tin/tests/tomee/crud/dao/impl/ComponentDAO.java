package local.tin.tests.tomee.crud.dao.impl;

import javax.persistence.EntityManagerFactory;
import local.tin.tests.tomee.crud.model.domain.exceptions.DAOException;
import local.tin.tests.tomee.crud.model.persistence.product.Assembly;
import local.tin.tests.tomee.crud.model.persistence.product.Component;
import local.tin.tests.tomee.crud.model.persistence.product.Unit;

/**
 *
 * @author benito.darder
 */
public class ComponentDAO extends AbstractEnableableDAO<local.tin.tests.tomee.crud.model.domain.product.Component, Component> {

    public ComponentDAO(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected Class<Component> getDAOClass() {
        return Component.class;
    }

    @Override
    protected local.tin.tests.tomee.crud.model.domain.product.Component getDomainObjectNewInstance() {
        return new local.tin.tests.tomee.crud.model.domain.product.Component();
    }

    @Override
    protected Component getDataObjectNewInstance() {
        return new Component();
    }

    @Override
    protected local.tin.tests.tomee.crud.model.domain.product.Component updateDomainObjectDepth0Fields(local.tin.tests.tomee.crud.model.domain.product.Component domainObject, Component dataObject) throws DAOException {
        domainObject.setName(dataObject.getName());
        return domainObject;
    }

    @Override
    protected local.tin.tests.tomee.crud.model.domain.product.Component updateDomainObjectDeeperFields(local.tin.tests.tomee.crud.model.domain.product.Component domainObject, Component dataObject, int depth) throws DAOException {
        UnitDAO unitDAO = (UnitDAO) ProductDAOFactory.getInstance().getDAO(Unit.class);
        domainObject.setUnit(unitDAO.getDomainObject(dataObject.getUnit(), depth - 1));
        AssemblyDAO assemblyDAO = (AssemblyDAO) ProductDAOFactory.getInstance().getDAO(Assembly.class);
        for (Assembly current : dataObject.getAssemblies()) {
            domainObject.getAssemblies().add(assemblyDAO.getDomainObject(current, depth));
        }
        return domainObject;
    }

    @Override
    protected Component updateDataObjectDepth0Fields(local.tin.tests.tomee.crud.model.domain.product.Component domainObject, Component dataObject) throws DAOException {
        dataObject.setName(domainObject.getName());
        return dataObject;
    }

    @Override
    protected Component updateDataObjectDeeperFields(local.tin.tests.tomee.crud.model.domain.product.Component domainObject, Component dataObject, int depth) throws DAOException {
        UnitDAO unitDAO = (UnitDAO) ProductDAOFactory.getInstance().getDAO(Unit.class);
        dataObject.setUnit(unitDAO.getDataObject(domainObject.getUnit(), depth));
        AssemblyDAO assemblyDAO = (AssemblyDAO) ProductDAOFactory.getInstance().getDAO(Assembly.class);
        for (local.tin.tests.tomee.crud.model.domain.product.Assembly current : domainObject.getAssemblies()) {
            dataObject.getAssemblies().add(assemblyDAO.getDataObject(current, depth));
        }
        return dataObject;
    }

}
