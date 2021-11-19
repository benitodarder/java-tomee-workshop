# tomee-crud-unmanaged-ds

tome.xml resource:

  &lt;Resource id="productsDS" type="DataSource"&gt;<br/>
    JdbcDriver org.hsqldb.jdbcDriver<br/>
    JdbcUrl jdbc:hsqldb:mem:products<br/>
    UserName=SA<br/>
    Password=<br/>
    testWhileIdle	true<br/>
    testOnBorrow	true<br/>
    testOnReturn	false<br/>
    validationQuery	SELECT 1 FROM INFORMATION_SCHEMA.SYSTEM_USERS<br/>
    TimeBetweenEvictionRunsMillis 30000<br/>
    # connectionProperties	"useUnicode=yes;characterEncoding=utf8;"<br/>
    DataSourceCreator dbcp<br/>
    accessToUnderlyingConnectionAllowed	true<br/>
    maxWaitMillis       5000<br/>
    maxConnLifetimeMillis       300000<br/>
    accessToUnderlyingConnectionAllowed true<br/>
    removeAbandonedOnMaintenance        true<br/>
    removeAbandonedTimeout      60<br/>
    JtaManaged false<br/>
  &lt;/Resource&gt;<br/>
