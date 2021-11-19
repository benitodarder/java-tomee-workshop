# tomee-crud-unmanaged-ds

tome.xml resource:


  &lt;Resource id="productsDS" type="DataSource"&gt;
    JdbcDriver org.hsqldb.jdbcDriver
    JdbcUrl jdbc:hsqldb:mem:products
    UserName=SA
    Password=
    testWhileIdle	true
    testOnBorrow	true
    testOnReturn	false
    validationQuery	SELECT 1 FROM INFORMATION_SCHEMA.SYSTEM_USERS
    TimeBetweenEvictionRunsMillis 30000
    # connectionProperties	"useUnicode=yes;characterEncoding=utf8;"
    DataSourceCreator dbcp
    accessToUnderlyingConnectionAllowed	true
    maxWaitMillis       5000
    maxConnLifetimeMillis       300000
    accessToUnderlyingConnectionAllowed true
    removeAbandonedOnMaintenance        true
    removeAbandonedTimeout      60
    JtaManaged false
  &lt;/Resource&gt;
