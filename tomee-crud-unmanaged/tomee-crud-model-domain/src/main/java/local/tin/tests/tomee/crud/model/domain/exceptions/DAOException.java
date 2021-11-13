package local.tin.tests.tomee.crud.model.domain.exceptions;

/**
 *
 * @author benito.darder
 */
public class DAOException extends CommonException {

    public DAOException() {
    }
    
    public DAOException(Exception e) {
        super(e);
    }
    
    public DAOException(String string) {
        super(string);
    }

    public DAOException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public DAOException(Throwable thrwbl) {
        super(thrwbl);
    }    
}
