package local.tin.tests.tomee.crud.dao.impl;

import javax.persistence.EntityManagerFactory;
import local.tin.tests.tomee.crud.model.persistence.interfaces.IEmbeddable;
import local.tin.tests.tomee.crud.model.domain.exceptions.DAOException;
import local.tin.tests.tomee.crud.model.domain.interfaces.ICompositeId;
import local.tin.tests.tomee.crud.model.persistence.embeddables.AssemblyId;
import local.tin.tests.tomee.crud.model.persistence.product.Assembly;
import local.tin.tests.tomee.crud.model.persistence.product.Component;
import local.tin.tests.tomee.crud.model.persistence.product.Product;

/**
 *
 * @author benito.darder
 */
public class AssemblyDAO extends AbstractEnableableDAO<local.tin.tests.tomee.crud.model.domain.product.Assembly, Assembly> {

    public AssemblyDAO(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected Class<Assembly> getDAOClass() {
        return Assembly.class;
    }

    @Override
    protected AssemblyId getEmmbeddedId(ICompositeId domainObject) throws DAOException {
        AssemblyId embeddable = new AssemblyId();
        embeddable.setComponentId(((local.tin.tests.tomee.crud.model.domain.compositeIds.AssemblyId) domainObject).getComponentId());
        embeddable.setProductId(((local.tin.tests.tomee.crud.model.domain.compositeIds.AssemblyId) domainObject).getProductId());
        return embeddable;
    }

    @Override
    protected local.tin.tests.tomee.crud.model.domain.compositeIds.AssemblyId getCompositedId(IEmbeddable dataObject) throws DAOException {
        local.tin.tests.tomee.crud.model.domain.compositeIds.AssemblyId compositeId = new local.tin.tests.tomee.crud.model.domain.compositeIds.AssemblyId();
        compositeId.setComponentId(((AssemblyId) dataObject).getComponentId());
        compositeId.setProductId(((AssemblyId) dataObject).getProductId());
        return compositeId;
    }

    @Override
    protected local.tin.tests.tomee.crud.model.domain.product.Assembly getDomainObjectNewInstance() {
        return new local.tin.tests.tomee.crud.model.domain.product.Assembly();
    }

    @Override
    protected Assembly getDataObjectNewInstance() {
        return new Assembly();
    }

    @Override
    protected local.tin.tests.tomee.crud.model.domain.product.Assembly updateDomainObjectDepth0Fields(local.tin.tests.tomee.crud.model.domain.product.Assembly domainObject, Assembly dataObject) throws DAOException {
        domainObject.setQuantity(dataObject.getQuantity());
        return domainObject;
    }

    @Override
    protected local.tin.tests.tomee.crud.model.domain.product.Assembly updateDomainObjectDeeperFields(local.tin.tests.tomee.crud.model.domain.product.Assembly domainObject, Assembly dataObject, int depth) throws DAOException {
        ComponentDAO componentDAO = (ComponentDAO) ProductDAOFactory.getInstance().getDAO(Component.class);
        domainObject.setComponent(componentDAO.getDomainObject(dataObject.getComponent(), DEFAULT_DEPTH_ENTITY));
        ProductDAO productDAO = (ProductDAO) ProductDAOFactory.getInstance().getDAO(Product.class);
        domainObject.setProduct(productDAO.getDomainObject(dataObject.getProduct(), DEFAULT_DEPTH_ENTITY));
        return domainObject;
    }

    @Override
    protected Assembly updateDataObjectDepth0Fields(local.tin.tests.tomee.crud.model.domain.product.Assembly domainObject, Assembly dataObject) throws DAOException {
        dataObject.setQuantity(domainObject.getQuantity());
        return dataObject;
    }

    @Override
    protected Assembly updateDataObjectDeeperFields(local.tin.tests.tomee.crud.model.domain.product.Assembly domainObject, Assembly dataObject, int depth) throws DAOException {
        return dataObject;
    }

}
