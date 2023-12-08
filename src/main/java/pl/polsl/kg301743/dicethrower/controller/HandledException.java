package pl.polsl.kg301743.dicethrower.controller;

/**
 *  Class responsible for handling exceptions in program
 * @author Krystian Gagracz
 */
public class HandledException extends Exception {
    /**Code of exception defined in constructor*/
    private String code;

    /**Constructor creating an exception instance with error code and message
     * @param code code of error
     * @param message message of error 
     */
    public HandledException(String code, String message) {
        super(message);
        this.setCode(code);
    }
    
    /**Error code getter
     * @return error code
     */
    final public String getCode() {
        return code;
    }

    /**Error code setter
     * @param code error code
      */
    final public void setCode(String code) {
        this.code = code;
    }
}
