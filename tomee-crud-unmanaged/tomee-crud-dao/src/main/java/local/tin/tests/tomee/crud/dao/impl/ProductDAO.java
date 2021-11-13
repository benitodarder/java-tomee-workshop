package local.tin.tests.tomee.crud.dao.impl;

import javax.persistence.EntityManagerFactory;
import local.tin.tests.tomee.crud.model.domain.exceptions.DAOException;
import local.tin.tests.tomee.crud.model.persistence.product.Assembly;
import local.tin.tests.tomee.crud.model.persistence.product.Product;

/**
 *
 * @author benito.darder
 */
public class ProductDAO extends AbstractEnableableDAO<local.tin.tests.tomee.crud.model.domain.product.Product, Product> {

    public ProductDAO(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected Class<Product> getDAOClass() {
        return Product.class;
    }

    @Override
    protected local.tin.tests.tomee.crud.model.domain.product.Product getDomainObjectNewInstance() {
        return new local.tin.tests.tomee.crud.model.domain.product.Product();
    }

    @Override
    protected Product getDataObjectNewInstance() {
        return new Product();
    }

    @Override
    protected local.tin.tests.tomee.crud.model.domain.product.Product updateDomainObjectDepth0Fields(local.tin.tests.tomee.crud.model.domain.product.Product domainObject, Product dataObject) throws DAOException {
        domainObject.setDescription(dataObject.getDescription());
        domainObject.setName(dataObject.getName());
        return domainObject;
    }

    @Override
    protected local.tin.tests.tomee.crud.model.domain.product.Product updateDomainObjectDeeperFields(local.tin.tests.tomee.crud.model.domain.product.Product domainObject, Product dataObject, int depth) throws DAOException {
        AssemblyDAO assemblyDAO = (AssemblyDAO) ProductDAOFactory.getInstance().getDAO(Assembly.class);
        for (Assembly current : dataObject.getAssemblies()) {
            domainObject.getAssemblies().add(assemblyDAO.getDomainObject(current, depth));
        }
        return domainObject;
    }

    @Override
    protected Product updateDataObjectDepth0Fields(local.tin.tests.tomee.crud.model.domain.product.Product domainObject, Product dataObject) throws DAOException {
        dataObject.setName(domainObject.getName());
        dataObject.setDescription(domainObject.getDescription());
        return dataObject;
    }

    @Override
    protected Product updateDataObjectDeeperFields(local.tin.tests.tomee.crud.model.domain.product.Product domainObject, Product dataObject, int depth) throws DAOException {
        AssemblyDAO assemblyDAO = (AssemblyDAO) ProductDAOFactory.getInstance().getDAO(Assembly.class);
        for (local.tin.tests.tomee.crud.model.domain.product.Assembly current : domainObject.getAssemblies()) {
            dataObject.getAssemblies().add(assemblyDAO.getDataObject(current, depth));
        }        
        return dataObject;
    }

}
