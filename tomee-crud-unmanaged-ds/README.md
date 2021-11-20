# tomee-crud-unmanaged-ds

Properties loaded from:

* Default location within resources
* From external file stated by system property: tomee.crud.service.configuration.path

tomee.xml resource:

  &lt;Resource id="productsDS" type="DataSource"&gt;<br/>
    JdbcDriver org.hsqldb.jdbcDriver<br/>
    JdbcUrl jdbc:hsqldb:mem:products<br/>
    UserName SA<br/>
    Password <br/>
    JtaManaged false<br/>
  &lt;/Resource&gt;<br/>
  
