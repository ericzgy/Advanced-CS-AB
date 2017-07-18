public class MyException extends Exception {
    
    /** Constructor: an instance with message m*/
    public MyException(String m) {
        super(m);
    }
    
    /** Constructor: an instance with no message */
    public MyException() {
        super();
    }
}