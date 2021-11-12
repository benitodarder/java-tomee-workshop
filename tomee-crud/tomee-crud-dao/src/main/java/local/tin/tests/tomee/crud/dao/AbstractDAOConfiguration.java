package local.tin.tests.tomee.crud.dao;

import local.tin.tests.tomee.crud.model.domain.exceptions.DAOException;
import local.tin.tests.tomee.crud.model.domain.exceptions.ServiceException;



/**
 * Extensions must initialize configuration with a call to resetConfiguration
 *
 * @author benito.darder
 */
public abstract class AbstractDAOConfiguration extends AbstractConfiguration {

    public static final String DAO_PERSISTENCE_UNIT = "dao.persistence.unit";
    public static final String DAO_BASE_PACKAGE = "dao.implementation.package";
    public static final String CRUD_BASE_PACKAGE = "crud.base.package";
    public static final String MODEL_DOMAIN_PACKAGE = "model.domain.package";
 
    /**
     * Set persistence unit name.
     *
     * @param persistenceUnit
     */
    public void setPersistenceUnit(String persistenceUnit) {
        getConfigurationMap().put(DAO_PERSISTENCE_UNIT, persistenceUnit);
    }

    public String getPersistenceUnit() throws DAOException {
        String persistenceUnit = getConfigurationMap().get(DAO_PERSISTENCE_UNIT);
        if (persistenceUnit == null || persistenceUnit.isEmpty()) {
            throw new DAOException("Persistence unit name not configured");
        }
        return persistenceUnit;
    }

    /**
     * Set base package string for DAO classes:
     *
     * base package + . + class simple name + DAO
     *
     * @param basePackage
     */
    public void setDAOBasePackage(String basePackage) {
        getConfigurationMap().put(DAO_BASE_PACKAGE, basePackage);
    }

    public String getDAOBasePackage() throws DAOException {
        String daoBasePackage = getConfigurationMap().get(DAO_BASE_PACKAGE);
        if (daoBasePackage == null || daoBasePackage.isEmpty()) {
            throw new DAOException("DAO base package not configured: base package + . + class simple name + DAO");
        }
        return daoBasePackage;
    }

    /**
     * Set cbase package string for CRUD classes:
     *
     * @param basePackage
     */
    public void setCRUDBasePackage(String basePackage) {
        getConfigurationMap().put(CRUD_BASE_PACKAGE, basePackage);
    }

    public String getCRUDBasePackage() throws ServiceException {
        String crudBasePackage = getConfigurationMap().get(CRUD_BASE_PACKAGE);
        if (crudBasePackage == null || crudBasePackage.isEmpty()) {
            throw new ServiceException("CRUD base package not configured: base package + . + class simple name");
        }
        return crudBasePackage;
    }
    
    public void setModelDomainPackage(String modelDomainPackage) {
        getConfigurationMap().put(MODEL_DOMAIN_PACKAGE, modelDomainPackage);
    }
    
    public String getModelDomainPackage() {
        return getConfigurationMap().get(MODEL_DOMAIN_PACKAGE);
    }      
}
