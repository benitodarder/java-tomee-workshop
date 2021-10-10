set CATALINA_HOME=<Tomee folder>
set CATALINA_BASE=<Catalina base folder>
set JAVA_HOME=<JDK home path>
set JPDA_TRANSPORT=dt_socket
set JPDA_ADDRESS=<AVAILABLE PORT>
set JPDA_SUSPEND=<Whaits for debug connected? y/n>
set JPDA_OPTS=-agentlib:jdwp=transport=%JPDA_TRANSPORT%,address=%JPDA_ADDRESS%,server=y,suspend=%JPDA_SUSPEND%


