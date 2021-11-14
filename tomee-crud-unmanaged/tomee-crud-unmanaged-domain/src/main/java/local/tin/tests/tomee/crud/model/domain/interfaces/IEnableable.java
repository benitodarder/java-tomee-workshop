package local.tin.tests.tomee.crud.model.domain.interfaces;

/**
 *
 * @author benitodarder
 */
public interface IEnableable extends IIdentifiable {
    
    /**
     * Returns enabled/disabled status
     * 
     * @return boolean
     */
    public boolean isEnabled();
    
    /**
     * Sets enabled/disabled status
     * 
     * @param enabled boolean
     */
    public void setEnabled(boolean enabled);    
    
}
