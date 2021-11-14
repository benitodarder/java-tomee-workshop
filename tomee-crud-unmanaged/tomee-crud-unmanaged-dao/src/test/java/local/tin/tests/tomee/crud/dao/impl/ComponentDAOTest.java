package local.tin.tests.tomee.crud.dao.impl;

import local.tin.tests.tomee.crud.dao.impl.UnitDAO;
import local.tin.tests.tomee.crud.dao.impl.ComponentDAO;
import local.tin.tests.tomee.crud.model.domain.exceptions.DAOException;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author benitodarder
 */
public class ComponentDAOTest extends BaseDAOTest {

    private ComponentDAO dao;
    private local.tin.tests.tomee.crud.model.domain.product.Component domainObject;
    private local.tin.tests.tomee.crud.model.persistence.product.Component dataObject;
    private UnitDAO mockedUnitDAO;
    private local.tin.tests.tomee.crud.model.domain.product.Unit mockedDomainUnit;
    private local.tin.tests.tomee.crud.model.persistence.product.Unit mockedDataUnit;

    
    @Before
    public void setUp() throws DAOException {   
        setUpBaseMocks();
        setAssemblyMocks();
        dao = new ComponentDAO(mockedEntityManagerFactory);
        domainObject = new local.tin.tests.tomee.crud.model.domain.product.Component();
        dataObject = new local.tin.tests.tomee.crud.model.persistence.product.Component();
        mockedUnitDAO = mock(UnitDAO.class);
        when(mockedDAOFactory.getDAO(local.tin.tests.tomee.crud.model.persistence.product.Unit.class)).thenReturn(mockedUnitDAO);
        mockedDomainUnit = mock(local.tin.tests.tomee.crud.model.domain.product.Unit.class);
        mockedDataUnit = mock(local.tin.tests.tomee.crud.model.persistence.product.Unit.class);        
        when(mockedUnitDAO.getDataObject(eq(mockedDomainUnit), anyInt())).thenReturn(mockedDataUnit);
        when(mockedUnitDAO.getDomainObject(eq(mockedDataUnit), anyInt())).thenReturn(mockedDomainUnit);
    }
            
    @Test
    public void updateDomainObjectDepth0Fields_assigns_fields() throws DAOException {
        dataObject.setName(NAME);
        
        dao.updateDomainObjectDepth0Fields(domainObject, dataObject);
        
        assertThat(domainObject.getName(), equalTo(NAME));
    }
    
    @Test
    public void updateDataObjectDepth0Fields_assigns_fields() throws DAOException {
        domainObject.setName(NAME);
        
        dao.updateDataObjectDepth0Fields(domainObject, dataObject);
        
        assertThat(dataObject.getName(), equalTo(NAME));
    }    

    @Test
    public void updateDomainObjectDeeperFields_assigns_fields() throws DAOException {
        dataObject.setUnit(mockedDataUnit);
        dataObject.getAssemblies().add(mockedDataAssembly);
        
        dao.updateDomainObjectDeeperFields(domainObject, dataObject, 0);
        
        assertThat(domainObject.getAssemblies().contains(mockedDomainAssembly), equalTo(true));
        assertThat(domainObject.getUnit(), equalTo(mockedDomainUnit));
    }
    
    @Test
    public void updateDataObjectDeeperFields_assigns_fields() throws DAOException {
        domainObject.setUnit(mockedDomainUnit);
        domainObject.getAssemblies().add(mockedDomainAssembly);
        
        dao.updateDataObjectDeeperFields(domainObject, dataObject, 0);
        
        assertThat(dataObject.getAssemblies().contains(mockedDataAssembly), equalTo(true));
        assertThat(dataObject.getUnit(), equalTo(mockedDataUnit));
    }    
}
