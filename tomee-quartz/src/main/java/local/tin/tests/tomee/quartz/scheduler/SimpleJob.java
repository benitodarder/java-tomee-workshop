package local.tin.tests.tomee.quartz.scheduler;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Startup
@Singleton
public class SimpleJob {

  private static final Logger LOGGER = LoggerFactory.getLogger(SimpleJob.class);
  
  @Resource
  private SessionContext sessionContext;


  // METHODS

  @PostConstruct
  void init() {

     LOGGER.info("SimpleJob initilized!!");
  }

  // poner tiempo concreto
  @Schedule(second="30", minute = "*", hour = "*")
  public void scheduledMethod() {

     LOGGER.info("Running scheduled task in: " + System.getProperty("simple.job.identifier"));

  }


}
