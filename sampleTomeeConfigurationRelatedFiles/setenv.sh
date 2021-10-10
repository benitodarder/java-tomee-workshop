export CATALINA_HOME=<Tomee folder>
export CATALINA_BASE=<Catalina base folder>
export JAVA_HOME=<JDK home path>
export JPDA_TRANSPORT=dt_socket
export JPDA_ADDRESS=<AVAILABLE PORT>
export JPDA_SUSPEND=<Waits for debug connected? y/n>
export JPDA_OPTS="-agentlib:jdwp=transport=$JPDA_TRANSPORT,address=$JPDA_ADDRESS,server=y,suspend=$JPDA_SUSPEND"

