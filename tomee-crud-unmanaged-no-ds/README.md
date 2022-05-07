# tomee-crud-unmanaged-no-ds

Properties to include in system.properties:

    #============================================================================
    # Sample CRUD project configuration.
    #============================================================================
    dao.persistence.unit=productsNODS
    dao.implementation.package=local.tin.tests.tomee.crud.dao.impl
    crud.base.package=local.tin.tests.tomee.crud.service.crud.impl
    model.domain.package=local.tin.tests.tomee.crud.model.domain.product
