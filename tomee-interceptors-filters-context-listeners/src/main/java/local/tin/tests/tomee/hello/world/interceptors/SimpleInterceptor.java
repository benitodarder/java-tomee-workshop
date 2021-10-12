package local.tin.tests.tomee.hello.world.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author benitodarder
 */
public class SimpleInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleInterceptor.class);

    @AroundInvoke
    public Object intercept(InvocationContext ctx) throws Exception {
        try {
            LOGGER.info("SimpleInterceptor about to proceed...");
            return ctx.proceed();
        } finally {
            LOGGER.info("SimpleInterceptor right after proceeding...");
        }

    }

}
