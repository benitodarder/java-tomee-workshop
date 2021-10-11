package local.tin.tests.tomee.hello.world.filters;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author benitodarder
 */
public class SimpleFilter implements javax.servlet.Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("SimpleFilter before doFilter");
        filterChain.doFilter(request, response);
        LOGGER.info("SimpleFilter after doFilter");
    }

    @Override
    public void init(FilterConfig fc) throws ServletException {

    }

    @Override
    public void destroy() {

    }

}
