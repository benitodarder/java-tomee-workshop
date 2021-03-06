package local.tin.tests.tomee.crud.model.domain.enums;

/**
 *
 * @author benito.darder
 */
public enum ErrorCode {
    
    UNKNOWN("UNKNOWN");
    
    private final String errorCode;

    ErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }    
}
