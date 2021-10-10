package local.tin.tests.tomee.hello.world.services;

/**
 *
 * @author benitodarder
 */
public class UpperCaserImpl implements UpperCaser {
    
    @Override
    public String transform(String source) {
        return source.toUpperCase();
    } 

}
