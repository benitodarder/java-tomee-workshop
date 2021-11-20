# tomee-crud-unmanaged-ds

Properties loaded from:

* Default location within resources
* From external file stated by system property: tomee.crud.service.configuration.path

tomee.xml resource:

  &lt;Resource id="productsDS" type="DataSource"&lgt;
    JdbcDriver org.hsqldb.jdbcDriver
    JdbcUrl jdbc:hsqldb:mem:products
    UserName SA
    Password 
    JtaManaged false
  &lt;/Resource&lgt;
  
