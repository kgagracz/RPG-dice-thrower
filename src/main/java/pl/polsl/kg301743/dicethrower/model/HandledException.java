package pl.polsl.kg301743.dicethrower.model;

/**
 *  Class responsible for handling exceptions in program
 * @author Krystian Gagracz
 */
public class HandledException extends Exception {
    /**Code of exception defined in constructor*/
        public enum ErrorCode {
        BAD_INPUT
    }
    /**Code of exception defined in constructor*/
    private ErrorCode code;


    /**Constructor creating an exception instance with error code and message
     * @param code code of error
     * @param message message of error 
     */
    public HandledException(ErrorCode code, String message) {
        super(message);
        this.setCode(code);
    }
    
    /**Error code getter
     * @return error code
     */
    final public ErrorCode getCode() {
        return code;
    }

    /**Error code setter
     * @param code error code
      */
    final public void setCode(ErrorCode code) {
        this.code = code;
    }
}
